package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan
        String studentNr = "014507395";
        int hours=0;
        int exersices =0;
        int week = 0;
        
        
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2017.herokuapp.com/students/"+studentNr+"/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        System.out.println("json-muotoinen data:");
        System.out.println( bodyText );

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        System.out.println("Kurssi: Ohjelmistotuotanto, kevät 2017");
        System.out.println(" ");
        System.out.println("opiskelijanumero: " + studentNr);
        System.out.println(" ");
        for (Submission submission : subs) {
            System.out.println(submission);
            exersices +=submission.getAllA();
            hours += submission.getHours();        
           

            
            
        }
        System.out.println("");
        System.out.println("yhteensä: " + exersices + " tehtävää " + hours + " tuntia");

    }
}