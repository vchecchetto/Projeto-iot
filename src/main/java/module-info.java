module gestaodeobras.projetogestaodeobras {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.azure.storage.blob;
    requires org.apache.pdfbox;

    opens gestaodeobras.projetogestaodeobras to javafx.fxml;
    exports gestaodeobras.projetogestaodeobras;
}