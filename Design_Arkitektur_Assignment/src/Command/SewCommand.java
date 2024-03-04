package Command;

import Builder.Clothes;
import BusinessObjects.Pants;
import BusinessObjects.Skirt;
import BusinessObjects.TShirt;

import java.util.ArrayList;
import java.util.List;

public class SewCommand implements Command {

    private Clothes clothes;
    private Pants pants;
    private TShirt tShirt;
    private Skirt skirt;
    private String partToSew;
    private List<String> alterations;

    public SewCommand(Clothes clothes, String partToSew) {
        this.clothes = clothes;
        this.partToSew = partToSew;
        alterations = new ArrayList<>();
        if (clothes instanceof Pants) {
            pants = (Pants) clothes;
            } else if (clothes instanceof TShirt) {
            tShirt = (TShirt) clothes;
        } else if (clothes instanceof Skirt) {
            skirt = (Skirt) clothes;
        } else {
            System.out.println("Unsupported clothing");
        }
    }

    public void addAlteration (String alteration) {
        alterations.add(alteration);
    }
    public void addPantFitCommand() {
        if (pants != null) {
            pants.setFit(partToSew);
        }
    }

    public void addSkirtPatternCommand () {
        if (skirt != null) {
            skirt.setPattern(partToSew);
        }
    }
    public void addSkirtWaistCommand () {
        if (skirt != null) {
            skirt.setWaistline(partToSew);
        }
    }

    public void addTShirtNeckCommand () {
        if (tShirt != null) {
            tShirt.setNeck(partToSew);
        }
    }
    @Override
    public void decorate() {
        if (clothes instanceof Pants) {
            addPantFitCommand();
        } else if (clothes instanceof Skirt) {
            for (String alteration : alterations) {
                switch (alteration) {
                    case "Waist":
                        addSkirtWaistCommand();
                        break;
                    case "Pattern":
                        addSkirtPatternCommand();
                        break;
                    default:
                        System.out.println("Unsupported alteration for Skirt");
                        break;
                }
            }
        } else if (clothes instanceof TShirt) {
            addTShirtNeckCommand();
        } else {
            System.out.println("Unsupported clothing");
        }

    }
}
