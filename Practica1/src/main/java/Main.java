
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Favor digite una URL valida:/n");
        Scanner input = new Scanner(System.in);
        String url =input.nextLine();
        System.out.println(url);

        Document doc = Jsoup.connect(url).get();
        log(doc.title());

        Elements newsHeadlines = doc.select("#mp-itn b a");
        for (Element headline : newsHeadlines) {
            log("%s\n\t%s", headline.attr("title"), headline.absUrl("href"));
        }
    }

    private static void log(String msg, String... vals) {
        System.out.println(String.format(msg, vals));
    }
}
