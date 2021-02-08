import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {


    static String getTextByLunar(String lunar) {
        String text = getTextByUrl("https://www.elle.ru/astro/" + lunar + "/day/");
        String regex = "(articleParagraph_dropCap\"><p>)([А-я.,\\s]*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        String result = "";
        while (matcher.find()) {
            result += matcher.group(2);
        }
        return result;
    }

    static String getTextByUrl(String url2) {
        String content = null;
        URLConnection connection = null;
        try {
            connection = new URL(url2).openConnection();
            Scanner scanner = new Scanner(connection.getInputStream(), "UTF-8");
            scanner.useDelimiter("\\Z");
            content = scanner.next();
            scanner.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return content;
    }
}
