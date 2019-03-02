/**
 *
 */
package br.com.javacheatbook.examples;

import br.com.javacheatbook.tesseractocr.TesseractOCR;
import br.com.javacheatbook.utils.Util;
import java.io.File;

/**
 * @author GuiDB
 */
public class JavaCheatBook {

    public static void main(String[] args) {

        // ##################################################
        // #################### Util ####################
        // ##################################################
        /**
         * Example of how to check your Operational System.
         */
        System.out.println("Operational System Name: " + Util.isWindows());
        /**
         * Example of how to check your Divider Characted based on your
         * Operational System.
         */
        System.out.println("My divider is: " + Util.getDivider());
        /**
         * Example of how to get the date and time at realtime on your system.
         */
        System.out.println("Date: " + Util.getDate());
    }
}
