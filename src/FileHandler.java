import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileHandler {
    private final FileWriter fileWriter = new FileWriter("OutputFile.txt");
    private final PrintWriter printWriter = new PrintWriter(fileWriter);

    public FileHandler() throws IOException {
    }
    public void writeToFile(String string) {
        printWriter.printf(string + "\n");
    }

    public void close() {
        printWriter.close();
    }
}
