public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        System.out.println("=== Word Document ===");
        DocumentFactory wordFactory = new WordDocumentFactory();
        wordFactory.processDocument();

        System.out.println("\n=== PDF Document ===");
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        pdfFactory.processDocument();

        System.out.println("\n=== Excel Document ===");
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        excelFactory.processDocument();
    }
}
