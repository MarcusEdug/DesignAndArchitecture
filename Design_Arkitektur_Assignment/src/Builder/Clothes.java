 package Builder;

 import BusinessObjects.BusinessObject;
 import java.util.List;

 public class Clothes extends BusinessObject {

    private String material;
    private String size;
    private String color;
    private double price;
    private String name;
    private int id;


    public Clothes () {

    }

    public Clothes (String name) {
        this.name = name;
    }

    public Clothes(String name ,String size, String color, String material) {
        super(name);
        this.material = material;
        this.size = size;
        this.color = color;
        this.name = name;

    }



     public String getMaterial() {
         return material;
     }

     public void setMaterial(String material) {
         this.material = material;
     }

     public String getSize() {
         return size;
     }

     public void setSize(String size) {
         this.size = size;
     }

     public String getColor() {
         return color;
     }

     public void setColor(String color) {
         this.color = color;
     }

     public double getPrice() {
         return price;
     }

     public void setPrice(double price) {
         this.price = price;
     }

 }


