package gestaodeobras.projetogestaodeobras;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.text.Font;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Region;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ChoiceBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import javafx.beans.property.SimpleObjectProperty;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.stage.Screen;

import javafx.util.Duration;
import java.util.Locale;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import javafx.util.converter.NumberStringConverter;

import java.time.ZonedDateTime;


import javafx.application.Platform;

import javafx.stage.Stage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.Statement;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;

import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.ZonedDateTime;

import java.io.File;
import java.io.IOException;

public class TelaPrincipal {

    @FXML
    private Label ano;

    @FXML
    private Button botaoAddServico;

    @FXML
    private Button botaoAtrasado;

    @FXML
    private Button botaoAdicionarFerramenta;

    @FXML
    private Button botaoAgenda;

    @FXML
    private Button botaoBuscarFerramenta;

    @FXML
    private Button botaoAdicionarServico;

    @FXML
    private Button botaoBuscar;

    @FXML
    private Button botaoBuscarPagamentos;

    @FXML
    private Button botaoCadastrarCliente;

    @FXML
    private Button botaoCadastrarClientes;

    @FXML
    private Button botaoCadastrarServico;

    @FXML
    private Button botaoClientes;

    @FXML
    private Button botaoConfirmarBuscaClientes;

    @FXML
    private Button botaoEditarRegistro;

    @FXML
    private Button botaoExcluirRegistroCliente;

    @FXML
    private Button botaoExcluirRegistroServico;

    @FXML
    private Button botaoExcluirFerramenta;

    @FXML
    private Button botaoFerramentas;

    @FXML
    private Button botaoFecharTelaServico;

    @FXML
    private Button botaoFecharTelaCadastrar;

    @FXML
    private Button botaoFecharTelaBuscarFerramenta;

    @FXML
    private Button botaoFecharTelaEditar;

    @FXML
    private Button botaoFecharTelaVisualizar;

    @FXML
    private Button botaoInicio;

    @FXML
    private Button botaoLimparDadosCliente;

    @FXML
    private Button botaoCancelarClienteE;

    @FXML
    private Button botaoLimparDadosServico;

    @FXML
    private Button botaoLimparPesquisaPag;

    @FXML
    private Button botaoPagamentos;

    @FXML
    private Button botaoPago;

    @FXML
    private Button botaoSair;

    @FXML
    private Button botaoNuvem;

    @FXML
    private Button botaoSalvarCliente;

    @FXML
    private FlowPane calendario;

    @FXML
    private TextField campoBairroCliente;

    @FXML
    private TextField campoBairroClienteE;

    @FXML
    private TextField campoBairroClienteV;

    @FXML
    private TextField campoBuscarClientes;

    @FXML
    private TextField campoBuscarFerramenta;

    @FXML
    private TextField campoBuscarPagamentos;

    @FXML
    private TextField campoCelularCliente;

    @FXML
    private TextField campoCelularClienteE;

    @FXML
    private TextField campoCelularClienteV;

    @FXML
    private ChoiceBox<String> campoClienteServico;

    @FXML
    private ChoiceBox<String> campoSituacaoPagServico;

    @FXML
    private TextField campoCpfCnpjCliente;

    @FXML
    private TextField campoCpfCnpjClienteE;

    @FXML
    private TextField campoCpfCnpjClienteV;

    @FXML
    private TextField campoCpfCnpjClienteServico;

    @FXML
    private DatePicker campoDataServicoFim;

    @FXML
    private DatePicker campoDataServicoInicio;

    @FXML
    private TextField campoEmailCliente;

    @FXML
    private TextField campoEmailClienteE;

    @FXML
    private TextField campoEmailClienteV;

    @FXML
    private TextField campoEnderecoCliente;

    @FXML
    private TextField campoEnderecoClienteE;

    @FXML
    private TextField campoEnderecoClienteV;

    @FXML
    private ComboBox<String> campoFormaPagServico;

    @FXML
    private ComboBox<String> comboBoxProcurarCliente;

    @FXML
    private ComboBox<String> comboBoxProcurarPagamento;

    @FXML
    private ComboBox<String> campoLocalFerramenta;

    @FXML
    private TextField campoMunicipioCliente;

    @FXML
    private TextField campoMunicipioClienteE;

    @FXML
    private TextField campoMunicipioClienteV;

    @FXML
    private TextField campoNomeCliente;

    @FXML
    private TextField campoNomeClienteE;

    @FXML
    private TextField campoNomeClienteV;

    @FXML
    private TextField campoNomeFerramenta;

    @FXML
    private TextField campoOutrasInfoFerramenta;

    @FXML
    private TextField campoValorServico;

    @FXML
    private GridPane gridPaneInicio;

    @FXML
    private Label hora;

    @FXML
    private Label labelUsuario;

    @FXML
    private Label mes;

    @FXML
    private Label proximoCliente;

    @FXML
    private Label clienteAtual;

    @FXML
    private Label dataInicioProximoCliente;

    @FXML
    private Label enderecoClienteAtual;

    @FXML
    private Label enderecoProximoCliente;

    @FXML
    private Label dataFimClienteAtual;

    public void exibirServicoAtual() {
        int userId = LoginController.getIdUsuario();
        String jdbcUrl = "jdbc:sqlite:bancodedados.db";
        String query = "SELECT s.nomeCliente, " +
                "strftime('%d/%m/%Y', datetime(s.dataInicio / 1000, 'unixepoch')) as dataInicio, " +
                "strftime('%d/%m/%Y', datetime(s.dataFim / 1000, 'unixepoch')) as dataFim, " +
                "c.endereco " +
                "FROM servicos s " +
                "INNER JOIN clientes c ON s.cpfCnpj = c.cpfCnpj " +
                "WHERE s.UserId = ? AND date(s.dataInicio / 1000, 'unixepoch') <= date('now') AND date(s.dataFim / 1000, 'unixepoch') >= date('now') " +
                "ORDER BY s.idServico";

        try (Connection connection = DriverManager.getConnection(jdbcUrl);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String nomeCliente = resultSet.getString("nomeCliente");
                String dataFim = resultSet.getString("dataFim");
                String endereco = resultSet.getString("endereco");

                clienteAtual.setText(nomeCliente);
                dataFimClienteAtual.setText(dataFim);
                enderecoClienteAtual.setText(endereco);
            } else {
                clienteAtual.setText("Não há serviço.");
                dataFimClienteAtual.setText("");
                enderecoClienteAtual.setText("");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void exibirProximoServico() {
        int userId = LoginController.getIdUsuario();
        String jdbcUrl = "jdbc:sqlite:bancodedados.db";

        String queryProximoServico = "SELECT s.idServico, s.nomeCliente, " +
                "strftime('%d/%m/%Y', datetime(s.dataInicio / 1000, 'unixepoch')) as dataInicio, " +
                "strftime('%d/%m/%Y', datetime(s.dataFim / 1000, 'unixepoch')) as dataFim, " +
                "c.endereco " +
                "FROM servicos s " +
                "INNER JOIN clientes c ON s.cpfCnpj = c.cpfCnpj " +
                "WHERE s.UserId = ? AND date(s.dataInicio / 1000, 'unixepoch') > date('now') " +
                "ORDER BY s.dataInicio ASC LIMIT 1";

        try (Connection connection = DriverManager.getConnection(jdbcUrl);
             PreparedStatement preparedStatement = connection.prepareStatement(queryProximoServico)) {

            preparedStatement.setInt(1, userId);

            ResultSet resultSetProximo = preparedStatement.executeQuery();

            if (resultSetProximo.next()) {
                String nomeClienteProximo = resultSetProximo.getString("nomeCliente");
                String dataInicioProximo = resultSetProximo.getString("dataInicio");
                String enderecoProximo = resultSetProximo.getString("endereco");

                proximoCliente.setText(nomeClienteProximo);
                dataInicioProximoCliente.setText(dataInicioProximo);
                enderecoProximoCliente.setText(enderecoProximo);
            } else {
                proximoCliente.setText("Não há serviço.");
                dataInicioProximoCliente.setText("");
                enderecoProximoCliente.setText("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private MenuItem menuItemAgenda;

    @FXML
    private MenuItem menuItemBuscarFerramenta;

    @FXML
    private MenuItem menuItemCadastrarCliente;

    @FXML
    private MenuItem menuItemAddServ;

    @FXML
    private MenuItem menuItemClientes;

    @FXML
    private MenuItem menuItemComoUsar;

    @FXML
    private MenuItem menuItemDesconectar;

    @FXML
    private MenuItem menuItemFerramentas;

    @FXML
    private MenuItem menuItemInicio;

    @FXML
    private MenuItem menuItemPag;

    @FXML
    private MenuItem menuItemSair;

    @FXML
    private MenuItem menuItemSobre;

    @FXML
    private StackPane stackPaneAgenda;

    @FXML
    private StackPane stackPaneBuscar;

    @FXML
    private StackPane stackPaneCadastrar;

    @FXML
    private StackPane stackPaneCadastrarServico;

    @FXML
    private StackPane stackPaneClientes;

    @FXML
    private StackPane stackPaneFerramentas;

    @FXML
    private StackPane stackPanePagamentos;

    @FXML
    private StackPane stackPaneEditar;

    @FXML
    private StackPane stackPaneVisualizarCliente;

    @FXML
    private TableColumn<Cliente, String> tipoClienteCol;

    @FXML
    private TableColumn<Cliente, String> nomeCol;

    @FXML
    private TableColumn<Cliente, String> cpfCnpjCol;

    @FXML
    private TableColumn<Cliente, String> enderecoCol;

    @FXML
    private TableColumn<Cliente, String> bairroCol;

    @FXML
    private TableColumn<Cliente, String> celularCol;

    @FXML
    private TableColumn<Cliente, String> emailCol;

    @FXML
    private TableColumn<Pagamento, String> tipoColPag;

    @FXML
    private TableColumn<Pagamento, String> nomeColPag;

    @FXML
    private TableColumn<Pagamento, String> cpfCnpjColPag;

    @FXML
    private TableColumn<Pagamento, Date> dataInicioColPag;

    @FXML
    private TableColumn<Pagamento, Date> dataFimColPag;

    @FXML
    private TableColumn<Pagamento, Double> valorColPag;

    @FXML
    private TableColumn<Pagamento, String> situacaoColPag;

    @FXML
    private TableColumn<Ferramentas, String> nomeFerramentaCol;

    @FXML
    private TableColumn<Ferramentas, String> localizacaoFerramentaCol;

    @FXML
    private TableColumn<Ferramentas, String> outrasInfoFerramentaCol;

    @FXML
    private TableView<Cliente> tabelaClientes;

    @FXML
    private TableView<Ferramentas> tabelaFerramentas;

    @FXML
    private TableView<Pagamento> tabelaPagamentos;

    @FXML
    void atualizarAtrasado(ActionEvent event) {
        Pagamento pagamentoSelecionado = tabelaPagamentos.getSelectionModel().getSelectedItem();

        if (pagamentoSelecionado == null) {
            exibirAlerta("Erro", "Nenhum serviço selecionado.");
        } else if (pagamentoSelecionado != null) {
            int idServico = pagamentoSelecionado.getIdServico();

            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:bancodedados.db");
                 PreparedStatement statement = conn.prepareStatement("UPDATE servicos SET situacaoPagamento = ? WHERE idServico = ?")) {

                String novaSituacaoPagamento = "Em Atraso";
                statement.setString(1, novaSituacaoPagamento);
                statement.setInt(2, idServico);

                int rowsUpdated = statement.executeUpdate();

                if (rowsUpdated > 0) {
                    exibirAlerta("Confirmado", "Situação de pagamento atualizada com sucesso.");
                    carregarDadosPagamentos();
                } else {
                    exibirAlerta("Erro", "Não foi possível atualizar a situação de pagamento.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    void atualizarPago(ActionEvent event) {
        Pagamento pagamentoSelecionado = tabelaPagamentos.getSelectionModel().getSelectedItem();

        if (pagamentoSelecionado == null) {
            exibirAlerta("Erro", "Nenhum serviço selecionado.");
        } else if (pagamentoSelecionado != null) {
            int idServico = pagamentoSelecionado.getIdServico();

            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:bancodedados.db");
                 PreparedStatement statement = conn.prepareStatement("UPDATE servicos SET situacaoPagamento = ? WHERE idServico = ?")) {

                String novaSituacaoPagamento = "Pago";
                statement.setString(1, novaSituacaoPagamento);
                statement.setInt(2, idServico);

                int rowsUpdated = statement.executeUpdate();

                if (rowsUpdated > 0) {
                    exibirAlerta("Confirmado", "Situação de pagamento atualizada com sucesso.");
                    carregarDadosPagamentos();
                } else {
                    exibirAlerta("Erro", "Não foi possível atualizar a situação de pagamento.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void carregarDadosClientes() {
        ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();

        int idUsuario = LoginController.getIdUsuario();

        if (idUsuario == -1) {
            return;
        }

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:bancodedados.db");
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM clientes WHERE userId = ?")) {

            statement.setInt(1, idUsuario);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Cliente cliente = new Cliente(
                        id,
                        resultSet.getString("tipoCliente"),
                        resultSet.getString("nome"),
                        resultSet.getString("cpfCnpj"),
                        resultSet.getString("endereco"),
                        resultSet.getString("bairro"),
                        resultSet.getString("municipio"),
                        resultSet.getString("celular"),
                        resultSet.getString("email")
                );

                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        tipoClienteCol.setCellValueFactory(cellData -> cellData.getValue().tipoProperty());
        nomeCol.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
        cpfCnpjCol.setCellValueFactory(cellData -> cellData.getValue().cpfCnpjProperty());
        enderecoCol.setCellValueFactory(cellData -> cellData.getValue().enderecoProperty());
        bairroCol.setCellValueFactory(cellData -> cellData.getValue().bairroProperty());
        celularCol.setCellValueFactory(cellData -> cellData.getValue().celularProperty());
        emailCol.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

        tipoClienteCol.setCellFactory(column -> new TableCell<Cliente, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                } else {
                    if (item.equals("Pessoa Física")) {
                        setText("1");
                    } else if (item.equals("Pessoa Jurídica")) {
                        setText("2");
                    } else {
                        setText(item);
                    }
                }
            }
        });

        tabelaClientes.setItems(listaClientes);
    }

    private void carregarDadosPagamentos(){
        ObservableList<Pagamento> listaPagamentos = FXCollections.observableArrayList();

        int idUsuario = LoginController.getIdUsuario();

        if (idUsuario == -1) {
            return;
        }

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:bancodedados.db");
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM servicos WHERE UserId = ? ORDER BY dataInicio ASC")) {

            statement.setInt(1, idUsuario);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                java.sql.Date dataInicioSQL = resultSet.getDate("dataInicio");
                java.sql.Date dataFimSQL = resultSet.getDate("dataFim");

                Date dataInicio = new Date(dataInicioSQL.getTime());
                Date dataFim = new Date(dataFimSQL.getTime());

                int id = resultSet.getInt("idServico");

                Pagamento pagamento = new Pagamento(
                        id,
                        resultSet.getString("tipoCliente"),
                        resultSet.getString("cpfCnpj"),
                        resultSet.getString("nomeCliente"),
                        dataInicio,
                        dataFim,
                        resultSet.getDouble("valorCobrado"),
                        resultSet.getString("situacaoPagamento")
                );

                listaPagamentos.add(pagamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        tipoColPag.setCellValueFactory(cellData -> cellData.getValue().tipoClienteProperty());
        nomeColPag.setCellValueFactory(cellData -> cellData.getValue().nomeClienteProperty());
        cpfCnpjColPag.setCellValueFactory(cellData -> cellData.getValue().cpfCnpjProperty());
        dataInicioColPag.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().dataInicioProperty().get()));
        dataFimColPag.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().dataFimProperty().get()));

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dataInicioColPag.setCellFactory(column -> new TableCell<Pagamento, java.sql.Date>() {
            @Override
            protected void updateItem(java.sql.Date item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                } else {
                    setText(dateFormat.format(item));
                }
            }
        });

        dataFimColPag.setCellFactory(column -> new TableCell<Pagamento, java.sql.Date>() {
            @Override
            protected void updateItem(java.sql.Date item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                } else {
                    setText(dateFormat.format(item));
                }
            }
        });
        valorColPag.setCellValueFactory(cellData -> cellData.getValue().valorCobradoProperty().asObject());
        situacaoColPag.setCellValueFactory(cellData -> cellData.getValue().situacaoPagamentoProperty());

        tipoColPag.setCellFactory(column -> new TableCell<Pagamento, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                } else {
                    if (item.equals("Pessoa Física")) {
                        setText("1");
                    } else if (item.equals("Pessoa Jurídica")) {
                        setText("2");
                    } else {
                        setText(item);
                    }
                }
            }
        });

        tabelaPagamentos.setItems(listaPagamentos);
    }

    @FXML
    void excluirRegistroServico(ActionEvent event) {
        Pagamento pagamentoSelecionado = tabelaPagamentos.getSelectionModel().getSelectedItem();

        if (pagamentoSelecionado == null) {
            exibirAlerta("Erro","Nenhum serviço selecionado.");
            return;
        }

        int idPagamento = pagamentoSelecionado.getIdServico();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmação de Exclusão");
        alert.setHeaderText("Você tem certeza que deseja excluir este serviço?");
        alert.setContentText("Esta ação não pode ser desfeita.");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:bancodedados.db");
                 PreparedStatement statement = conn.prepareStatement("DELETE FROM servicos WHERE idServico = ?")) {

                statement.setInt(1, idPagamento);
                int rowsDeleted = statement.executeUpdate();

                if (rowsDeleted > 0) {
                    exibirAlerta("Confirmado", "Serviço excluído com sucesso.");
                    carregarDadosPagamentos();
                } else {
                    exibirAlerta("Erro", "Não foi possível encontrar o registro especificado.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void setLabelUsuarioText(String primeiroNome) {
        labelUsuario.setText(primeiroNome);
    }

    @FXML
    void abrirAgenda(ActionEvent event) {
        Stage stage = (Stage) botaoAgenda.getScene().getWindow();
        stage.setTitle("Agenda");
        stackPaneAgenda.setVisible(true);
        stackPaneClientes.setVisible(false);
        stackPanePagamentos.setVisible(false);
        stackPaneFerramentas.setVisible(false);
        gridPaneInicio.setVisible(false);
        stackPaneCadastrar.setVisible(false);
        stackPaneBuscar.setVisible(false);
        stackPaneCadastrarServico.setVisible(false);
    }

    @FXML
    void abrirClientes(ActionEvent event) {
        Stage stage = (Stage) botaoClientes.getScene().getWindow();
        stage.setTitle("Clientes");
        stackPaneAgenda.setVisible(false);
        stackPaneClientes.setVisible(true);
        stackPanePagamentos.setVisible(false);
        stackPaneFerramentas.setVisible(false);
        gridPaneInicio.setVisible(false);
        stackPaneCadastrar.setVisible(false);
        stackPaneBuscar.setVisible(false);
        stackPaneCadastrarServico.setVisible(false);
    }

    @FXML
    void abrirPagamentos(ActionEvent event) {
        Stage stage = (Stage) botaoPagamentos.getScene().getWindow();
        stage.setTitle("Pagamentos");
        stackPaneAgenda.setVisible(false);
        stackPaneClientes.setVisible(false);
        stackPanePagamentos.setVisible(true);
        stackPaneFerramentas.setVisible(false);
        gridPaneInicio.setVisible(false);
        stackPaneCadastrar.setVisible(false);
        stackPaneBuscar.setVisible(false);
        stackPaneCadastrarServico.setVisible(false);
    }

    @FXML
    void abrirFerramentas(ActionEvent event) {
        Stage stage = (Stage) botaoFerramentas.getScene().getWindow();
        stage.setTitle("Ferramentas");
        stackPaneAgenda.setVisible(false);
        stackPaneClientes.setVisible(false);
        stackPanePagamentos.setVisible(false);
        stackPaneFerramentas.setVisible(true);
        carregarComboBoxLocalFerramenta();
        gridPaneInicio.setVisible(false);
        stackPaneCadastrar.setVisible(false);
        stackPaneBuscar.setVisible(false);
        stackPaneCadastrarServico.setVisible(false);
    }

    @FXML
    void abrirInicio(ActionEvent event) {
        Stage stage = (Stage) botaoInicio.getScene().getWindow();
        stage.setTitle("Início");
        stackPaneAgenda.setVisible(false);
        stackPaneClientes.setVisible(false);
        stackPanePagamentos.setVisible(false);
        stackPaneFerramentas.setVisible(false);
        exibirServicoAtual();
        exibirProximoServico();
        gridPaneInicio.setVisible(true);
        stackPaneCadastrar.setVisible(false);
        stackPaneBuscar.setVisible(false);
        stackPaneCadastrarServico.setVisible(false);
    }

    @FXML
    void abrirCadastroDeClientes(ActionEvent event) {
        Stage stage = (Stage) botaoCadastrarClientes.getScene().getWindow();
        stage.setTitle("Cadastrar Cliente");
        stackPaneBuscar.setVisible(false);
        stackPaneCadastrarServico.setVisible(false);
        stackPaneCadastrar.setVisible(true);
    }

    @FXML
    void abrirBuscaDeFerramentas(ActionEvent event) {
        Stage stage = (Stage) botaoBuscarFerramenta.getScene().getWindow();
        stage.setTitle("Buscar Ferramenta");
        stackPaneCadastrar.setVisible(false);
        stackPaneCadastrarServico.setVisible(false);
        stackPaneBuscar.setVisible(true);
    }

    @FXML
    void adicionarServico(ActionEvent event) {
        Stage stage = (Stage) botaoAdicionarServico.getScene().getWindow();
        stage.setTitle("Adicionar Serviço");
        stackPaneCadastrar.setVisible(false);
        stackPaneBuscar.setVisible(false);
        stackPaneCadastrarServico.setVisible(true);
        carregarChoiceBoxClienteServico();
    }

    private Map<LocalDate, String> datasReservadas;

    private Map<LocalDate, String> DatasReservadas() {
        int userId = LoginController.getIdUsuario();

        Map<LocalDate, String> reservasComNomes = new HashMap<>();

        String url = "jdbc:sqlite:bancodedados.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            String consultaSQL = "SELECT dataInicio, dataFim, SUBSTR(nomeCliente, 1, INSTR(nomeCliente, ' ') - 1) AS primeiroNome FROM servicos WHERE userId = ?;";

            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) {
                stmt.setInt(1, userId);

                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        LocalDate dataInicio = rs.getDate("dataInicio").toLocalDate();
                        LocalDate dataFim = rs.getDate("dataFim").toLocalDate();
                        String primeiroNome = rs.getString("primeiroNome");

                        while (!dataInicio.isAfter(dataFim)) {
                            reservasComNomes.put(dataInicio, primeiroNome);
                            dataInicio = dataInicio.plusDays(1);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservasComNomes;
    }

    @FXML
    void buscarFerramenta(ActionEvent event) {
        String termoBusca = campoBuscarFerramenta.getText().trim();

        if (!termoBusca.isEmpty()) {
            if (!realizarBuscaFerramentaPorNome(termoBusca)) {
                exibirAlerta("Aviso", "Ferramenta não encontrada.");
                campoBuscarFerramenta.clear();
            }
        } else {
            exibirAlerta("Aviso", "Digite o nome da ferramenta.");
        }
    }

    private boolean realizarBuscaFerramentaPorNome(String nomeFerramenta) {
        ObservableList<Ferramentas> ferramentaEncontrada = FXCollections.observableArrayList();

        int userId = LoginController.getIdUsuario();

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:bancodedados.db");
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM ferramentas WHERE nomeFerramenta LIKE ? AND userId = ?")) {

            statement.setString(1, "%" + nomeFerramenta + "%");
            statement.setInt(2, userId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("idFerramenta");
                String nomeCompletoFerramenta = resultSet.getString("nomeFerramenta");
                String localizacao = resultSet.getString("localizacao");
                String outrasInfo = resultSet.getString("outrasInfo");

                Ferramentas ferramenta = new Ferramentas(id, nomeCompletoFerramenta, localizacao, outrasInfo);
                ferramentaEncontrada.add(ferramenta);
                exibirFerramentaEncontrada(ferramenta);
                campoBuscarFerramenta.clear();
            }
            return !ferramentaEncontrada.isEmpty();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void exibirFerramentaEncontrada(Ferramentas ferramenta) {
        String mensagem = String.format("Ferramenta: \nNome: %s\nLocalização: %s\nOutras informações: %s",
                ferramenta.getNomeFerramenta(), ferramenta.getLocalizacao(), ferramenta.getOutrasInfo());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ferramenta Encontrada");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    @FXML
    void buscarClientes(ActionEvent event) {
        String opcaoSelecionadaCliente = comboBoxProcurarCliente.getValue();
        int userId = LoginController.getIdUsuario();

        if (opcaoSelecionadaCliente != null && !campoBuscarClientes.getText().isEmpty()) {
            String termoBusca = campoBuscarClientes.getText();

            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:bancodedados.db")) {
                String query = "";
                if ("Nome".equals(opcaoSelecionadaCliente)) {
                    query = "SELECT * FROM clientes WHERE nome LIKE ? AND userId = ?";
                } else if ("CPF/CNPJ".equals(opcaoSelecionadaCliente)) {
                    query = "SELECT * FROM clientes WHERE cpfCnpj LIKE ? AND userId = ?";
                }

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, "%" + termoBusca + "%");
                statement.setInt(2, userId);

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    Cliente clienteEncontrado = new Cliente(
                            resultSet.getInt("id"),
                            resultSet.getString("tipoCliente"),
                            resultSet.getString("nome"),
                            resultSet.getString("cpfCnpj"),
                            resultSet.getString("endereco"),
                            resultSet.getString("bairro"),
                            resultSet.getString("municipio"),
                            resultSet.getString("celular"),
                            resultSet.getString("email")
                    );

                    preencherCamposVisualizarCliente(clienteEncontrado);
                    stackPaneVisualizarCliente.setVisible(true);
                    campoBuscarClientes.clear();
                } else {
                    exibirAlerta("Cliente não encontrado", "Nenhum cliente corresponde à busca.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    private void preencherCamposVisualizarCliente(Cliente cliente) {
        if (cliente != null) {
            campoNomeClienteV.setText(cliente.getNome());
            campoCpfCnpjClienteV.setText(cliente.getCpfCnpj());
            campoEnderecoClienteV.setText(cliente.getEndereco());
            campoBairroClienteV.setText(cliente.getBairro());
            campoMunicipioClienteV.setText(cliente.getMunicipio());
            campoCelularClienteV.setText(cliente.getCelular());
            campoEmailClienteV.setText(cliente.getEmail());
        }
    }

    @FXML
    void buscarPagamentos(ActionEvent event) {
        String opcaoSelecionadaPag = comboBoxProcurarPagamento.getValue();

        if (opcaoSelecionadaPag != null) {
            String termoBusca = campoBuscarPagamentos.getText().trim();

            if (!termoBusca.isEmpty()) {
                if ("Nome".equals(opcaoSelecionadaPag)) {
                    realizarBuscaPorNome(termoBusca);
                } else if ("CPF/CNPJ".equals(opcaoSelecionadaPag)) {
                    realizarBuscaPorCpfCnpj(termoBusca);
                }
            } else {
                exibirAlerta("Aviso", "Digite o nome ou CPF/CNPJ do cliente.");
            }
        }
    }

    @FXML
    void limparTabelaPesquisaPag(ActionEvent event) {
        carregarDadosPagamentos();
    }

    private ObservableList<Pagamento> realizarBuscaPorNome(String nome) {
        ObservableList<Pagamento> pagamentosEncontrados = FXCollections.observableArrayList();

        int idUsuario = LoginController.getIdUsuario();

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:bancodedados.db");
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM servicos WHERE nomeCliente LIKE ? AND UserId = ?")) {

            statement.setString(1, "%" + nome + "%");
            statement.setInt(2, idUsuario);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                java.sql.Date dataInicioSQL = resultSet.getDate("dataInicio");
                java.sql.Date dataFimSQL = resultSet.getDate("dataFim");

                Date dataInicio = new Date(dataInicioSQL.getTime());
                Date dataFim = new Date(dataFimSQL.getTime());

                int id = resultSet.getInt("idServico");

                Pagamento pagamento = new Pagamento(
                        id,
                        resultSet.getString("tipoCliente"),
                        resultSet.getString("cpfCnpj"),
                        resultSet.getString("nomeCliente"),
                        dataInicio,
                        dataFim,
                        resultSet.getDouble("valorCobrado"),
                        resultSet.getString("situacaoPagamento")
                );
                pagamentosEncontrados.add(pagamento);
                tabelaPagamentos.setItems(pagamentosEncontrados);
                campoBuscarPagamentos.clear();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pagamentosEncontrados;
    }

    private ObservableList<Pagamento> realizarBuscaPorCpfCnpj(String cpfCnpj) {
        ObservableList<Pagamento> pagamentosEncontrados = FXCollections.observableArrayList();

        int idUsuario = LoginController.getIdUsuario();

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:bancodedados.db");
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM servicos WHERE cpfCnpj LIKE ? AND UserId = ?")) {

            statement.setString(1, "%" + cpfCnpj + "%");
            statement.setInt(2, idUsuario);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                java.sql.Date dataInicioSQL = resultSet.getDate("dataInicio");
                java.sql.Date dataFimSQL = resultSet.getDate("dataFim");

                Date dataInicio = new Date(dataInicioSQL.getTime());
                Date dataFim = new Date(dataFimSQL.getTime());

                int id = resultSet.getInt("idServico");

                Pagamento pagamento = new Pagamento(
                        id,
                        resultSet.getString("tipoCliente"),
                        resultSet.getString("cpfCnpj"),
                        resultSet.getString("nomeCliente"),
                        dataInicio,
                        dataFim,
                        resultSet.getDouble("valorCobrado"),
                        resultSet.getString("situacaoPagamento")
                );
                pagamentosEncontrados.add(pagamento);
                tabelaPagamentos.setItems(pagamentosEncontrados);
                campoBuscarPagamentos.clear();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pagamentosEncontrados;
    }


    @FXML
    void cadastrarCliente(ActionEvent event) {
        String nome = campoNomeCliente.getText();
        String cpfCnpj = campoCpfCnpjCliente.getText();
        String endereco = campoEnderecoCliente.getText();
        String bairro = campoBairroCliente.getText();
        String municipio = campoMunicipioCliente.getText();
        String celular = campoCelularCliente.getText();
        String email = campoEmailCliente.getText();
        int userId = LoginController.getIdUsuario();

        String tipoCliente = determinarTipoCliente(cpfCnpj);

        if (nome.isEmpty() || cpfCnpj.isEmpty() || endereco.isEmpty() || bairro.isEmpty()
                || municipio.isEmpty() || celular.isEmpty() || email.isEmpty()) {
            exibirAlerta("Erro no cadastro", "Por favor, preencha todos os campos.");
            return;
        }

        if (clienteJaExiste(cpfCnpj, userId)) {
            exibirAlerta("Erro no cadastro", "Já existe um cliente com este CPF/CNPJ.");
            return;
        }

        String url = "jdbc:sqlite:bancodedados.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            // Criar a tabela de clientes
            String createTableSQL = "CREATE TABLE IF NOT EXISTS clientes (\n"
                    + "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + "    nome TEXT,\n"
                    + "    cpfCnpj TEXT,\n"
                    + "    endereco TEXT,\n"
                    + "    bairro TEXT,\n"
                    + "    municipio TEXT,\n"
                    + "    celular TEXT,\n"
                    + "    email TEXT,\n"
                    + "    tipoCliente TEXT,\n"
                    + "    userId INTEGER\n"
                    + ");";
            try (PreparedStatement stmt = conn.prepareStatement(createTableSQL)) {
                stmt.execute();
            }

            // Inserir o cliente na tabela
            String insertSQL = "INSERT INTO clientes (nome, cpfCnpj, endereco, bairro, municipio, celular, email, tipoCliente, userId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            try (PreparedStatement stmt = conn.prepareStatement(insertSQL)) {
                stmt.setString(1, nome);
                stmt.setString(2, cpfCnpj);
                stmt.setString(3, endereco);
                stmt.setString(4, bairro);
                stmt.setString(5, municipio);
                stmt.setString(6, celular);
                stmt.setString(7, email);
                stmt.setString(8, tipoCliente);
                stmt.setInt(9, userId);

                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    exibirAlerta("Cadastro Confirmado", "Cliente cadastrado com sucesso.");
                    limparCamposCliente();
                    carregarDadosClientes();
                } else {
                    exibirAlerta("Erro no cadastro", "Falha ao cadastrar o cliente.");
                }
            }
        } catch (SQLException e) {
            exibirAlerta("Erro no cadastro", "Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    private boolean clienteJaExiste(String cpfCnpj, int userId) {
        String url = "jdbc:sqlite:bancodedados.db";
        String query = "SELECT COUNT(*) FROM clientes WHERE cpfCnpj = ? AND userId = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, cpfCnpj);
            stmt.setInt(2, userId);

            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    private String determinarTipoCliente(String cpfCnpj) {
        return cpfCnpj.length() == 11 ? "Pessoa Física" : "Pessoa Jurídica";
    }

    @FXML
    void excluirRegistroCliente(ActionEvent event) {
        Cliente clienteSelecionado = tabelaClientes.getSelectionModel().getSelectedItem();

        if (clienteSelecionado == null) {
            exibirAlerta("Erro", "Nenhum cliente selecionado.");
            return;
        }

        int idCliente = clienteSelecionado.getIdCliente();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmação de Exclusão");
        alert.setHeaderText("Você tem certeza que deseja excluir este cliente?");
        alert.setContentText("Esta ação não pode ser desfeita.");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:bancodedados.db");
                 PreparedStatement statement = conn.prepareStatement("DELETE FROM clientes WHERE id = ?")) {

                statement.setInt(1, idCliente);
                int rowsDeleted = statement.executeUpdate();

                if (rowsDeleted > 0) {
                    exibirAlerta("Confirmado", "Cliente excluído com sucesso.");
                    carregarDadosClientes();
                } else {
                    exibirAlerta("Erro", "Não foi possível encontrar o registro especificado.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @FXML
    void cadastrarServico(ActionEvent event) {
        String tipoCliente = determinarTipoCliente(campoCpfCnpjClienteServico.getText());
        String cpfCnpj = campoCpfCnpjClienteServico.getText();
        String nomeCliente = campoClienteServico.getValue();
        String valorCobradoStr = campoValorServico.getText();
        String formaPagamento = campoFormaPagServico.getValue();
        String situacaoPagamento = campoSituacaoPagServico.getValue();
        int userId = LoginController.getIdUsuario();
        LocalDate dataInicio = campoDataServicoInicio.getValue();
        LocalDate dataFim = campoDataServicoFim.getValue();

        if (valorCobradoStr.isEmpty()) {
            exibirAlerta("Erro no cadastro", "Por favor, preencha todos campos.");
            return;
        }

        valorCobradoStr = valorCobradoStr.replace(",", ".");
        double valorCobrado = Double.parseDouble(valorCobradoStr);

        try {
            valorCobrado = Double.parseDouble(valorCobradoStr);
        } catch (NumberFormatException e) {
            exibirAlerta("Erro no cadastro", "O valor do serviço não é válido.");
            return;
        }

        if (dataInicio == null || dataFim == null) {
            exibirAlerta("Erro no cadastro", "Por favor, selecione as datas de início e fim do serviço.");
            return;
        }

        if (dataFim.isBefore(dataInicio)) {
            exibirAlerta("Erro no cadastro", "A data final não poderá ser anterior à data de início do serviço.");
            return;
        }

        String url = "jdbc:sqlite:bancodedados.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS servicos (\n"
                    + "    idServico INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + "    tipoCliente TEXT,\n"
                    + "    cpfCnpj TEXT,\n"
                    + "    nomeCliente TEXT,\n"
                    + "    dataInicio DATE,\n"
                    + "    dataFim DATE,\n"
                    + "    valorCobrado REAL,\n"
                    + "    formaPagamento TEXT,\n"
                    + "    situacaoPagamento TEXT,\n"
                    + "    userId INTEGER\n"
                    + ");";
            try (PreparedStatement stmt = conn.prepareStatement(createTableSQL)) {
                stmt.execute();
            }

            // Inserir o serviço na tabela
            String insertSQL = "INSERT INTO servicos (tipoCliente, cpfCnpj, nomeCliente, dataInicio, dataFim, valorCobrado, formaPagamento, situacaoPagamento, userId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            try (PreparedStatement stmt = conn.prepareStatement(insertSQL)) {
                stmt.setString(1, tipoCliente);
                stmt.setString(2, cpfCnpj);
                stmt.setString(3, nomeCliente);
                stmt.setDate(4, Date.valueOf(dataInicio));
                stmt.setDate(5, Date.valueOf(dataFim));
                stmt.setDouble(6, valorCobrado);
                stmt.setString(7, formaPagamento);
                stmt.setString(8, situacaoPagamento);
                stmt.setInt(9, userId);

                if (verificarDataServico(userId, dataInicio, dataFim)) {
                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                        try {
                            String nomeArquivo = ContratoPDF.gerarContratoPDF(nomeCliente, cpfCnpj, valorCobrado, formaPagamento, dataInicio, dataFim);

                            SalvarNuvem salvarNuvem = new SalvarNuvem();

                            String caminhoArquivoLocal = nomeArquivo;

                            salvarNuvem.salvarPdfNaNuvem(caminhoArquivoLocal, nomeArquivo);

                            exibirAlerta("Cadastro de Serviço", "Serviço cadastrado com sucesso. Contrato gerado e enviado para a nuvem.");
                            limparCamposServico();
                            carregarDadosPagamentos();
                        } catch (IOException e) {
                            exibirAlerta("Erro ao gerar contrato", "Ocorreu um erro ao gerar o contrato em PDF: " + e.getMessage());
                        }
                    } else {
                        exibirAlerta("Erro no cadastro", "Falha ao cadastrar o serviço.");
                    }
                }
            }
        } catch (SQLException e) {
            exibirAlerta("Erro no cadastro", "Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    @FXML
    void fecharTelaServico(ActionEvent event) {
        stackPaneCadastrarServico.setVisible(false);
    }

    @FXML
    void fecharTelaCadastrar(ActionEvent event) {
        stackPaneCadastrar.setVisible(false);
    }

    @FXML
    void fecharTelaBuscarFerramenta(ActionEvent event) {
        stackPaneBuscar.setVisible(false);
    }

    @FXML
    void fecharTelaEditar(ActionEvent event) {
        stackPaneEditar.setVisible(false);
    }

    @FXML
    void fecharTelaVisualizarCliente(ActionEvent event) {
        stackPaneVisualizarCliente.setVisible(false);
    }


    private boolean verificarDataServico(int userId, LocalDate dataInicio, LocalDate dataFim) {
        Connection conn = null;

        try {
            String url = "jdbc:sqlite:bancodedados.db";
            conn = DriverManager.getConnection(url);

            String verificarSQL = "SELECT COUNT(*) FROM servicos WHERE userId = ? AND ((dataInicio = ? OR dataFim = ?) OR (dataInicio = ? OR dataFim = ?))";

            try (PreparedStatement stmt = conn.prepareStatement(verificarSQL)) {
                stmt.setInt(1, userId);
                stmt.setDate(2, Date.valueOf(dataInicio));
                stmt.setDate(3, Date.valueOf(dataInicio));
                stmt.setDate(4, Date.valueOf(dataFim));
                stmt.setDate(5, Date.valueOf(dataFim));

                try (ResultSet resultSet = stmt.executeQuery()) {
                    if (resultSet.next() && resultSet.getInt(1) > 0) {
                        exibirAlerta("Erro no cadastro", "Já existe um serviço nas datas selecionadas.");
                        return false;
                    }
                }
            }

        } catch (SQLException e) {
            exibirAlerta("Erro no cadastro", "Erro ao conectar ao banco de dados: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return true;
    }

    private void exibirAlerta(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    void editarRegistroCliente(ActionEvent event) {
        Cliente clienteSelecionado = tabelaClientes.getSelectionModel().getSelectedItem();

        if (clienteSelecionado == null) {
            exibirAlerta("Erro", "Nenhum cliente selecionado.");
        } else if (clienteSelecionado != null) {
            campoNomeClienteE.setText(clienteSelecionado.getNome());
            campoCpfCnpjClienteE.setText(clienteSelecionado.getCpfCnpj());
            campoEnderecoClienteE.setText(clienteSelecionado.getEndereco());
            campoBairroClienteE.setText(clienteSelecionado.getBairro());
            campoMunicipioClienteE.setText(clienteSelecionado.getMunicipio());
            campoCelularClienteE.setText(clienteSelecionado.getCelular());
            campoEmailClienteE.setText(clienteSelecionado.getEmail());

            stackPaneEditar.setVisible(true);
        }
    }

    @FXML
    void salvarEdicaoCliente(ActionEvent event) {
        String novoNome = campoNomeClienteE.getText();
        String novoCpfCnpj = campoCpfCnpjClienteE.getText();
        String novoEndereco = campoEnderecoClienteE.getText();
        String novoBairro = campoBairroClienteE.getText();
        String novoMunicipio = campoMunicipioClienteE.getText();
        String novoCelular = campoCelularClienteE.getText();
        String novoEmail = campoEmailClienteE.getText();

        Cliente clienteSelecionado = tabelaClientes.getSelectionModel().getSelectedItem();
        if (clienteSelecionado != null) {
            int idCliente = clienteSelecionado.getIdCliente();

            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:bancodedados.db");
                 PreparedStatement statement = conn.prepareStatement("UPDATE clientes SET nome = ?, cpfCnpj = ?, endereco = ?, bairro = ?, municipio = ?, celular = ?, email = ? WHERE id = ?")) {

                statement.setString(1, novoNome);
                statement.setString(2, novoCpfCnpj);
                statement.setString(3, novoEndereco);
                statement.setString(4, novoBairro);
                statement.setString(5, novoMunicipio);
                statement.setString(6, novoCelular);
                statement.setString(7, novoEmail);
                statement.setInt(8, idCliente);

                int rowsUpdated = statement.executeUpdate();

                if (rowsUpdated > 0) {
                    exibirAlerta("Confirmado", "Cliente atualizado com sucesso.");
                    stackPaneEditar.setVisible(false);
                    carregarDadosClientes();
                } else {
                    exibirAlerta("Erro", "Não foi possível atualizar o registro do cliente.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void adicionarFerramenta(ActionEvent event) {
        String nomeFerramenta = campoNomeFerramenta.getText();
        String localizacao = campoLocalFerramenta.getValue();
        String outrasInfo = campoOutrasInfoFerramenta.getText();
        int userId = LoginController.getIdUsuario();

        if (nomeFerramenta.isEmpty()) {
            exibirAlerta("Erro", "Digite o nome da ferramenta.");
            return;
        }

        String url = "jdbc:sqlite:bancodedados.db";

        if (ferramentaJaExiste(nomeFerramenta, userId)) {
            exibirAlerta("Erro", "Já existe uma ferramenta com esse nome.");
            return;
        }

        try (Connection conn = DriverManager.getConnection(url)) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS ferramentas ("
                    + "idFerramenta INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "nomeFerramenta TEXT,"
                    + "localizacao TEXT,"
                    + "outrasInfo TEXT,"
                    + "userId INTEGER"
                    + ")";
            try (PreparedStatement createTableStmt = conn.prepareStatement(createTableSQL)) {
                createTableStmt.execute();
            }
            String query = "INSERT INTO ferramentas (nomeFerramenta, localizacao, outrasInfo, userId) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, nomeFerramenta);
                stmt.setString(2, localizacao);
                stmt.setString(3, outrasInfo);
                stmt.setInt(4, userId);

                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    exibirAlerta("Confirmado", "Ferramenta adicionada com sucesso.");
                    carregarDadosTabelaFerramentas();
                    campoNomeFerramenta.setText("");
                    campoLocalFerramenta.setValue("Em Posse");
                    campoOutrasInfoFerramenta.setText("");
                } else {
                    exibirAlerta("Erro", "Erro ao adicionar ferramenta.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            exibirAlerta("Erro", "Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    private boolean ferramentaJaExiste(String nomeFerramenta, int userId) {
        String url = "jdbc:sqlite:bancodedados.db";
        String query = "SELECT COUNT(*) FROM ferramentas WHERE LOWER(nomeFerramenta) = LOWER(?) AND userId = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nomeFerramenta);
            stmt.setInt(2, userId);

            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @FXML
    void excluirRegistroFerramenta(ActionEvent event) {
        Ferramentas ferramentaSelecionada = tabelaFerramentas.getSelectionModel().getSelectedItem();

        if (ferramentaSelecionada == null) {
            exibirAlerta("Erro", "Nenhuma ferramenta selecionada.");
            return;
        }

        int idFerramentaParaExcluir = ferramentaSelecionada.getIdFerramenta();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmação");
        alert.setHeaderText("Confirmação de exclusão");
        alert.setContentText("Tem certeza de que deseja excluir esta ferramenta?");

        Optional<ButtonType> result = alert.showAndWait();

        String url = "jdbc:sqlite:bancodedados.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            String deleteSQL = "DELETE FROM ferramentas WHERE idFerramenta = ?";
            try (PreparedStatement stmt = conn.prepareStatement(deleteSQL)) {
                stmt.setInt(1, idFerramentaParaExcluir);

                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    exibirAlerta("Confirmado", "Ferramenta excluída com sucesso.");
                    tabelaFerramentas.getItems().remove(ferramentaSelecionada);
                } else {
                    exibirAlerta("Erro", "Erro ao excluir ferramenta.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            exibirAlerta("Erro", "Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    private void carregarDadosTabelaFerramentas() {
        int idUsuario = LoginController.getIdUsuario();

        String url = "jdbc:sqlite:bancodedados.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            String query = "SELECT idFerramenta, nomeFerramenta, localizacao, outrasInfo FROM ferramentas WHERE userId = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, idUsuario);
                ResultSet resultSet = stmt.executeQuery();

                ObservableList<Ferramentas> listaFerramentas = FXCollections.observableArrayList();

                while (resultSet.next()) {
                    int idFerramenta = resultSet.getInt("idFerramenta");
                    String nomeFerramenta = resultSet.getString("nomeFerramenta");
                    String localizacao = resultSet.getString("localizacao");
                    String outrasInfo = resultSet.getString("outrasInfo");

                    Ferramentas ferramenta = new Ferramentas(idFerramenta, nomeFerramenta, localizacao, outrasInfo);

                    listaFerramentas.add(ferramenta);
                }

                tabelaFerramentas.setItems(listaFerramentas);

                nomeFerramentaCol.setCellValueFactory(cellData -> cellData.getValue().nomeFerramentaProperty());
                localizacaoFerramentaCol.setCellValueFactory(cellData -> cellData.getValue().localizacaoProperty());
                outrasInfoFerramentaCol.setCellValueFactory(cellData -> cellData.getValue().outrasInfoFerramentaProperty());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            exibirAlerta("Erro", "Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    private void carregarComboBoxLocalFerramenta() {
        int userId = LoginController.getIdUsuario();

        String url = "jdbc:sqlite:bancodedados.db";
        try (Connection conn = DriverManager.getConnection(url)) {
            String query = "SELECT nome FROM clientes WHERE userId = ?";

            List<String> nomesClientes = new ArrayList<>();

            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, userId);
                ResultSet resultSet = stmt.executeQuery();

                while (resultSet.next()) {
                    String nomeCliente = resultSet.getString("nome");
                    nomesClientes.add(nomeCliente);
                }
            }

            nomesClientes.add(0, "Em Posse");

            ObservableList<String> opcoesClientes = FXCollections.observableArrayList(nomesClientes);

            campoLocalFerramenta.setItems(opcoesClientes);

            campoLocalFerramenta.getSelectionModel().selectFirst();
        } catch (SQLException e) {
            exibirAlerta("Erro", "Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }


    private void limparCamposCliente() {
        campoNomeCliente.clear();
        campoCpfCnpjCliente.clear();
        campoEnderecoCliente.clear();
        campoBairroCliente.clear();
        campoMunicipioCliente.clear();
        campoCelularCliente.clear();
        campoEmailCliente.clear();
    }

    @FXML
    void limparDadosCliente(ActionEvent event) {
        limparCamposCliente();
    }

    @FXML
    void cancelarEdicao(ActionEvent event) {
        Stage stage = (Stage) botaoCancelarClienteE.getScene().getWindow();
        stackPaneEditar.setVisible(false);
    }

    private void limparCamposServico() {
        campoClienteServico.setValue(null);
        campoCpfCnpjClienteServico.clear();
        campoDataServicoInicio.setValue(null);
        campoDataServicoFim.setValue(null);
        campoValorServico.clear();
        campoFormaPagServico.setValue(null);
        campoSituacaoPagServico.setValue(null);
    }
    @FXML
    void limparDadosServico(ActionEvent event) {
        limparCamposServico();
    }


    @FXML
    void mostrarSobre(ActionEvent event) {
        exibirAlerta("Sobre","Aplicação voltada para construção civil permitindo " +
                "o gerenciamento de clientes, agenda e inventário de ferramentas do mestre de obra." +
                "\n\nProjeto desenvolvido sem fins lucrativos pelo aluno:" +
                "\nVinicius Batista Checchetto\n" +
                "da Universidade Estácio de Sá - Campo Grande RJ.");
    }

    private void carregarChoiceBoxClienteServico() {
        int userId = LoginController.getIdUsuario();

        String url = "jdbc:sqlite:bancodedados.db";
        try (Connection conn = DriverManager.getConnection(url)) {
            String query = "SELECT nome FROM clientes WHERE userId = ?";

            List<String> nomesClientes = new ArrayList<>();

            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, userId);
                ResultSet resultSet = stmt.executeQuery();

                while (resultSet.next()) {
                    String nomeCliente = resultSet.getString("nome");
                    nomesClientes.add(nomeCliente);
                }
            }

            ObservableList<String> opcoesClientes = FXCollections.observableArrayList(nomesClientes);

            campoClienteServico.setItems(opcoesClientes);

            campoClienteServico.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    String selectedCliente = newValue;
                    String cpfCnpjCliente = getCpfCnpjFromDatabase(selectedCliente, userId);

                    campoCpfCnpjClienteServico.setText(cpfCnpjCliente);
                }
            });

        } catch (SQLException e) {
            exibirAlerta("Erro", "Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    private String getCpfCnpjFromDatabase(String nomeCliente, int userId) {
        String cpfCnpj = "";
        String url = "jdbc:sqlite:bancodedados.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            String query = "SELECT cpfCnpj FROM clientes WHERE nome = ? AND userId = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, nomeCliente);
                stmt.setInt(2, userId);

                ResultSet resultSet = stmt.executeQuery();

                if (resultSet.next()) {
                    cpfCnpj = resultSet.getString("cpfCnpj");
                }
            }
        } catch (SQLException e) {
            exibirAlerta("Erro", "Erro ao conectar ao banco de dados: " + e.getMessage());
        }

        return cpfCnpj;
    }

    private void carregarChoiceBoxSituacaoPag() {
        ObservableList<String> choiceboxSituacaoPag = FXCollections.observableArrayList("A Pagar", "Pago", "Em Atraso");
        campoSituacaoPagServico.setItems(choiceboxSituacaoPag);
    }

    private void carregarComboBoxFormaPag() {
        ObservableList<String> comboboxFormaPag = FXCollections.observableArrayList("Dinheiro", "Pix", "Cartão de Crédito", "Cartão de Débito");
        campoFormaPagServico.setItems(comboboxFormaPag);
    }

    private void carregarComboBoxProcurarCliente() {
        ObservableList<String> comboboxProcurarCliente = FXCollections.observableArrayList("Nome", "CPF/CNPJ");
        comboBoxProcurarCliente.setItems(comboboxProcurarCliente);
        comboBoxProcurarCliente.setValue("Nome");
    }

    private void carregarComboBoxProcuraPagamento() {
        ObservableList<String> comboboxProcurarPagamento = FXCollections.observableArrayList("Nome", "CPF/CNPJ");
        comboBoxProcurarPagamento.setItems(comboboxProcurarPagamento);
        comboBoxProcurarPagamento.setValue("Nome");
    }
    private void desenharCalendario() {
        Locale locale = new Locale.Builder().setLanguage("pt").setRegion("BR").build();
        DateFormatSymbols symbols = new DateFormatSymbols(locale);
        String nomeMes = symbols.getMonths()[dataFoco.getMonthValue() - 1];

        ano.setText(String.valueOf(dataFoco.getYear()));
        mes.setText(nomeMes);

        double larguraCalendario = calendario.getPrefWidth();
        double alturaCalendario = calendario.getPrefHeight();
        double larguraLinha = 0.5;
        double espacamentoHorizontal = calendario.getHgap();
        double espacamentoVertical = calendario.getVgap();


        int maximoDiasMes = dataFoco.getMonth().maxLength();
        // Verificar se é ano bissexto
        if (dataFoco.getYear() % 4 != 0 && maximoDiasMes == 29) {
            maximoDiasMes = 28;
        }
        int diaInicial = ZonedDateTime.of(dataFoco.getYear(), dataFoco.getMonthValue(), 1, 0, 0, 0, 0, dataFoco.getZone()).getDayOfWeek().getValue();

        Map<LocalDate, String> reservasComNomes = DatasReservadas();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                StackPane painelData = new StackPane();
                Rectangle retangulo = new Rectangle();
                retangulo.setFill(Color.TRANSPARENT);
                retangulo.setStroke(Color.BLACK);
                retangulo.setStrokeWidth(larguraLinha);
                double larguraRetangulo = (larguraCalendario / 7) - larguraLinha - espacamentoHorizontal;
                retangulo.setWidth(larguraRetangulo);
                double alturaRetangulo = (alturaCalendario / 6) - larguraLinha - espacamentoVertical;
                retangulo.setHeight(alturaRetangulo);
                painelData.getChildren().add(retangulo);

                int diaCalculado = (j + 1) + (7 * i);
                if (diaCalculado > diaInicial) {
                    int diaAtual = diaCalculado - diaInicial;
                    if (diaAtual <= maximoDiasMes) {
                        Text data = new Text(String.valueOf(diaAtual));
                        data.setFont(Font.font("Arial", 20));
                        double translacaoYTexto = - (alturaRetangulo / 2) * 0.45;
                        data.setTranslateY(translacaoYTexto);
                        painelData.getChildren().add(data);

                        LocalDate dataVerificada = LocalDate.of(dataFoco.getYear(), dataFoco.getMonthValue(), diaAtual);
                        if (reservasComNomes.containsKey(dataVerificada)) {
                            retangulo.setFill(Color.rgb(255, 0, 0, 0.5));
                            String nomeCliente = reservasComNomes.get(dataVerificada);
                            Text nomeText = new Text(nomeCliente);
                            nomeText.setFont(Font.font("Arial", 14));
                            nomeText.setTranslateY(alturaRetangulo / 2 * 0.65);
                            painelData.getChildren().add(nomeText);
                        }
                    }
                    if (hoje.getYear() == dataFoco.getYear() && hoje.getMonth() == dataFoco.getMonth() && hoje.getDayOfMonth() == diaAtual) {
                        retangulo.setStroke(Color.BLUE);
                        retangulo.setStrokeWidth(2.0);
                    }
                }
                calendario.getChildren().add(painelData);
            }
        }
    }

    ZonedDateTime dataFoco;
    ZonedDateTime hoje;

    @FXML
    void voltarUmMes(ActionEvent evento) {
        dataFoco = dataFoco.minusMonths(1);
        calendario.getChildren().clear();
        desenharCalendario();
    }

    @FXML
    void avancarUmMes(ActionEvent evento) {
        dataFoco = dataFoco.plusMonths(1);
        calendario.getChildren().clear();
        desenharCalendario();
    }

    @FXML
    void initialize() {
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), (ActionEvent event) -> {

            LocalTime horaAtual = LocalTime.now();

            hora.setText(formatoHora.format(horaAtual));
        }));

        timeline.setCycleCount(Animation.INDEFINITE);

        timeline.play();
        carregarDadosClientes();
        carregarDadosPagamentos();
        carregarDadosTabelaFerramentas();
        carregarChoiceBoxClienteServico();
        carregarChoiceBoxSituacaoPag();
        carregarComboBoxFormaPag();
        carregarComboBoxProcurarCliente();
        carregarComboBoxProcuraPagamento();
        dataFoco = ZonedDateTime.now();
        hoje = ZonedDateTime.now();
        desenharCalendario();
        datasReservadas = DatasReservadas();
        exibirServicoAtual();
        exibirProximoServico();
        carregarComboBoxLocalFerramenta();
    }

    @FXML
    void Desconectar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            VBox cenaLogin = loader.load();

            Scene cena = new Scene(cenaLogin);

            Stage stage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
            stage.setScene(cena);
            stage.setTitle("Login");

            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();

            stage.setX(bounds.getMinX() + (bounds.getWidth() - cenaLogin.getWidth()) / 2);
            stage.setY(bounds.getMinY() + (bounds.getHeight() - cenaLogin.getHeight()) / 2);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void subirNuvem(ActionEvent event) {
        Alert confirmDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmDialog.setTitle("Confirmação");
        confirmDialog.setHeaderText(null);
        confirmDialog.setContentText("Tem certeza que deseja salvar na nuvem?");

        ButtonType buttonTypeConfirm = new ButtonType("Confirmar", ButtonBar.ButtonData.OK_DONE);
        ButtonType buttonTypeCancel = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
        confirmDialog.getButtonTypes().setAll(buttonTypeConfirm, buttonTypeCancel);

        Optional<ButtonType> result = confirmDialog.showAndWait();

        if (result.isPresent() && result.get() == buttonTypeConfirm) {
            String filePath = "bancodedados.db";
            SalvarNuvem salvarNuvem = new SalvarNuvem();

            try {
                salvarNuvem.salvarArquivoNaNuvem(filePath);
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Sucesso");
                successAlert.setHeaderText(null);
                successAlert.setContentText("Dados salvos na nuvem com sucesso.");
                successAlert.show();
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), e -> {
                    successAlert.close();
                }));
                timeline.play();
            } catch (Exception e) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Erro");
                errorAlert.setHeaderText(null);
                errorAlert.setContentText("Erro ao salvar na nuvem.");
                errorAlert.showAndWait();
            }
        }
    }

    @FXML
    void sair(ActionEvent event) {
        Alert confirmDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmDialog.setTitle("Confirmação");
        confirmDialog.setHeaderText("Você tem certeza que deseja sair?");

        ButtonType buttonTypeConfirm = new ButtonType("Confirmar", ButtonBar.ButtonData.OK_DONE);
        ButtonType buttonTypeCancel = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
        confirmDialog.getButtonTypes().setAll(buttonTypeConfirm, buttonTypeCancel);

        Optional<ButtonType> result = confirmDialog.showAndWait();

        if (result.isPresent() && result.get() == buttonTypeConfirm) {
            Alert waitAlert = new Alert(Alert.AlertType.INFORMATION);
            waitAlert.setTitle("Aguarde");
            waitAlert.setHeaderText("Por favor, aguarde.");
            waitAlert.setContentText("O banco de dados está sendo enviado para a nuvem.");
            waitAlert.show();

            String filePath = "bancodedados.db";
            SalvarNuvem salvarNuvem = new SalvarNuvem();

            try {
                salvarNuvem.salvarArquivoNaNuvem(filePath);
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), e -> {
                    waitAlert.close();
                    Platform.exit();
                }));
                timeline.play();
            } catch (Exception e) {
                Timeline errorTimeline = new Timeline(new KeyFrame(Duration.seconds(3), ev -> {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setTitle("Erro");
                    errorAlert.setHeaderText(null);
                    errorAlert.setContentText("Erro ao salvar na nuvem.");
                    errorAlert.showAndWait();
                }));
                errorTimeline.play();
            }
        } else {
            event.consume();
        }
    }


}
