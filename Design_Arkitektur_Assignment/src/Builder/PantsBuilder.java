package Builder;

import BusinessObjects.Pants;

public class PantsBuilder implements ClothesBuilder {

    private Pants pants = new Pants();



    @Override
    public PantsBuilder addMaterial(String material) {
        if (material.equalsIgnoreCase("Jeans") || material.equalsIgnoreCase("Manchester")){
            pants.setMaterial(material);
            return this;
        } else {
            System.out.println("Please select a valid color");
        }
        return null;
    }

    @Override
    public PantsBuilder addSize(String size) {
        if (size.equalsIgnoreCase("M") || size.equalsIgnoreCase("L")) {
            pants.setSize(size);
            return this;
        }else {
            System.out.println("Please select a valid size");
        }
        return null;
    }

    @Override
    public PantsBuilder addColor(String color) {
        if (color.equalsIgnoreCase("Blue") || color.equalsIgnoreCase("Brown")) {
            pants.setColor(color);
            return this;
        } else {
            System.out.println("Please select a vail color");
        }
        return null;
    }


    @Override
    public Pants build() {
        if (pants.getMaterial() == null) {
            throw new RuntimeException("Material missing");
        } else if (pants.getSize() == null) {
            throw new RuntimeException("Size missing");
        } else if (pants.getColor() == null) {
            throw new RuntimeException("Color missing");
        }
        return pants;
    }
}
