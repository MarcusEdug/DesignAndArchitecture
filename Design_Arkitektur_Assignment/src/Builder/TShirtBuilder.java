package Builder;

import BusinessObjects.TShirt;

public class TShirtBuilder implements ClothesBuilder{

    private TShirt tShirt = new TShirt();


    @Override
    public TShirtBuilder addMaterial (String material) {
        tShirt.setMaterial(material);
        return this;
    }

    @Override
    public TShirtBuilder addSize (String size) {
        tShirt.setSize(size);
        return this;
    }

    @Override
    public TShirtBuilder addColor (String color) {
        tShirt.setColor(color);
        return this;
    }

    @Override
    public TShirt build() {
        if (tShirt.getMaterial() == null) {
            throw new RuntimeException("Material missing");
        } else if (tShirt.getSize() == null) {
            throw new RuntimeException("Size missing");
        } else if (tShirt.getColor() == null) {
            throw new RuntimeException("Color missing");
        }
        return tShirt;
    }

}
