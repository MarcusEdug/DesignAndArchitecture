package BusinessObjects;

import Builder.Clothes;
import BusinessObjects.BusinessObject;

public class TShirt extends Clothes {

    private int id;
    private String name;
    private String size;
    private double price = 99.90;
    private String material;
    private String color;
    private int sleeves;
    private String neck;

    public TShirt () {

    }

    public TShirt( String size, String material, String color) {
        super("T-Shirt");
        this.size = size;
        this.material = material;
        this.color = color;

    }


    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSleeves() {
        return sleeves;
    }

    public void setSleeves(int sleeves) {
        this.sleeves = sleeves;
    }

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
