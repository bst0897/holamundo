
import org.jsoup.Connection;
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

        Document doc = Jsoup.connect(url).get();

        System.out.println("\n"+doc.title()+"\n");

        int lines = doc.html().split("\r\n | \r|\n").length;
        Elements parrafos = doc.select("p");
        Elements imgs = doc.select("img");
        Elements pForms = doc.select("form[method = POST]");
        Elements gForms = doc.select("form[method = GET]");


         System.out.println("Numero de Lineas : " + lines);
         System.out.println("Numero de Parrafos : " + parrafos.size());
         System.out.println("Numero de Imagenes : " + imgs.size());
         System.out.println("Numero de formularios POST: " + pForms.size());
         System.out.println("Numero de formularios GET: " + gForms.size());


         for (Element form : pForms){
             System.out.println("\n \nInputs de formularios POST");
             Elements inputs = form.select("input");
                    for(Element in : inputs){
                        System.out.println(in.normalName()+" "+in.attr("type"));
                    }
        }

        for (Element form : gForms){
            System.out.println("\n \nInputs de formularios GET");
            Elements inputs = form.select("input");
            for(Element in : inputs){
                System.out.println(in.normalName()+" "+in.attr("type"));
            }
        }
        for(Element form : pForms) {

            Connection.Response conn = Jsoup.connect(url)
            .method(Connection.Method.POST)
            .data("asignatura", "practica1")
            .header("matricula", "20150651")
            .execute();

            System.out.println("Respuesta: " + conn.statusCode() +" "+conn.statusMessage());
        }



    }


}
