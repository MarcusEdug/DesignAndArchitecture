package Builder;


import BusinessObjects.Skirt;

public class SkirtBuilder implements ClothesBuilder {

  private Skirt skirt = new Skirt();

  @Override
    public SkirtBuilder addMaterial (String material) {
        skirt.setMaterial(material);
        return this;
    }

    @Override
    public SkirtBuilder addSize (String size) {
        skirt.setSize(size);
        return this;
    }

    @Override
    public SkirtBuilder addColor (String color) {
        skirt.setColor(color);
        return this;
    }

    @Override
    public Skirt build() {
        if (skirt.getMaterial() == null) {
            throw new RuntimeException("Material missing");
        } else if (skirt.getSize() == null) {
            throw new RuntimeException("Size missing");
        } else if (skirt.getColor() == null) {
            throw new RuntimeException("Color missing");
        }
        return skirt;
    }

}
