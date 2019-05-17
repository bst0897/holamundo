
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Favor digite una URL valida:");
        Scanner input = new Scanner(System.in);
        String url =input.nextLine();
        //System.out.println(url);

        Document doc = Jsoup.connect(url).get();

        log(doc.title());

        Elements newsHeadlines = doc.select("#mp-itn b a");
        Elements pngs = doc.select("img");
        Elements parrafos = doc.select("p");

        System.out.println("Numero de imagenes : " + pngs.size());
        System.out.println("Numero de Parrafos : " + parrafos.size());
        for (Element headline : newsHeadlines) {
            log("%s\n\t%s", headline.attr("title"), headline.absUrl("href"));
        }
    }

    private static void log(String msg, String... vals) {
        System.out.println(String.format(msg, vals));
    }
}
