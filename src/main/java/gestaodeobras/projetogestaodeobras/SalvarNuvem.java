package gestaodeobras.projetogestaodeobras;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobStorageException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SalvarNuvem {
    public void salvarArquivoNaNuvem(String filePath) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("properties/azure.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String endpoint = properties.getProperty("AZURE_STORAGE_ENDPOINT");
        String sasToken = properties.getProperty("AZURE_STORAGE_SAS_TOKEN");

        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .endpoint(endpoint)
                .sasToken(sasToken)
                .buildClient();

        BlobContainerClient blobContainerClient = blobServiceClient.getBlobContainerClient("conteinerbanco");

        BlobClient blobClient = blobContainerClient.getBlobClient("bancodedados.db");

        try {
            blobClient.uploadFromFile(filePath, true);
            System.out.println("Arquivo salvo com sucesso em nuvem.");
        } catch (BlobStorageException e) {
            System.err.println("Erro ao salvar o arquivo em nuvem: " + e.getMessage());
        }
    }

    public void salvarPdfNaNuvem(String filePath, String nomeArquivo){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("properties/azure.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String endpoint = properties.getProperty("AZURE_STORAGE_ENDPOINT");
        String sasToken = properties.getProperty("AZURE_STORAGE_SAS_TOKEN");

        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .endpoint(endpoint)
                .sasToken(sasToken)
                .buildClient();

        BlobContainerClient blobContainerClient = blobServiceClient.getBlobContainerClient("conteinercontratos");

        BlobClient blobClient = blobContainerClient.getBlobClient(nomeArquivo);

        try {
            blobClient.uploadFromFile(filePath, true);
            System.out.println("Arquivo de contrato salvo com sucesso em nuvem.");
        } catch (BlobStorageException e) {
            System.err.println("Erro ao salvar o arquivo de contrato em nuvem: " + e.getMessage());
        }
    }
}
