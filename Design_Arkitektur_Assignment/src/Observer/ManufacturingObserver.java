package Observer;

import BusinessObjects.CEO;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ManufacturingObserver{

    private PropertyChangeSupport propertyChangeSupport;



    public ManufacturingObserver() {
        propertyChangeSupport = new PropertyChangeSupport(this);

    }

    public void addPropertyChangeListener (PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void orderConfirmation (String item) {
        //När en produkt blir beställd skickas en notis
        System.out.println("* " +item + " has been sent to production *");
        //ceo.addOrder(item);
        propertyChangeSupport.firePropertyChange("New order", null,item);

    }

    public void finishedProduct (String item) {
        //När en produkt är klar att gå till kund skickas en notis
        System.out.println("* " + item + " is ready to be shipped to customer *");
        propertyChangeSupport.firePropertyChange("Product finished", null,item);
    }


}
