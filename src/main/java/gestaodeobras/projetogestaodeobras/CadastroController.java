package gestaodeobras.projetogestaodeobras;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.Region;


import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.io.File;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


public class CadastroController {

    @FXML
    private Button botaoCancelar;

    @FXML
    private Button botaoConfirmarCadastro;

    @FXML
    private MenuItem botaoSobre;

    @FXML
    private PasswordField campoConfirmarSenha;

    @FXML
    private TextField campoCpfCadastro;

    @FXML
    private TextField campoEmail;

    @FXML
    private TextField campoNomeCompleto;

    @FXML
    private PasswordField campoSenhaCadastro;

    @FXML
    void confirmarCadastro(ActionEvent event) {
        String nomeCompleto = campoNomeCompleto.getText();
        String cpf = campoCpfCadastro.getText();
        String email = campoEmail.getText();
        String senha = campoSenhaCadastro.getText();

        if (nomeCompleto.isEmpty() || cpf.isEmpty() || email.isEmpty() || senha.isEmpty()) {
            Alert alertCampoEmBranco = new Alert(AlertType.WARNING);
            alertCampoEmBranco.setTitle("Erro no cadastro");
            alertCampoEmBranco.setHeaderText(null);
            alertCampoEmBranco.setContentText("Por favor, preencha todos os campos.");
            alertCampoEmBranco.showAndWait();
            return;
        }

        boolean cpfValido = validarCPF(campoCpfCadastro.getText());
        boolean emailValido = validarEmail(campoEmail.getText());
        boolean senhaValida = validarSenha();

        if (cpfValido && emailValido && senhaValida) {
            Alert confirmacao = new Alert(AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação de Cadastro");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("Por favor, confirme se os dados estão corretos.\n\n"
                    + "Nome Completo: " + campoNomeCompleto.getText() + "\n"
                    + "CPF: " + campoCpfCadastro.getText() + "\n"
                    + "E-mail: " + campoEmail.getText());

            ButtonType botaoSim = new ButtonType("Sim");
            ButtonType botaoNao = new ButtonType("Não");
            confirmacao.getButtonTypes().setAll(botaoSim, botaoNao);

            ButtonType resposta = confirmacao.showAndWait().orElse(botaoNao);

            if (resposta == botaoSim) {
                cadastrarUsuario(nomeCompleto, cpf, email, senha);
            } else {
                confirmacao.close();
            }
        } else {
            StringBuilder mensagemErro = new StringBuilder("Por favor, corrija os seguintes erros:\n");

            if (!cpfValido) {
                mensagemErro.append("- CPF inválido\n");
            }

            if (!emailValido) {
                mensagemErro.append("- E-mail inválido\n");
            }

            if (!senhaValida) {
                mensagemErro.append("- Senhas não coincidem\n");
            }

            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro no cadastro");
            alert.setHeaderText(null);
            alert.setContentText(mensagemErro.toString());

            alert.showAndWait();
        }
    }

    private void cadastrarUsuario(String nomeCompleto, String cpf, String email, String senha) {
        String url = "jdbc:sqlite:bancodedados.db";

        File arquivoBanco = new File("bancodedados.db");

        if (!arquivoBanco.exists()) {
            try {
                if (arquivoBanco.createNewFile()) {
                    System.out.println("Arquivo do banco de dados criado com sucesso.");
                } else {
                    System.err.println("Falha ao criar o arquivo do banco de dados.");
                    return;
                }
            } catch (IOException e) {
                System.err.println("Erro ao criar o arquivo do banco de dados: " + e.getMessage());
                return;
            }
        }

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Conexão com o banco de dados estabelecida.");

                // Criar a tabela de usuários
                String sql = "CREATE TABLE IF NOT EXISTS usuarios (\n"
                        + "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                        + "    nomeCompleto TEXT,\n"
                        + "    cpf TEXT,\n"
                        + "    email TEXT,\n"
                        + "    senha TEXT\n"
                        + ");";

                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.execute();
                }

                sql = "INSERT INTO usuarios (nomeCompleto, cpf, email, senha) VALUES (?, ?, ?, ?);";

                try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                    stmt.setString(1, nomeCompleto);
                    stmt.setString(2, cpf);
                    stmt.setString(3, email);
                    stmt.setString(4, senha);

                    if (cpfJaCadastrado(cpf)) {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Erro no Cadastro");
                        alert.setHeaderText(null);
                        alert.setContentText("CPF já cadastrado. Por favor, verifique o CPF.");
                        alert.showAndWait();
                    } else {
                        int rowsAffected = stmt.executeUpdate();
                        if (rowsAffected > 0) {
                            Alert confirmacao = new Alert(AlertType.INFORMATION);
                            confirmacao.setTitle("Cadastro Confirmado");
                            confirmacao.setHeaderText(null);
                            confirmacao.setContentText("Usuário cadastrado com sucesso.");
                            confirmacao.showAndWait();

                            voltarParaTelaDeLogin();
                            System.out.println("Usuário cadastrado com sucesso.");
                        } else {
                            System.out.println("Falha ao cadastrar o usuário.");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    private boolean cpfJaCadastrado(String cpf) {
        String url = "jdbc:sqlite:bancodedados.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                String sql = "SELECT COUNT(*) FROM usuarios WHERE cpf = ?";

                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, cpf);

                    try (ResultSet rs = stmt.executeQuery()) {
                        if (rs.next()) {
                            int count = rs.getInt(1);
                            return count > 0;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao verificar CPF no banco de dados: " + e.getMessage());
        }

        return false;
    }

    private void voltarParaTelaDeLogin() {
        Stage stage = (Stage) botaoConfirmarCadastro.getScene().getWindow();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Login");
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void cancelarCadastro(ActionEvent event) {
        Stage stage = (Stage) botaoCancelar.getScene().getWindow();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Login");
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void limparDados(ActionEvent event) {
        campoCpfCadastro.clear();
        campoEmail.clear();
        campoNomeCompleto.clear();
        campoSenhaCadastro.clear();
        campoConfirmarSenha.clear();
    }

    @FXML
    void mostrarSobre(ActionEvent event) {
        exibirAlerta("Sobre","Aplicação voltada para construção civil permitindo " +
                "o gerenciamento de clientes, agenda e inventário de ferramentas do mestre de obra." +
                "\n\nProjeto desenvolvido sem fins lucrativos pelo aluno:" +
                "\nVinicius Batista Checchetto\n" +
                "da Universidade Estácio de Sá - Campo Grande RJ.");
    }

    private void exibirAlerta(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private boolean validarSenha() {
        String senha = campoSenhaCadastro.getText();
        String confirmarSenha = campoConfirmarSenha.getText();
        return senha.equals(confirmarSenha);
    }

    private boolean validarEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }


    private boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            return false;
        }

        boolean digitosIguais = true;
        for (int i = 1; i < 11; i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                digitosIguais = false;
                break;
            }
        }
        if (digitosIguais) {
            return false;
        }

        int[] digitos = new int[11];
        for (int i = 0; i < 11; i++) {
            digitos[i] = cpf.charAt(i) - '0';
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += digitos[i] * (10 - i);
        }

        int resto = soma % 11;
        int primeiroDigitoVerificador = (resto < 2) ? 0 : 11 - resto;

        if (digitos[9] != primeiroDigitoVerificador) {
            return false;
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += digitos[i] * (11 - i);
        }

        resto = soma % 11;
        int segundoDigitoVerificador = (resto < 2) ? 0 : 11 - resto;

        return digitos[10] == segundoDigitoVerificador;
    }

}
