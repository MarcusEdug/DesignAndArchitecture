package BusinessObjects;

import BusinessObjects.BusinessObject;
import Observer.ManufacturingObserver;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class CEO implements PropertyChangeListener {

    private int id;
    private String name = "";
    private List<String> orders; //Lista för att lagra beställningar
    private PropertyChangeSupport propertyChangeSupport;

    public CEO() {
        orders = new ArrayList<>();
        propertyChangeSupport = new PropertyChangeSupport(this);

    }

    public CEO(int id, String name) {
        this.id = id;
        this.name = name;

    }


    public void addPropertyChangeListener (PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void setName (String name) {
        String oldName = this.name;
        this.name = name;
        this.propertyChangeSupport.firePropertyChange("Order placed", oldName,name);
    }

    public void addOrder(String newOrder) {
        orders.add(newOrder);
        System.out.println("CEO: New order added - " + newOrder);
    }

    public void printOrders(List<String> orders) {
        System.out.println("CEO: All orders ready to be shipped: ");
        for (String order : orders) {
            System.out.println(order);

        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("New order")) {
            addOrder((String) evt.getNewValue());
        } else if (evt.getPropertyName().equals("Product finished")) {
            printOrders(orders);
        }

    }

}




