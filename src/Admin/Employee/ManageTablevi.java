package Admin.Employee;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import static Admin.Employee.SidebuttonController.feeStru;
import USER.FEEPAY.FeeStructure;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ManageTablevi {
    private static Integer total;
    private static ObservableList<Manage> structure1;
    private static HashMap<String,String> map;
    private static FeeStructure fee;
       public ManageTablevi(Integer i) {
        int c = 1;
        fee = feeStru.get(i);
        if (i == 0) {
            structure1 = FXCollections.observableArrayList(new Manage(c++, "AdmissionFee", fee.getAdmissionFee()),
                    new Manage(c++, "DevelopmentFee", fee.getDevelopmentFee()), new Manage(c++, "MaintenenceFee", fee.getMaintenenceFee()),
                    new Manage(c++, "ManagementFee", fee.getManagementFee()), new Manage(c++, "TutionFee", fee.getTutionFee()));
            total = (Integer.parseInt(fee.getAdmissionFee()) + Integer.parseInt(fee.getDevelopmentFee()) + Integer.parseInt(fee.getMaintenenceFee()) + Integer.parseInt(fee.getManagementFee())
                    + Integer.parseInt(fee.getTutionFee()));
        } else {
            structure1 = FXCollections.observableArrayList(
                    new Manage(c++, "DevelopmentFee", fee.getDevelopmentFee()), new Manage(c++, "MaintenenceFee", fee.getMaintenenceFee()),
                    new Manage(c++, "ManagementFee", fee.getManagementFee()), new Manage(c++, "TutionFee", fee.getTutionFee()));
            total = (Integer.parseInt(fee.getDevelopmentFee()) + Integer.parseInt(fee.getMaintenenceFee()) + Integer.parseInt(fee.getManagementFee())
                    + Integer.parseInt(fee.getTutionFee()));
        }
    }

    
    public static ObservableList<Manage> getStructure1() {
        return structure1;

    }

    public static Integer getTotal() {
        return total;
    }
}
