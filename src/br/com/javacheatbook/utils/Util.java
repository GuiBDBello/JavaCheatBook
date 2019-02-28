/**
 * This Class was created to be an utilitary Class to be used at many Java Projects;
 */
package br.com.javacheatbook.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
}
