import java.io.*;

public class FileManager {
    // The path to the file to be written and read
    private final static String FILE_PATH = "resources/save.txt";

    /**
     * Writes a string to a file at the file path specified by FILE_PATH.
     *
     * @param string the string to write to the file
     */
    public static void write(String string){
        // Create a BufferedWriter object to write to the file
        BufferedWriter bWriter  = null;

        try {
            // Initialize the BufferedWriter object with a FileWriter object
            // and set the FILE_PATH as the file to write to
            bWriter = new BufferedWriter(new FileWriter(FILE_PATH));
            // Write the string to the file
            bWriter.write(string);
            // Flush the stream to ensure that all data is written to the file
            bWriter.flush();
        } catch (IOException e) {
            // If an exception is caught, print the stack trace
            e.printStackTrace();
        } finally {
            // Close the BufferedWriter object in a finally block
            // to ensure that it is always closed, even if an exception is thrown
            if(bWriter != null){
                try{
                    bWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * Reads a string from a file at the file path specified by FILE_PATH.
     *
     * @return the string read from the file
     */
    public static String read(){

        // Create a BufferedReader object to read from the file
        BufferedReader bReader = null;

        // Create a StringBuilder object to store the string read from the file
        StringBuilder stringBuilder = new StringBuilder();

        try {
            // Initialize the BufferedReader object with a FileReader object
            // and set the FILE_PATH as the file to read from
            bReader = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            // Read each line from the file and append it to the StringBuilder object
            while ((line = bReader.readLine()) != null){
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            // Return the string read from the file as a String
            return stringBuilder.toString();
        } catch (IOException e){
            // If an exception is caught, print the stack trace and return null
            e.printStackTrace();;
            return null;
        } finally {
            // Close the BufferedReader object in a finally block
            // to ensure that it is always closed, even if an exception is thrown
            if(bReader != null){
                try {
                    bReader.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

}
