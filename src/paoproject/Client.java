
package paoproject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
/**
 *
 * @author Stefanicus
 */



public class Client {
      String username;
      String firstname;
      String lastname;
      String email;
      String password;
      //static Integer usersnumber;
      //static int id = 0;
      String property;
      List<Book> cart;
      

      
      
      public Client(){
          
      }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Client(String username, String password){
        this.username = username;
        this.password = password;
    }

    public Client(String username, String firstname, String lastname, String email, String password, String property) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.property = property;
        
        //Client.usersnumber++;
        //odata ce e creat un client nou, va fi si pus in baza de date
        //connection to java
        SQLConnection s = new SQLConnection();
        try{
            Class.forName(s.getDriver()).newInstance();
            Connection conn = DriverManager.getConnection(s.getUrl()+s.getDbName(),s.getUsername(),s.getPassword());
            Statement st = conn.createStatement();
            int i = st.executeUpdate("INSERT into users VALUES('"+this.username+"','"+this.firstname+"','"+this.lastname+"','"+this.email+"','"+this.password+"','"+this.property+"')");
            if(i==1) System.out.println("Correctly added");
            conn.close();
        } catch (Exception e) {
		  e.printStackTrace();
		  }
    }
      
    
    
    public void SeeBooks()
    {
           Scanner sc;
           String bookname;
           String author;
           String category;
           float price;
           int pgnr ;
           sc = new Scanner(System.in);
        SQLConnection s = new SQLConnection();
        try{
            Class.forName(s.getDriver()).newInstance();
            Connection conn = DriverManager.getConnection(s.getUrl()+s.getDbName(),s.getUsername(),s.getPassword());
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM  books");
            while (res.next()) {
		 bookname = res.getString("bookname");
		  author = res.getString("autor");
		 category = res.getString("category");
                 pgnr = res.getInt("nrpg");
                 price = res.getFloat("pret");
                  //float price = res.getFloat("price");
		  System.out.println(bookname +" " + author + " " + category + " " + pgnr + " " + price );
            }
            conn.close();
        } catch (Exception e) {
		  e.printStackTrace();
		  }
        System.out.println("Enter the name of the book you want to purchase: ");
        String book2= sc.next();
        //SQLConnection s = new SQLConnection();
        try{
            Class.forName(s.getDriver()).newInstance();
            Connection conn = DriverManager.getConnection(s.getUrl()+s.getDbName(),s.getUsername(),s.getPassword());
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM  books WHERE lower(nume) = lower( "+book2+")");
            while (res.next()) {
		 bookname = res.getString("bookname");
		 author = res.getString("autor");
		 category = res.getString("category");
                 pgnr = res.getInt("nrpg");
                 price = res.getFloat("pret");
                  //float price = res.getFloat("price");
		// System.out.println(bookname +" " + author + " " + category + " " + pgnr + " " + price );
                if(bookname.equals(book2)){
                    System.out.println("Enter the quantity: ");
                    int q = sc.nextInt();
                    Book book = new Book(bookname, author, pgnr, price);
                    book.price = book.price*q;
                    AddToCart(book,q);
                    break;
                }
            }
            conn.close();
        } catch (Exception e) {
		  e.printStackTrace();
		  }
        
        
    }
    
    /**
     *
     * @param book
     */
    public void AddToCart(Book book, int quantity){
         int i;
        for(i=0;i<quantity;i++)
        {
            cart.add(book);
        }
    }
    
    public void SeeCart(){
        cart.stream().forEach((o) -> System.out.println(o));
    }
    
    public void Order(){
        
    }
    
    public void ClientMenu(){
        
    }
}
