/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fee;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author 17mri
 */
public class stucture {
    private final SimpleIntegerProperty no;
    private final SimpleStringProperty details;
    private final SimpleStringProperty amount;

    public stucture(Integer no,String details, String amount) {
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

    public String getAmount() {
        return amount.get();
    }

}
