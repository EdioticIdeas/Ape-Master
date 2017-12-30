/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

/**
 *
 * @author Mukul
 */
public class Product {

    private String Sr_No;
    private String Book_Name;
    private String Author;
    private String Issue_Date;
    private Integer Copies;

    public Product(){
        this.Sr_No = "";
        this.Book_Name = "";
        this.Author = "";
        this.Issue_Date = "";
        this.Copies = 0;
        
    }

    public Product(String Sr_No, String Book_Name, String Author, String Issue_Date, int Copies){
        
       this.Sr_No = Sr_No;
        this.Book_Name = Book_Name;
        this.Author = Author;
        this.Issue_Date = Issue_Date;
        this.Copies = Copies;
        
        
        
        

    }

    public String getSr_No() {
        return Sr_No;
    }

    public void setSr_No(String Sr_No) {
        this.Sr_No = Sr_No;
    }

    public String getBook_Name() {
        return Book_Name;
    }

    public void setBook_Name(String Book_Name) {
        this.Book_Name = Book_Name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getIssue_Date() {
        return Issue_Date;
    }

    public void setIssue_Date(String Issue_Date) {
        this.Issue_Date = Issue_Date;
    }

    public Integer getCopies() {
        return Copies;
    }

    public void setCopies(Integer Copies) {
        this.Copies = Copies;
    }
    
 }