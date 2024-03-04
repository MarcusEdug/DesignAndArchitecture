package Menu;

import Builder.*;
import BusinessObjects.*;
import Command.*;
import Observer.ManufacturingObserver;
import Singleton.OrderService;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuHandler {

    private boolean running = true;
    private Scanner scanner;
    private PantsBuilder pantsBuilder = new PantsBuilder();
    private TShirtBuilder tShirtBuilder = new TShirtBuilder();
    private SkirtBuilder skirtBuilder = new SkirtBuilder();
    private ManufacturingObserver observer = new ManufacturingObserver();
    private CEO ceo = new CEO();
    private Customer customer;
    private OrderService orderService = OrderService.getInstance();

    private Pants pants;

    private TShirt tShirt;
    private Skirt skirt;


    public MenuHandler() {
    }

    public void runMenu() {
        customerInputDetails();
        scanner = new Scanner(System.in);
        observer.addPropertyChangeListener(ceo);

        while (running) {
            try {
                System.out.println();
                System.out.println("**Welcome to Clothes on Demand!**");
                System.out.println("What are you looking for today? (1-4)");
                System.out.println("1. Pants");
                System.out.println("2. T-Shirt");
                System.out.println("3. Skirt");
                System.out.println("4. Quit");
                int userInput = scanner.nextInt(); //Integer.parseInt(scanner.nextLine());
                scanner.nextLine();
                switch (userInput) {
                    case 1:
                        handlePants();
                        break;
                    case 2:
                        handleTshirt();
                        break;
                    case 3:
                        handleSkirt();
                        break;
                    case 4:
                        System.out.println("Bye!\nPlease come back soon!");
                        running = false;
                        break;
                    default:
                        System.out.println("Please select an option from the menu (1-4)\n");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid option");
                scanner.next();
            }
        }
        scanner.close();
    }


    public void handlePants() {
        String userChoice;
        boolean validChoice = false;

        while (!validChoice) {
            System.out.println("Choose type of material for your Pants: (Jeans/Manchester)");
            userChoice = scanner.nextLine();
            if (userChoice.equalsIgnoreCase("Jeans") || userChoice.equalsIgnoreCase("Manchester")) {
                pantsBuilder.addMaterial(userChoice);
                validChoice = true;
            } else {
                System.out.println("Please select a valid material (Jeans/Manchester)");
                System.out.println();
                continue; //Återgår till början av loopen
            }
            while (true) {
                System.out.println("Choose your size: (M/L)");
                userChoice = scanner.nextLine();
                if (userChoice.equalsIgnoreCase("M") || userChoice.equalsIgnoreCase("L")) {
                    pantsBuilder.addSize(userChoice);
                    validChoice = true;
                    break;
                } else {
                    System.out.println("Please select valid size: (M/L)");
                    System.out.println();
                    validChoice = false;
                    continue;
                }
            }
            while (true) {
                System.out.println("Choose your color: (Blue/Brown)");
                userChoice = scanner.nextLine();
                if (userChoice.equalsIgnoreCase("Blue") || userChoice.equalsIgnoreCase("Brown")) {
                    pantsBuilder.addColor(userChoice);
                    pants = pantsBuilder.build();
                    validChoice = true;
                    break;
                } else {
                    System.out.println("Please select a valid color: (Blue/Brown)");
                    System.out.println();
                    validChoice = false;
                    continue;

                }
            }
            while (true) {
                System.out.println("Please select your preferred fit: (Slim/Regular/Wide)");
                userChoice = scanner.nextLine();
                if (userChoice.equalsIgnoreCase("Slim") || userChoice.equalsIgnoreCase("Regular") || userChoice.equalsIgnoreCase("Wide")) {
                    SewCommand sewPantFitCommand = new SewCommand(pants, userChoice);
                    sewPantFitCommand.decorate();
                    validChoice = true;
                    break;
                } else {
                    System.out.println("Please select a valid fit: (Slim/Regular/Wide");
                    System.out.println();
                    validChoice = false;
                    continue;
                }
            }
            while (true) {
                try {
                    System.out.println("Please select your preferred length: (60/70/80)");
                    int userInput = Integer.parseInt(scanner.nextLine());
                    if (userInput == 60 || userInput == 70 || userInput == 80) {
                        CutCommand cutCommand = new CutCommand(pants,userInput);
                        cutCommand.decorate();
                        orderService.addClothes(pants);
                        observer.orderConfirmation("Pants");
                        System.out.println();
                        validChoice = true;
                        break;
                    } else {
                        System.out.println("Please select a valid length: (60/70/80)");
                        System.out.println();
                        validChoice = false;
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please use numbers to select your length");
                }
            }
            if (pants != null) {
                System.out.println("Continue shopping? (Y/N)");
                userChoice = scanner.nextLine();
                if (userChoice.equalsIgnoreCase("Y")) {
                    running = true;
                } else if (userChoice.equalsIgnoreCase("N")) {
                    observer.finishedProduct("Pants");
                    orderService.printOrders();
                    running = false;

                } else {
                    System.out.println("Please select valid option: (Y/N)");
                    System.out.println();
                    validChoice = false;
                }
            }
        }
    }


    public void handleTshirt() {
        System.out.println("Choose type of material for your T-Shirt: (Cotton/Polyester)");
        String userChoice;
        boolean validChoice = false;

        while (!validChoice) {
            userChoice = scanner.nextLine();
            if (userChoice.equalsIgnoreCase("Cotton") || userChoice.equalsIgnoreCase("Polyester")) {
                tShirtBuilder.addMaterial(userChoice);
                validChoice = true;
            } else {
                System.out.println("Please chose a valid material: (Cotton/Polyester)");
                System.out.println();
                validChoice = false;
                continue;
            }
            while (true) {
                System.out.println("Choose your size: (M/L)");
                userChoice = scanner.nextLine();
                if (userChoice.equalsIgnoreCase("M") || userChoice.equalsIgnoreCase("L")) {
                    tShirtBuilder.addSize(userChoice);
                    validChoice = true;
                    break;
                } else {
                    System.out.println("Please select valid size: (M/L)");
                    System.out.println();
                    validChoice = false;
                    continue;
                }
            }
            while (true) {
                System.out.println("Choose your color: (Black/White)");
                userChoice = scanner.nextLine();
                if (userChoice.equalsIgnoreCase("Black") || userChoice.equalsIgnoreCase("White")) {
                    tShirtBuilder.addColor(userChoice);
                    tShirt = tShirtBuilder.build();
                    validChoice = true;
                    break;
                } else {
                    System.out.println("Please select a valid color (Black/White)");
                    System.out.println();
                    validChoice = false;
                    continue;
                }
            }
            while (true) {
                System.out.println("Please select your preferred neck: (Wide/Slim/Turtle)");
                userChoice = scanner.nextLine();
                if (userChoice.equalsIgnoreCase("Wide") || userChoice.equalsIgnoreCase("Slim") || userChoice.equalsIgnoreCase("Turtle")) {
                    SewCommand sewTShirtNeckCommand = new SewCommand(tShirt, userChoice);
                    sewTShirtNeckCommand.decorate();
                    validChoice = true;
                    break;
                } else {
                    System.out.println("Please select a valid neck: (Wide/Slim/Turtle)");
                    System.out.println();
                    validChoice = false;
                    continue;
                }
            }
            while (true) {
                System.out.println("Please select your preferred sleeve length: (10/20/30)");
                try {
                    int userInput = Integer.parseInt(scanner.nextLine());
                    if (userInput == 10 || userInput == 20 || userInput == 30) {
                        CutCommand cutCommand = new CutCommand(tShirt, userInput);
                        cutCommand.decorate();
                        orderService.addClothes(tShirt);
                        observer.orderConfirmation("T-Shirt");
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Please select a valid sleeve length: (10/20/30)");
                        validChoice = false;
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please use numbers to select sleeve length");
                    validChoice = false;
                    continue;
                }
            }
                if (tShirt != null) {
                    System.out.println("Continue shopping? (Y/N)");
                    userChoice = scanner.nextLine();
                    if (userChoice.equals("Y")) {
                        running = true;
                        validChoice = true;
                    } else if (userChoice.equals("N")) {
                        observer.finishedProduct("T-Shirt");
                        orderService.printOrders();
                        running = false;
                        break;
                    } else {
                        System.out.println("Please select valid option: (Y/N)");
                        System.out.println();
                        return;
                    }
                }
            }
        }


    public void handleSkirt () {
        System.out.println("Choose type of material for your Skirt (Jeans/Cotton)");
        String userChoice;
        boolean validChoice = false;

        while (!validChoice) {
            userChoice = scanner.nextLine();
            if (userChoice.equalsIgnoreCase("Jeans") || userChoice.equalsIgnoreCase("Cotton")) {
                skirtBuilder.addMaterial(userChoice);
                validChoice = true;
            } else {
                System.out.println("Please select a valid material: (Jeans/Cotton)");
                System.out.println();
                continue;
            }
            while (true) {
                System.out.println("Choose your size: (M/L)");
                userChoice = scanner.nextLine();
                if (userChoice.equalsIgnoreCase("M") || userChoice.equalsIgnoreCase("L")) {
                    skirtBuilder.addSize(userChoice);
                    validChoice = true;
                    break;
                } else {
                    System.out.println("Please select valid size: (M/L)");
                    System.out.println();
                    validChoice = false;
                    continue;
                }
            }
            while (true) {
                System.out.println("Choose your color: (Blue/White)");
                userChoice = scanner.nextLine();
                if (userChoice.equalsIgnoreCase("Blue") || userChoice.equalsIgnoreCase("White")) {
                    skirtBuilder.addColor(userChoice);
                    skirt = skirtBuilder.build();
                    validChoice = true;
                    break;
                } else {
                    System.out.println("Please select a valid color: (Blue/White)");
                    System.out.println();
                    validChoice = false;
                    continue;
                }
            }
            while (true) {
                System.out.println("Please select your preferred waist: (Slim/Regular/Wide)");
                String userInput = scanner.nextLine();
                if (userInput.equalsIgnoreCase("Slim") || userInput.equalsIgnoreCase("Regular") || userInput.equalsIgnoreCase("Wide")) {
                    SewCommand sewSkirtWaistCommand = new SewCommand(skirt, userInput);
                    sewSkirtWaistCommand.addAlteration("Waist");
                    sewSkirtWaistCommand.decorate();
                    validChoice = true;
                    break;
                } else {
                    System.out.println("Please select a valid waist: (Slim/Regular/Wide)");
                    System.out.println();
                    validChoice = false;
                    continue;
                }
            }
                while (true) {
                    System.out.println("Please select your preferred pattern: (Checkerboard/Plain/Stripe)");
                    userChoice = scanner.nextLine();
                    if (userChoice.equalsIgnoreCase("Checkerboard") || userChoice.equalsIgnoreCase("Plain") || userChoice.equalsIgnoreCase("Stripe")) {
                        SewCommand sewSkirtPatternCommand = new SewCommand(skirt, userChoice);
                        sewSkirtPatternCommand.addAlteration("Pattern");
                        sewSkirtPatternCommand.decorate();
                        orderService.addClothes(skirt);
                        observer.orderConfirmation("Skirt");
                        validChoice = true;
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Please select a valid pattern: (Checkerboard/Plain/Stripe)");
                        validChoice = false;
                        continue;
                    }
                }
                if (skirt != null) {
                    System.out.println("Continue shopping? (Y/N)");
                    userChoice = scanner.nextLine();
                    if (userChoice.equals("Y")) {
                        running = true;
                    } else if (userChoice.equals("N")) {
                        observer.finishedProduct("Skirt");
                        orderService.printOrders();
                        running = false;
                        return;
                    }
                } else {
                    System.out.println("Please select valid option: (Y/N)");
                    System.out.println();
                    return;
                }
            }
        }

    private void customerInputDetails() {
        scanner = new Scanner(System.in);
        System.out.println("Please enter your details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Adress: ");
        String adress = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        if (name.isEmpty() || adress.isEmpty() || email.isEmpty()) {
            System.out.println("Please enter your details");
        } else {
            //Skapar en ny customer med de inmatade detaljerna
            customer = new Customer(1, name,adress,email);
            orderService.addCustomer(customer);
        }

    }
    public void customerReceipt () {
        System.out.println();
        System.out.println("----- Receipt -----");
        System.out.println("Customer details:");
        System.out.println("Customer-ID: " + customer.getId());
        System.out.println("Name: " + customer.getName());
        System.out.println("Adress: " + customer.getAdress());
        System.out.println("Email: " + customer.getEmailAdress());
        System.out.println();
        double totalCost = 0.0;
        if (pants != null) {
            System.out.println("Pants:");
            System.out.println("Material: " + pants.getMaterial());
            System.out.println("Size: " + pants.getSize());
            System.out.println("Color: " + pants.getColor());
            System.out.println("Fit: " + pants.getFit());
            System.out.println("Length: " + pants.getLength() +" cm");
            System.out.println("Total : " + pants.getPrice() + " $");
            System.out.println();
            totalCost += pants.getPrice();
        }

        if (tShirt != null) {
            System.out.println("T-Shirt:");
            System.out.println("Material: " + tShirt.getMaterial());
            System.out.println("Size: " + tShirt.getSize());
            System.out.println("Color: " + tShirt.getColor());
            System.out.println("Neck: " + tShirt.getNeck());
            System.out.println("Sleeves: " + tShirt.getSleeves() +" cm");
            System.out.println("Total : " + tShirt.getPrice() + " $");
            System.out.println();
            totalCost += tShirt.getPrice();
        }

        if (skirt != null) {
            System.out.println("Skirt:");
            System.out.println("Material: " + skirt.getMaterial());
            System.out.println("Size: " + skirt.getSize());
            System.out.println("Color: " + skirt.getColor());
            System.out.println("Waist: " + skirt.getWaistline());
            System.out.println("Pattern: " + skirt.getPattern());
            System.out.println("Total : " + skirt.getPrice() + " $");
            System.out.println();
            totalCost += skirt.getPrice();
        }

        System.out.println("Your total: " + totalCost + " $");
        System.out.println("Thank you for shopping!");
        System.out.println("------------------------");
        running = false;
    }

}
