package gestaodeobras.projetogestaodeobras;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Ferramentas {
    private int idFerramenta;
    private final StringProperty nomeFerramenta = new SimpleStringProperty();
    private final StringProperty localizacao = new SimpleStringProperty();
    private final StringProperty outrasInfo = new SimpleStringProperty();

    public Ferramentas(int idFerramenta, String nomeFerramenta, String localizacao, String outrasInfo) {
        this.idFerramenta = idFerramenta;
        this.nomeFerramenta.set(nomeFerramenta);
        this.localizacao.set(localizacao);
        this.outrasInfo.set(outrasInfo);
    }

    public int getIdFerramenta() {
        return idFerramenta;
    }

    public String getNomeFerramenta() {
        return nomeFerramenta.get();
    }

    public String getLocalizacao() {
        return localizacao.get();
    }

    public String getOutrasInfo() {
        return outrasInfo.get();
    }

    public StringProperty nomeFerramentaProperty() {
        return nomeFerramenta;
    }

    public StringProperty localizacaoProperty() {
        return localizacao;
    }

    public StringProperty outrasInfoFerramentaProperty() {
        return outrasInfo;
    }


}
