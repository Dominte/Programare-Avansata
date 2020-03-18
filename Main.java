import javax.print.Doc;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Main {




    public static void main(String[] args) throws IOException, ClassNotFoundException, URISyntaxException {
        Document d1=new Document("A","A","https://profs.info.uaic.ro/~acf/java/");
        Document d2=new Document("B","B","B");
        Document d3=new Document("C","C","C");

	    Catalog catalog = new Catalog("Catalog1","!@#");
    	catalog.documents=new ArrayList<>();
    	catalog.add(d1);
    	catalog.add(d2);
    	catalog.add(d3);
        System.out.println(catalog);

        File a = new File("H:/file.txt");
        catalog.save(a);
        catalog.load(a);
        System.out.println(catalog);

        catalog.view(d1);
    }
}
