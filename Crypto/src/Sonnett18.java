import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Sonnett18 {
    private ROT13 rot13;

    public Sonnett18() {
        this.rot13 = new ROT13();
    }

    public String loadFile(String fileName) {
        File file = new File(fileName);
        StringBuilder result = new StringBuilder();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public void encryptThenWriteToFile(String toEncrypt, String writeTo) {
        try {
            String encrypt = encryptFile(toEncrypt);
            FileWriter fileWriter = new FileWriter(writeTo);
            fileWriter.write(encrypt);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String encryptFile(String fileName) {
        String original = loadFile(fileName);
        return rot13.crypt(original);
    }
}
