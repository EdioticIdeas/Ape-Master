/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Mukul
 */
public class Library_inventoryController implements Initializable {

    @FXML
    private GridPane inventory;
    
        @FXML
    private GridPane lib_anchor_inventory;
        
        TableView<Product> table;
        TextField Sr_NoInput, Book_NameInput, AuthorInput, Issue_DateInput, CopiesInput;
        
        public void makeTable(){
             //Serial Number column
        TableColumn<Product, String> Sr_NoColumn = new TableColumn<>("Serial");
        Sr_NoColumn.setMinWidth(100);
        Sr_NoColumn.setCellValueFactory(new PropertyValueFactory<>("Sr_No"));
        
         //Book Name column
        TableColumn<Product, String> Book_NameColumn = new TableColumn<>("Book Name");
        Book_NameColumn.setMinWidth(200);
        Book_NameColumn.setCellValueFactory(new PropertyValueFactory<>("Book_Name"));
        
         //Author column
        TableColumn<Product, String> AuthorColumn = new TableColumn<>("Author");
        AuthorColumn.setMinWidth(200);
        AuthorColumn.setCellValueFactory(new PropertyValueFactory<>("Author"));
        
         //Issue date column
        TableColumn<Product, String>Issue_DateColumn = new TableColumn<>("Publish Year");
        Issue_DateColumn.setMinWidth(200);
        Issue_DateColumn.setCellValueFactory(new PropertyValueFactory<>("Issue_Date"));
        
         //Copies column
        TableColumn<Product, Integer> CopiesColumn = new TableColumn<>("Copies");
        CopiesColumn.setMinWidth(200);
        CopiesColumn.setCellValueFactory(new PropertyValueFactory<>("Copies"));

      

        //Name input
        Sr_NoInput = new TextField();
        Sr_NoInput.setPromptText("Sr_No");
        Sr_NoInput.setMinWidth(80);

     //Name input
        Book_NameInput = new TextField();
        Book_NameInput.setPromptText("Book_Name");
        Book_NameInput.setMinWidth(80);
        
        //Name input
        AuthorInput = new TextField();
        AuthorInput.setPromptText("Author");
        AuthorInput.setMinWidth(80);
        
        //Name input
        Issue_DateInput = new TextField();
        Issue_DateInput.setPromptText("Issue_Date");
        Issue_DateInput.setMinWidth(80);

        //Quantity input
        CopiesInput = new TextField();
        CopiesInput.setPromptText("Copies");
        CopiesInput.setMinWidth(80);

        //Button
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(Sr_NoInput, Book_NameInput, AuthorInput, Issue_DateInput, CopiesInput);
        
        HBox hBox2 = new HBox();
        hBox2.setPadding(new Insets(10,10,10,10));
        hBox2.setSpacing(10);
        hBox2.getChildren().addAll(addButton,deleteButton);

        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(Sr_NoColumn, Book_NameColumn, AuthorColumn, Issue_DateColumn,CopiesColumn );

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox,hBox2);
        
        lib_anchor_inventory.getChildren().addAll(vBox);
        
        
        }
        
        //Add button clicked
    public void addButtonClicked(){
        Product product = new Product();
        product.setSr_No(Sr_NoInput.getText());
        product.setBook_Name(Book_NameInput.getText());
        product.setAuthor(AuthorInput.getText());
        product.setIssue_Date(Issue_DateInput.getText());
        
        product.setCopies(Integer.parseInt(CopiesInput.getText()));
        table.getItems().add(product);
        Sr_NoInput.clear();
        Book_NameInput.clear();
        AuthorInput.clear();
        Issue_DateInput.clear();
        CopiesInput.clear();
    }

    //Delete button clicked
    public void deleteButtonClicked(){
        ObservableList<Product> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();

        productSelected.forEach(allProducts::remove);
    }

    //Get all of the products
    public ObservableList<Product> getProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("1", "Data Structure", "Ullman", "11/05/1994", 20));
              return products;
    }

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeTable();
    }    
    
}
