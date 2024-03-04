package Singleton;
import Builder.Clothes;
import BusinessObjects.Customer;
import BusinessObjects.Pants;
import BusinessObjects.Skirt;
import BusinessObjects.TShirt;
import java.util.ArrayList;
import java.util.List;


public class OrderService {

    private static OrderService instance;

    private List<Customer> customers;
    private List<Clothes> orders;

    private OrderService() {
        customers = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public static OrderService getInstance() {
        if(instance == null) {
            instance = new OrderService();
        }
        return instance;
    }

    public void addClothes (Clothes clothes) {
        orders.add(clothes);
    }
    public void addCustomer (Customer customer) {
        customers.add(customer);
    }

    public void printOrders() {
        double totalCost = 0.0;
        System.out.println("-----Receipt-----");
        for (Customer customer : customers) {
            System.out.println("Customer-ID: " + customer.getId());
            System.out.println("Name: " + customer.getName());
            System.out.println("Adress: " + customer.getAdress());
            System.out.println("Email: " + customer.getEmailAdress());
            System.out.println();
        }

        System.out.println("Ordered items:");
        for (Clothes clothes : orders) {
            if (clothes instanceof Pants) {
                clothes.setName("Pants");
            } else if (clothes instanceof TShirt) {
                clothes.setName("T-shirt");
            } else if (clothes instanceof Skirt) {
                clothes.setName("Skirt");
            }
        }
        for (Clothes clothes : orders) {
            System.out.println("Type of clothing: " + clothes.getName());
            System.out.println("Material: " + clothes.getMaterial());
            System.out.println("Size: " + clothes.getSize());
            System.out.println("Color: " + clothes.getColor());

            if (clothes instanceof Pants) {
                Pants pantsItem = (Pants) clothes;
                System.out.println("Fit: " + pantsItem.getFit());
                System.out.println("Length: " + pantsItem.getLength());
                totalCost += pantsItem.getPrice();
                System.out.println();
            } else if (clothes instanceof TShirt) {
                TShirt tShirtItem = (TShirt) clothes;
                System.out.println("Neck: " + tShirtItem.getNeck());
                System.out.println("Sleeves: " + tShirtItem.getNeck());
                totalCost += tShirtItem.getPrice();
                System.out.println();
            } else if (clothes instanceof Skirt) {
                Skirt skirtItem = (Skirt) clothes;
                System.out.println("Waist: " + skirtItem.getWaistline());
                System.out.println("Pattern: " + skirtItem.getPattern());
                totalCost += skirtItem.getPrice();
                System.out.println();
            }

        }
        System.out.println("Your total: " + totalCost +" $");
        System.out.println("Thank you for shopping!");
        System.out.println("------------------------------");


    }

}
