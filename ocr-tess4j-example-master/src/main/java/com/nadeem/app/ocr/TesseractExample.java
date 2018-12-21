package com.nadeem.app.ocr;

import java.io.File;
import net.sourceforge.tess4j.*;


public class TesseractExample
{
    public static void main(String[] args) {
        File imageFile = new File(System.getProperty("user.dir")+
                "\\Screenshot_1.png");
        ITesseract instance = new Tesseract();
        instance.setDatapath("tessdata");
        instance.setLanguage("eng");
        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}
