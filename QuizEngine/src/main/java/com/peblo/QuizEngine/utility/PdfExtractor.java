package com.peblo.QuizEngine.utility;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PdfExtractor {

    public static String extractText(String filePath) {

        try {

            File file = new File(filePath);
            PDDocument document = PDDocument.load(file);

            PDFTextStripper pdfStripper = new PDFTextStripper();

            String text = pdfStripper.getText(document);

            document.close();

            return text;

        } catch (IOException e) {

            e.printStackTrace();
            return "";

        }

    }

}