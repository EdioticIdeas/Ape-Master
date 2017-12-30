/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fee;

import static Fee.Fee_mainController.feeStruc;
import USER.FEEPAY.FeeStructure;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Tablevie {
    private static Integer total;
    private static ObservableList<stucture> structure1;
    private static HashMap<String,String> map;
    private static FeeStructure fee;
    public static String[] a;
    public Tablevie(HashMap<String, String> map) {
        Tablevie.map = map;
        a=map.values().toArray(new String[1]);
    }
    public Tablevie(Integer i) {
        int c = 1;
        fee = feeStruc.get(i);
        if (i == 0) {
            structure1 = FXCollections.observableArrayList(new stucture(c++, "AdmissionFee", fee.getAdmissionFee()),
                    new stucture(c++, "DevelopmentFee", fee.getDevelopmentFee()), new stucture(c++, "MaintenenceFee", fee.getMaintenenceFee()),
                    new stucture(c++, "ManagementFee", fee.getManagementFee()), new stucture(c++, "TutionFee", fee.getTutionFee()));
            total = (Integer.parseInt(fee.getAdmissionFee()) + Integer.parseInt(fee.getDevelopmentFee()) + Integer.parseInt(fee.getMaintenenceFee()) + Integer.parseInt(fee.getManagementFee())
                    + Integer.parseInt(fee.getTutionFee()));
        } else {
            structure1 = FXCollections.observableArrayList(
                    new stucture(c++, "DevelopmentFee", fee.getDevelopmentFee()), new stucture(c++, "MaintenenceFee", fee.getMaintenenceFee()),
                    new stucture(c++, "ManagementFee", fee.getManagementFee()), new stucture(c++, "TutionFee", fee.getTutionFee()));
            total = (Integer.parseInt(fee.getDevelopmentFee()) + Integer.parseInt(fee.getMaintenenceFee()) + Integer.parseInt(fee.getManagementFee())
                    + Integer.parseInt(fee.getTutionFee()));
        }
    }

    
    public static ObservableList<stucture> getStructure1() {
        return structure1;

    }

    public static Integer getTotal() {
        return total;
    }
}
