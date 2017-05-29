
package paoproject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
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
        //this.cart = new ArrayList<Book>;
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
         System.out.print("\b\b\b\b\b");
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
		 bookname = res.getString("nume");
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
            ResultSet res = st.executeQuery("SELECT * FROM  books WHERE lower(nume) = lower( '"+book2+"')");
            while (res.next()) {
		 bookname = res.getString("nume");
		 author = res.getString("autor");
		 category = res.getString("category");
                 pgnr = res.getInt("nrpg");
                 price = res.getFloat("pret");
                  //float price = res.getFloat("price");
		// System.out.println(bookname +" " + author + " " + category + " " + pgnr + " " + price );
                if(bookname.equals(book2)){
                    System.out.println("Enter the quantity: ");
                    int q = sc.nextInt();
                    Book book = new Book(bookname, author, pgnr, price, q);
                    AddToCart(book);
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
    public void AddToCart(Book book){
       cart = new ArrayList<>();
       cart.add(book);
    }
    
    public void SeeCart(){
        cart.stream().forEach((o) -> System.out.println(o.name + " "+ o.author + " " + o.price + " " + o.quantity));
        System.out.println("1.Order");
        System.out.println("2.Return");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        if (i == 1) Order();
        else if(i==2){}
        else System.out.println("Comanda incorecta");
        
    }
    
    public void Order(){
        SQLConnection s = new SQLConnection();
        try{
            Class.forName(s.getDriver()).newInstance();
            Connection conn = DriverManager.getConnection(s.getUrl()+s.getDbName(),s.getUsername(),s.getPassword());
            Statement st = conn.createStatement();
            for( int j = 0; j< cart.size();j++)
            {
                  Random rand = new Random();
                  int x = rand.nextInt(200 - 1 + 1) + 1;
                  int i = 0;
                  i = st.executeUpdate("INSERT into unprocessed_orders VALUES("+x+",'"+this.username+"',CURRENT_TIMESTAMP,'"+cart.get(i).getName()+"',"+cart.get(i).getQuantity()+","+cart.get(i).getPrice()+")");
                  if(i==1) System.out.println("Correctly placed order.");
            }
            conn.close();
        } catch (Exception e) {
		  e.printStackTrace();
		  }  
    }
    
    public void ClientMenu(){
        SeeBooks();
        SeeCart();
    }
}
