package BusinessObjects;

public class BusinessObject {

    private int id;
    private String name;

    public BusinessObject() {
    }

    public BusinessObject(String name) {
        this.name = name;
    }

    public BusinessObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
