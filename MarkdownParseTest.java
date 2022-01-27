// javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java
// java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest

import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class MarkdownParseTest {
    public static ArrayList<String> Links (String markdown) throws IOException{
        Path fileName = Path.of(markdown);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        return links;
    }    
    @Test
    public void addition() throws IOException{
        assertEquals(2, 1 + 1);
        assertEquals(List.of("https://ucsd-cse15l-w22.github.io/week/week3/"), Links("test-file2.md"));
    }
    @Test
    public void testMarkdownParse() throws IOException{
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(contents));
    }
}
