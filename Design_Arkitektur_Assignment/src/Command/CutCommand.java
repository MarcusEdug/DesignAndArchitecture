package Command;

import Builder.Clothes;
import BusinessObjects.Pants;
import BusinessObjects.TShirt;

public class CutCommand implements Command{

    private Clothes clothes;
    private TShirt tShirt;
    private Pants pants;
    private int amountToCut;

    public CutCommand(Clothes clothes , int amountToCut) {
        this.clothes = clothes;
        this.amountToCut = amountToCut;
        if (clothes instanceof Pants) {
            pants = (Pants) clothes;
        } else if (clothes instanceof TShirt) {
            tShirt = (TShirt) clothes;
        }
    }

    public void addSleeveCommand() {
        if (tShirt != null) {
            tShirt.setSleeves(amountToCut);
        }
    }


    public void addPantLengthCommand () {
        if (pants != null) {
            pants.setLength(amountToCut);
        }
    }

    @Override
    public void decorate() {
        if (clothes instanceof Pants) {
            addPantLengthCommand();
        } else if (clothes instanceof TShirt) {
            addSleeveCommand();
        } else {
            System.out.println("Unsupported clothing");
        }

    }

}
