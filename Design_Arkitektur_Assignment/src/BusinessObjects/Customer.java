package BusinessObjects;

import BusinessObjects.BusinessObject;

public class Customer extends BusinessObject {

    private String adress;
    private String emailAdress;
    public Customer () {

    }

    public Customer (int id, String name, String adress, String emailAdress) {
        super(id, name);
        this.adress = adress;
        this.emailAdress = emailAdress;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }
}
