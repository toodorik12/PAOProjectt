/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paoproject;

import java.util.Scanner;

/**
 *
 * @author Stefanicus
 */
public class Admin {

       String username;
       String password;
       
       public void CreateUser(){
           
       }
       
       public void AddCategory(){
           Scanner sc;
           String category;
           sc = new Scanner(System.in);
           System.out.println("Enter the category to be added: ");
           category = sc.next();
           
       }
       
       public void AddBook(){
           Scanner sc;
           String bookname;
           String author;
           float price;
           int pgnumber ;
           sc = new Scanner(System.in);
           System.out.println("Enter the book to be added: ");
           bookname = sc.next();
           System.out.println("Enter the author of the book: ");
           author = sc.next();
           System.out.println("Enter the price of the book: ");
           price = sc.nextFloat();
           System.out.println("Enter the number of pages: ");
           pgnumber = sc.nextInt();
           
       }
       
       public void SeeCategories(){
           
       }
       
       public void SeeOrders(){
           
       }
       
       public void SeeHistory(){
           
       }
       
       
}
