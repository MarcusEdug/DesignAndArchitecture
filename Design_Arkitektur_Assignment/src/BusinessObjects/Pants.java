package BusinessObjects;

import Builder.Clothes;
import Builder.PantsBuilder;
import BusinessObjects.BusinessObject;

public class Pants extends Clothes {


    /*private String size;*/
    private double price = 149.90;
  /*  private String material;
    private String color;*/
    private String fit;
    private int length;

    public Pants () {

    }

    public Pants(String name,String material, String size, String color) {
        super("Pants",material,size,color);

    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

}
