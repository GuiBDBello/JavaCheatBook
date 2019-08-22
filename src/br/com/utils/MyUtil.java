package br.com.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * This Class was created to be an utilitary Class to be used at many Java Projects;
 * 
 * @author GuiDB
 */
public class MyUtil {

    private static final boolean windows = System.getProperty("os.name").trim().toLowerCase().startsWith("win");

    /**
     * Display on the console/terminal the input stream of the executed command.
     * 
     * @param p the Process in execution.
     * @throws IOException 
     */
    public static void displayInputStream(Process p) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
    	
    	String line;
		while((line = br.readLine()) != null) {
			System.out.println(line);
		}
    }
    
    /**
     * Display on the console/terminal the error stream of the executed command.
     * 
     * @param p the Process in execution.
     * @throws IOException 
     */
    public static void displayErrorStream(Process p) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
    	
    	String line;
		while((line = br.readLine()) != null) {
			System.err.println(line);
		}
    }
    
    /**
     * 
     * @param pb
     * @param showOutput
     * @throws IOException
     * @throws InterruptedException
     */
    public static void executeCommand(ProcessBuilder pb, boolean showOutput) throws IOException, InterruptedException {
    	Process p = pb.start();
    	
		MyUtil.displayInputStream(p);
		MyUtil.displayErrorStream(p);
		System.out.println("Process exit value: " + p.waitFor());
    }
    
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
     * @param pattern the output pattern of the current date.
     * @return Realtime date and time formatted as {@code pattern}
     */
    public static String getDate(String pattern) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = new Date();
        return dateFormat.format(date);
    }

    /**
     * @return true if the Operational System is Windows
     */
    public static boolean isWindows() {
        return MyUtil.windows;
    }
    
    public static void singleFileChooser(Stage stage) {
        stage.setTitle("Select a File");

        FileChooser fileChooser = new FileChooser();
        File fileChoosed;
        fileChoosed = fileChooser.showOpenDialog(stage);

        fileChooser.setInitialFileName("yourfilename.txt");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPEG Files", "*.jpg"),
                new FileChooser.ExtensionFilter("PDF Files", "*.pdf"),
                new FileChooser.ExtensionFilter("PNG Files", "*.png"),
                new FileChooser.ExtensionFilter("TIFF Files", "*.tiff")
        );

        System.out.println("File Choosed: " + fileChoosed);
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
                fileWriter.write(MyUtil.getDate() + " " + content + "\n");
                fileWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(MyUtil.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fileWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(MyUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * @param content The content to be written
     * @param file The file to be written in
     * @param append Append the content to the existent text
     */
    public static void writeLogInFile(String content, File file, boolean append) {
        if (!content.isEmpty()) {
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(file, true);
                fileWriter.write(MyUtil.getDate() + " " + content + "\n");
                fileWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(MyUtil.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fileWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(MyUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
