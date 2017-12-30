package Admin.Fee;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author 17mri
 */
public class Stuctur {
    private final SimpleIntegerProperty no;
    private final SimpleStringProperty details;
    private  SimpleStringProperty amount;

   
    

    
    public Stuctur(Integer no,String details, String amount) {
        this.details = new SimpleStringProperty(details);
        this.amount = new SimpleStringProperty(amount);
        this.no=new SimpleIntegerProperty(no);
    }
    

    public Integer getNo() {
        return no.get();
    }

    public String getDetails() {
        return details.get();
    }
    public void setamout(String amount) {
        this.amount = new SimpleStringProperty(amount);
    }
    public String getAmount() {
        return amount.get();
    }
    
}
