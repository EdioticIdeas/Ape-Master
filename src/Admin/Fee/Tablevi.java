package Admin.Fee;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import static Admin.Fee.Fee_mainController.feeStru;
import USER.FEEPAY.FeeStructure;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Tablevi {
    private static Integer total;
    private static ObservableList<Stuctur> structure1;
    private static HashMap<String,String> map;
    private static FeeStructure fee;
    public static String[] a;
    public Tablevi(HashMap<String, String> map) {
        Tablevi.map = map;
        a=map.values().toArray(new String[0]);
    }
    public Tablevi(Integer i) {
        int c = 1;
        fee = feeStru.get(i);
        if (i == 0) {
            structure1 = FXCollections.observableArrayList(new Stuctur(c++, "AdmissionFee", fee.getAdmissionFee()),
                    new Stuctur(c++, "DevelopmentFee", fee.getDevelopmentFee()), new Stuctur(c++, "MaintenenceFee", fee.getMaintenenceFee()),
                    new Stuctur(c++, "ManagementFee", fee.getManagementFee()), new Stuctur(c++, "TutionFee", fee.getTutionFee()));
            total = (Integer.parseInt(fee.getAdmissionFee()) + Integer.parseInt(fee.getDevelopmentFee()) + Integer.parseInt(fee.getMaintenenceFee()) + Integer.parseInt(fee.getManagementFee())
                    + Integer.parseInt(fee.getTutionFee()));
        } else {
            structure1 = FXCollections.observableArrayList(
                    new Stuctur(c++, "DevelopmentFee", fee.getDevelopmentFee()), new Stuctur(c++, "MaintenenceFee", fee.getMaintenenceFee()),
                    new Stuctur(c++, "ManagementFee", fee.getManagementFee()), new Stuctur(c++, "TutionFee", fee.getTutionFee()));
            total = (Integer.parseInt(fee.getDevelopmentFee()) + Integer.parseInt(fee.getMaintenenceFee()) + Integer.parseInt(fee.getManagementFee())
                    + Integer.parseInt(fee.getTutionFee()));
        }
    }

    
    public static ObservableList<Stuctur> getStructure1() {
        return structure1;

    }

    public static Integer getTotal() {
        return total;
    }
    
}
