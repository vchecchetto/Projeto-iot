package gestaodeobras.projetogestaodeobras;

import javafx.beans.property.*;
import java.util.Date;

public class Pagamento {
    private int idServico;
    private final StringProperty tipoCliente = new SimpleStringProperty();
    private final StringProperty cpfCnpj = new SimpleStringProperty();
    private final StringProperty nomeCliente = new SimpleStringProperty();
    private final ObjectProperty<java.sql.Date> dataInicio = new SimpleObjectProperty<>();
    private final ObjectProperty<java.sql.Date> dataFim = new SimpleObjectProperty<>();
    private final DoubleProperty valorCobrado = new SimpleDoubleProperty();
    private final StringProperty situacaoPagamento = new SimpleStringProperty();

    public Pagamento(int idServico, String tipoCliente, String cpfCnpj, String nomeCliente, java.sql.Date dataInicio, java.sql.Date dataFim, double valorCobrado, String situacaoPagamento) {
        this.idServico = idServico;
        this.tipoCliente.set(tipoCliente);
        this.cpfCnpj.set(cpfCnpj);
        this.nomeCliente.set(nomeCliente);
        this.dataInicio.set(dataInicio);
        this.dataFim.set(dataFim);
        this.valorCobrado.set(valorCobrado);
        this.situacaoPagamento.set(situacaoPagamento);
    }

    public int getIdServico() {
        return idServico;
    }

    public StringProperty tipoClienteProperty() {
        return tipoCliente;
    }

    public StringProperty cpfCnpjProperty() {
        return cpfCnpj;
    }

    public StringProperty nomeClienteProperty() {
        return nomeCliente;
    }

    public ObjectProperty<java.sql.Date> dataInicioProperty() {
        return dataInicio;
    }

    public ObjectProperty<java.sql.Date> dataFimProperty() {
        return dataFim;
    }

    public DoubleProperty valorCobradoProperty() {
        return valorCobrado;
    }

    public StringProperty situacaoPagamentoProperty() {
        return situacaoPagamento;
    }
}
