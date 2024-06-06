package gestaodeobras.projetogestaodeobras;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;


public class LoginController {

    @FXML
    private Button botaoCadastrar;

    @FXML
    private Button botaoEntrar;

    @FXML
    private MenuItem botaoSair;

    @FXML
    private MenuItem botaoSobre;

    @FXML
    private TextField campoCPF;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private VBox telaLogin;

    @FXML
    void abrirTelaCadastro(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("telaCadastro.fxml"));
            Scene cenaCadastro = new Scene(loader.load());

            CadastroController controllerCadastro = loader.getController();

            Stage stage = (Stage) botaoCadastrar.getScene().getWindow();

            stage.setScene(cenaCadastro);
            stage.setTitle("Cadastro");
            stage.setResizable(false);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected int verificarLogin(String cpf, String senha) {
        String url = "jdbc:sqlite:bancodedados.db";
        int id = -1;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                String sql = "SELECT id FROM usuarios WHERE cpf = ? AND senha = ?";

                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, cpf);
                    stmt.setString(2, senha);

                    try (ResultSet rs = stmt.executeQuery()) {
                        if (rs.next()) {
                            id = rs.getInt("id");
                            idUsuario = id;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao verificar login no banco de dados: " + e.getMessage());
        }

        return id;
    }

    protected static int idUsuario;

    protected static int getIdUsuario() {
        return idUsuario;
    }

    protected static void setIdUsuario(int id) {
        idUsuario = id;
    }

    @FXML
    void acessarSistema(ActionEvent event) {
        String cpf = campoCPF.getText();
        String senha = campoSenha.getText();

        int userId = verificarLogin(cpf, senha);

        if (userId != -1) {
            String primeiroNome = obterPrimeiroNomeDoUsuario(userId);
            abrirTelaPrincipal(primeiroNome);
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro no Login");
            alert.setHeaderText(null);
            alert.setContentText("CPF ou senha inválidos. Por favor, verifique seus dados.");

            alert.showAndWait();
        }
    }

    private String obterPrimeiroNomeDoUsuario(int userId) {
        String url = "jdbc:sqlite:bancodedados.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                String sql = "SELECT nomeCompleto FROM usuarios WHERE id = ?";

                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setInt(1, userId);

                    try (ResultSet rs = stmt.executeQuery()) {
                        if (rs.next()) {
                            String nomeCompleto = rs.getString("nomeCompleto");
                            String[] partesNome = nomeCompleto.split(" ");
                            return partesNome[0];
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao obter o primeiro nome do usuário: " + e.getMessage());
        }

        return null;
    }

    private void abrirTelaPrincipal(String primeiroNome) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("telaPrincipal.fxml"));
            Scene cenaPrincipal = new Scene(loader.load());

            TelaPrincipal controllerPrincipal = loader.getController();

            Stage stage = (Stage) botaoEntrar.getScene().getWindow();

            stage.setScene(cenaPrincipal);
            stage.setTitle("Início");

            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();

            stage.setX(bounds.getMinX() + (bounds.getWidth() - cenaPrincipal.getWidth()) / 2);
            stage.setY(bounds.getMinY() + (bounds.getHeight() - cenaPrincipal.getHeight()) / 2);

            controllerPrincipal.setLabelUsuarioText(primeiroNome);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exibirAlerta(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    void mostrarSobre(ActionEvent event) {
        exibirAlerta("Sobre","Aplicação voltada para construção civil permitindo " +
                "o gerenciamento de clientes, agenda e inventário de ferramentas do mestre de obra." +
                "\n\nProjeto desenvolvido sem fins lucrativos pelo aluno:" +
                "\nVinicius Batista Checchetto\n" +
                "da Universidade Estácio de Sá - Campo Grande RJ.");
    }

    @FXML
    void sair(ActionEvent event) {
        System.exit(0);
    }
}
