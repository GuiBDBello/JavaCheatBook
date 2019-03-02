/**
 * To use this class, you have to install Tesseract (I recommend installing it via the installer made by UB-Mannheim at https://github.com/UB-Mannheim/tesseract/wiki)
 */
package br.com.javacheatbook.tesseractocr;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author GuiDB
 */
public class TesseractOCR {

    private File fileIn;
    private File fileOut;
    private String language;
    private String extension;
    private int pageSegmentationModes = 3;
    private int ocrEngineModes = 3;

    public File getFileIn() {
        return this.fileIn;
    }

    public void setFileIn(File fileIn) {
        this.fileIn = fileIn;
    }

    public File getFileOut() {
        return this.fileOut;
    }

    public void setFileOut(File fileOut) {
        this.fileOut = fileOut;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getPageSegmentationModes() {
        return this.pageSegmentationModes;
    }

    public void setPageSegmentationModes(int pageSegmentationModes) {
        this.pageSegmentationModes = pageSegmentationModes;
    }

    public int getOcrEngineModes() {
        return this.ocrEngineModes;
    }

    public void setOcrEngineModess(int ocrEngineModes) {
        this.ocrEngineModes = ocrEngineModes;
    }

    public void executeTesseract(File fileIn, File fileOut, String language, String extension,
            int pageSegmentationModes, int ocrEngineModes) {
        try {
            Runtime.getRuntime().exec("tesseract "
                    + this.getFileIn().getAbsolutePath() + " "
                    + this.getFileOut().getAbsolutePath() + " "
                    + "-l " + this.getLanguage() + " "
                    + this.getExtension());
        } catch (IOException ex) {
            Logger.getLogger(TesseractOCR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
