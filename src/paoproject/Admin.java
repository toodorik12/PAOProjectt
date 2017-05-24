
package paoproject;
import java.util.Scanner;


public class Admin {

       String username;
       String password;
       
       public void CreateUser(){
           Scanner sc;
           sc= new Scanner(System.in);
           System.out.println("Username: ");
           String userusername;
           userusername = sc.next();
           System.out.println("Password: ");
           String userpassword;
           userpassword = sc.next();
           System.out.println("First Name: ");
           String firstname = sc.next();
           System.out.println("Last name: ");
           String lastname = sc.next();
           System.out.println("Email: ");
           String email = sc.next();
           Client newclient = new Client(userusername, firstname, lastname, email, userpassword);
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
           int pgnr ;
           sc = new Scanner(System.in);
           System.out.println("Enter the book to be added: ");
           bookname = sc.next();
           System.out.println("Enter the author of the book: ");
           author = sc.next();
           System.out.println("Enter the price of the book: ");
           price = sc.nextFloat();
           System.out.println("Enter the number of pages: ");
           pgnr = sc.nextInt();
           Book newbook = new Book(bookname,author, pgnr, price);
           
       }
       
       public void SeeCategories(){  //ia din baza de date si pune intr-o lista pentru afisare
           
       }
       
       public void SeeOrders(){  
           
       }
       
       public void SeeHistory(){
           
       }
       
       
}
