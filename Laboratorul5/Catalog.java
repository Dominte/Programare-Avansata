import javax.print.Doc;
import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class Catalog {
    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", documents=" + documents +
                '}';
    }

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    private String name;
    private String path;
    public List<Document> documents;

    public Catalog(String name, String path, List<Document> documents) {
        this.name = name;
        this.path = path;
        this.documents = documents;
    }
    public void view(Document document) throws IOException, URISyntaxException {
        Desktop desktop = Desktop.getDesktop();
        File file=new File(document.getLocation());
        /* pentru link-uri */
        if(document.getLocation().contains("https://")){
            URI uri=new URI(document.getLocation());
            desktop.browse(uri);
        }
        else desktop.open(file);
        /* pentru files */
    }

    public void save(File file) throws IOException {

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream out = new ObjectOutputStream(fos);
        //scriem cate caractere avem in lista pentru metoda "load"
        out.writeInt(documents.size());
        //out.writeObject("Numele fisierului: \n");
        out.writeObject(this.name);
        //out.writeObject("Path-ul fisierului: \n");
        out.writeObject(this.path);
        for(int i=0;i<documents.size();i++) {
            out.writeObject(documents.get(i).getId());
            out.writeObject(documents.get(i).getName());
            out.writeObject(documents.get(i).getLocation());
        }
        out.flush();
        fos.close();
    }

    public void load(File file) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream in = new ObjectInputStream(fis);
        int ok= in.readInt(); //numarul de documente

        String message = (String) in.readObject();
        this.name=message;
        message = (String) in.readObject();
        this.path=message;

        while(ok>0) {
            Document document = new Document((String) in.readObject(),(String) in.readObject(),(String) in.readObject()); //linia 1 = ID, linia 2 = nume
            this.add(document);
            ok--;
        }
        fis.close();

    }

    public void add(Document doc) {
        documents.add(doc);
    }

    public Document findById(String id) {
        for (Document doc : documents) {
            if (doc.getId().equals(id)) {
                return doc;}}
        return null;}
}
