// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")", openParen);

            if (nextOpenBracket == -1 || nextCloseBracket == -1 || openParen == -1 || closeParen == -1){
                break;
            }
            if (nextOpenBracket != 0) {
                if (markdown.charAt(nextOpenBracket-1) != '!') {
                    if (! markdown.substring(openParen + 1, closeParen).contains(" ")) {
                        toReturn.add(markdown.substring(openParen + 1, closeParen));    
                    }
                }
            }
            else
            {
                toReturn.add(markdown.substring(openParen + 1, closeParen));
            }

            
            currentIndex = closeParen + 1;
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}
