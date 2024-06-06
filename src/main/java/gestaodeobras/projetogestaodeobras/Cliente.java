package gestaodeobras.projetogestaodeobras;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Cliente {
    private int id;
    private final StringProperty tipo = new SimpleStringProperty();
    private final StringProperty nome = new SimpleStringProperty();
    private final StringProperty cpfCnpj = new SimpleStringProperty();
    private final StringProperty endereco = new SimpleStringProperty();
    private final StringProperty bairro = new SimpleStringProperty();
    private final StringProperty municipio = new SimpleStringProperty();
    private final StringProperty celular = new SimpleStringProperty();
    private final StringProperty email = new SimpleStringProperty();

    public Cliente(int id, String tipo, String nome, String cpfCnpj, String endereco, String bairro, String municipio, String celular, String email) {
        this.id = id;
        this.tipo.set(tipo);
        this.nome.set(nome);
        this.cpfCnpj.set(cpfCnpj);
        this.endereco.set(endereco);
        this.bairro.set(bairro);
        this.municipio.set(municipio);
        this.celular.set(celular);
        this.email.set(email);
    }

    public int getIdCliente() {
        return id;
    }

    public String getNome() {
        return nome.get();
    }

    public String getCpfCnpj() {
        return cpfCnpj.get();
    }

    public String getEndereco() {
        return endereco.get();
    }

    public String getBairro() {
        return bairro.get();
    }

    public String getMunicipio() {
        return municipio.get();
    }

    public String getCelular() {
        return celular.get();
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty tipoProperty() {
        return tipo;
    }

    public StringProperty nomeProperty() {
        return nome;
    }

    public StringProperty cpfCnpjProperty() {
        return cpfCnpj;
    }

    public StringProperty enderecoProperty() {
        return endereco;
    }

    public StringProperty bairroProperty() {
        return bairro;
    }

    public StringProperty celularProperty() {
        return celular;
    }

    public StringProperty emailProperty() {
        return email;
    }
}
