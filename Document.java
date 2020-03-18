public class Document {

    private String id;
    private String name;
    private String location;


    public Document(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Document(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Document " + "id='" + id + '\'' + ", name='" + name + '\'';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Document(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public void view(){

    }
}
