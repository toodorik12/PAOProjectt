/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paoproject;

/**
 *
 * @author Stefanicus
 */
public class Book {
    String name;
    String author;
    int pgnr;
    float price;
    int quantity = 0;
    //static int nrb = 0;

    public Book(String name, String author, int pgnr, float price) {
        this.name = name;
        this.author = author;
        this.pgnr = pgnr;
        this.price = price;
       // nrb++;
    }
    
    public Book(String name, String author, int pgnr, float price, int quantity) {
        this.name = name;
        this.author = author;
        this.pgnr = pgnr;
        this.price = price * quantity;
        this.quantity = quantity;
        
       // nrb++;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPgnr() {
        return pgnr;
    }

    public float getPrice() {
        return price;
    }
    
    
}
