
package YaParse;




import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author BullBuster
 */
public class YaParse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Connection.Response connection = null;
            
            connection = Jsoup.connect("https://news.yandex.ru/")
                    .execute();

            
            Document document = connection.parse();
            document.body().getElementsByClass("rubric").forEach(value ->{
                try {
                    
                    System.out.println(value.getElementsByClass("title").tagName("a").text());
                    System.out.println();          
                    final int i=value.siblingIndex();
                    value.getElementsByClass("story__content").forEach(e ->{
                        System.out.println(e.getElementsByClass("story__title").tagName("a").text());                        
                        if(e.getElementsByClass("story__text").hasText())
                            System.out.println(e.getElementsByClass("story__text").text());
                        System.out.println();
                    });  
                    System.out.println();
                    System.out.println();

                } catch (Exception ex) {
                    Logger.getLogger(YaParse.class.getName()).log(Level.SEVERE, null, ex);
                }
            });       
        } catch (IOException ex) {
            Logger.getLogger(YaParse.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}