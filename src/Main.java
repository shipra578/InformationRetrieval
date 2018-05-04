import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static final String DATA_SET_FOLDER = "dataSetFolder";
    private static HashMap<String, List<String>> docIdTermMap;

    public static void main(String[] args) {
        Main mainProgram = new Main();
        docIdTermMap = new HashMap<>();
        mainProgram.listAllFiles();
    }

    private void readContent(String fileName) {

        FileInputStream fis = null;
        try {
            String filePath = DATA_SET_FOLDER + "/" + fileName;
            File file = new File(filePath);
            fis = new FileInputStream(file.getAbsolutePath());
            XWPFDocument document = new XWPFDocument(fis);
            List<XWPFParagraph> paragraphs = document.getParagraphs();

            for (XWPFParagraph para : paragraphs) {
                System.out.println(para.getText());
            }

        } catch (Exception e) {
            System.out.println("error while reading file");
            e.printStackTrace();
        } finally {

            try {
                if ( fis != null ) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("error while closing input stream");
            }
        }
    }

    private void listAllFiles() {
        File folder = new File(DATA_SET_FOLDER);
        File[] listOfFiles = folder.listFiles();

        if ( listOfFiles != null ) {
            for (File listOfFile : listOfFiles) {
                if ( listOfFile.isFile() ) {
                    getDocID(listOfFile.getName());
                    //readContent(listOfFile.getName());
                }
            }
        }
    }

    private String getDocID(String fileName) {

        String docId = fileName.substring(0,fileName.lastIndexOf("."));
        System.out.println("docID: "+ docId);
        return "";
    }


}
