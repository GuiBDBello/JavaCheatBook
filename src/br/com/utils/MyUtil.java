/**
 * This Class was created to be an utilitary Class to be used at many Java Projects;
 */
package br.com.javacheatbook.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author GuiDB
 */
public class Util {

    private static final boolean windows = System.getProperty("os.name").trim().toLowerCase().startsWith("win");
    private static final String divider = (windows) ? "\\" : "/";

    /**
     * @see
     * https://www.mkyong.com/java/java-how-to-get-current-date-time-date-and-calender/
     * @return Realtime date and time formatted as 'yyyy/MM/dd HH:mm:ss'
     */
    public static String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    /**
     * @return The divider String depending on the Operational System (if
     * Windows then '\' else '/')
     */
    public static String getDivider() {
        return Util.divider;
    }

    /**
     * @return true if the Operational System is Windows
     */
    public static boolean isWindows() {
        return Util.windows;
    }

    /**
     * Writes the content in a log file.
     *
     * @see https://howtodoinjava.com/java/io/java-write-to-file/
     * @param content The content to be written
     * @param append Append the content to the existent text
     */
    public static void writeLog(String content, boolean append) {
        if (!content.isEmpty()) {
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter("log.txt", append);
                fileWriter.write(Util.getDate() + " " + content + "\n");
                fileWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fileWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * @param content The content to be written
     * @param fileName The absolute path of the file to be written in
     */
    public static void writeLogInFile(String content, String fileName) {
        if (!content.isEmpty()) {
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(fileName, true);
                fileWriter.write(Util.getDate() + " " + content + "\n");
                fileWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fileWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
