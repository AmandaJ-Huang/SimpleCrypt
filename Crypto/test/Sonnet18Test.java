import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class Sonnet18Test {

    @Test
    public void testLoadFile() {
        // Given
        Sonnett18 sonnett18 = new Sonnett18();
        String sonnet18 = "sonnet18.txt";
        String expected = "Shall I compare thee to a summer’s day?\n" +
                "Thou art more lovely and more temperate:\n" +
                "Rough winds do shake the darling buds of May,\n" +
                "And summer’s lease hath all too short a date;\n" +
                "Sometime too hot the eye of heaven shines,\n" +
                "And often is his gold complexion dimm'd;\n" +
                "And every fair from fair sometime declines,\n" +
                "By chance or nature’s changing course untrimm'd;\n" +
                "But thy eternal summer shall not fade,\n" +
                "Nor lose possession of that fair thou ow’st;\n" +
                "Nor shall death brag thou wander’st in his shade,\n" +
                "When in eternal lines to time thou grow’st:\n" +
                "   So long as men can breathe or eyes can see,\n" +
                "   So long lives this, and this gives life to thee.\n";

        // When
        String actual = sonnett18.loadFile(sonnet18);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEncryptFile() {
        // Given
        Sonnett18 sonnett18 = new Sonnett18();
        String originalFile = "sonnet18.txt";
        String encryptedFile = "sonnet18enc.txt";
        String original = sonnett18.loadFile(originalFile);

        // When
        sonnett18.encryptThenWriteToFile(originalFile, encryptedFile);
        sonnett18.encryptThenWriteToFile(encryptedFile, encryptedFile);
        String encrypted = sonnett18.loadFile(encryptedFile);

        // Then
        Assert.assertEquals(original, encrypted);

    }
}
