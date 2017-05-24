
package paoproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Admin {

       String username;
       String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }
       
       
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
           SQLConnection s = new SQLConnection();
            try{
                Class.forName(s.getDriver()).newInstance();
                Connection conn = DriverManager.getConnection(s.getUrl()+s.getDbName(),s.getUsername(),s.getPassword());
                Statement st = conn.createStatement();
                int i = st.executeUpdate("INSERT into categories VALUES('"+category+"')");
                if(i==1) System.out.println("Correctly added");
                 conn.close();
                } catch (Exception e) {
		  e.printStackTrace();
		  }
           
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
           SQLConnection s = new SQLConnection();
        try{
            Class.forName(s.getDriver()).newInstance();
            Connection conn = DriverManager.getConnection(s.getUrl()+s.getDbName(),s.getUsername(),s.getPassword());
            Statement st = conn.createStatement();
            int i = st.executeUpdate("INSERT into books VALUES('"+bookname+"','"+author+"','"+pgnr+"','"+price+"')");
            if(i==1) System.out.println("Correctly added");
            conn.close();
        } catch (Exception e) {
		  e.printStackTrace();
		  }  
       }
       
       public void SeeCategories() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
           SQLConnection s = new SQLConnection();
        try{
            Class.forName(s.getDriver()).newInstance();
            Connection conn = DriverManager.getConnection(s.getUrl()+s.getDbName(),s.getUsername(),s.getPassword());
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM  users");
            while (res.next()) {
		  String category = res.getString("category_name");
		  
		  System.out.print(category + " ");
            }
            //int i = st.executeUpdate("INSERT into books VALUES('"+bookname+"','"+author+"','"+pgnr+"','"+price+"')");
           // if(i==1) System.out.println("Correctly added");
            conn.close();
        } catch (Exception e) {
		  e.printStackTrace();
		  }
       }
       
       public void SeeOrders(){  
           
       }
       
       public void SeeHistory(){
           
       }
       
       
}
