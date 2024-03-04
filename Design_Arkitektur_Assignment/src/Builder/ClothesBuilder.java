package Builder;

interface ClothesBuilder {


     ClothesBuilder addMaterial(String material);
     ClothesBuilder addSize(String size);
     ClothesBuilder addColor(String color);

     Clothes build();

}
