package gestaodeobras.projetogestaodeobras;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.time.LocalDate;
import java.time.ZoneId;

public class ContratoPDF {
    public static String gerarContratoPDF(String nomeCliente, String cpfCnpj, double valorCobrado, String formaPagamento, LocalDate dataInicio, LocalDate dataFim) throws IOException {
        Date dataInicioDate = java.util.Date.from(dataInicio.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date dataFimDate = java.util.Date.from(dataFim.atStartOfDay(ZoneId.systemDefault()).toInstant());

        String pastaDestino = "contratos/";

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String dataInicioFormatada = sdf.format(dataInicioDate);
        String dataFimFormatada = sdf.format(dataFimDate);

        String nomeArquivo = "contrato_" + nomeCliente + "_" + dataInicioFormatada + ".pdf";

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
            contentStream.newLineAtOffset(100, 700);
            contentStream.showText("Contrato de Prestação de Serviços");
            contentStream.newLineAtOffset(0, -20);
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            contentStream.showText("Nome do Cliente: " + nomeCliente);
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("CPF/CNPJ: " + cpfCnpj);
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Valor Cobrado: R$ " + valorCobrado);
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Forma de Pagamento: " + formaPagamento);
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Data de Início: " + dataInicioFormatada);
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Data de Fim: " + dataFimFormatada);
            contentStream.endText();
            contentStream.close();

            document.save(pastaDestino + nomeArquivo);
        }

        return pastaDestino + nomeArquivo;
    }

}
