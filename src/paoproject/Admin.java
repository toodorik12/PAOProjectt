
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
           System.out.print("\b\b\b\b\b");
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
           String property = "user";
           Client newclient = new Client(userusername, firstname, lastname, email, userpassword,property);
       }
       
       public void AddCategory(){
           System.out.print("\b\b\b\b\b");
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
           System.out.print("\b\b\b\b\b");
           Scanner sc;
           String bookname;
           String author;
           String category;
           float price;
           int pgnr ;
           sc = new Scanner(System.in);
           System.out.println("Enter the book to be added: ");
           bookname = sc.nextLine();
           System.out.println("Enter the author of the book: ");
           author = sc.nextLine();
           System.out.println("Enter the price of the book: ");
           price = sc.nextFloat();
           System.out.println("Enter the number of pages: ");
           pgnr = sc.nextInt();
            System.out.println("Enter the category of the book: ");
           category = sc.next();
           Book newbook = new Book(bookname,author, pgnr, price);
           SQLConnection s = new SQLConnection();
        try{
            Class.forName(s.getDriver()).newInstance();
            Connection conn = DriverManager.getConnection(s.getUrl()+s.getDbName(),s.getUsername(),s.getPassword());
            Statement st = conn.createStatement();
            int i = st.executeUpdate("INSERT into books VALUES('"+bookname+"','"+author+"','"+pgnr+"','"+price+"','"+category+"')");
            if(i==1) System.out.println("Correctly added");
            conn.close();
        } catch (Exception e) {
		  e.printStackTrace();
		  }  
       }
       
       public void SeeCategories() {
           SQLConnection s = new SQLConnection();
        try{
            Class.forName(s.getDriver()).newInstance();
            Connection conn = DriverManager.getConnection(s.getUrl()+s.getDbName(),s.getUsername(),s.getPassword());
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM  categories");
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
       
       public int SeeOrders(){ 
           System.out.print("\b\b\b\b\b");
           SQLConnection s = new SQLConnection();
        try{
            Class.forName(s.getDriver()).newInstance();
            Connection conn = DriverManager.getConnection(s.getUrl()+s.getDbName(),s.getUsername(),s.getPassword());
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM  unprocessed_orders");
            
            while (res.next()) {
                  int nr = res.getInt("nr");
		  String user = res.getString("user");
		  String date = res.getString("date");
                  String book = res.getString("book");
                  int quantity = res.getInt("quantity");
                  float price = res.getFloat("price");
		  System.out.println(nr +". " + user + ": " + date + " " + "book" + " " + quantity + " " + price);
                  
            }
            //int i = st.executeUpdate("INSERT into books VALUES('"+bookname+"','"+author+"','"+pgnr+"','"+price+"')");
           // if(i==1) System.out.println("Correctly added");
            conn.close();
            System.out.println("1. Process an order. ");  
               System.out.println("2. Exit");
               Scanner sc = new Scanner(System.in);
               int i = sc.nextInt();
               if(i == 1)
                   process_order();
               else return 0;
        } catch (Exception e) {
		  e.printStackTrace();
		  }
        
           return -1;   
       }
       
      public void process_order() throws SQLException
      {
          System.out.print("\b\b\b\b\b");
            SQLConnection s = new SQLConnection();
        try{
            Class.forName(s.getDriver()).newInstance();
            Connection conn = DriverManager.getConnection(s.getUrl()+s.getDbName(),s.getUsername(),s.getPassword());
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM  unprocessed_orders");
            
            while (res.next()) {
                  int nr = res.getInt("nr");
		  String user = res.getString("user");
		  String date = res.getString("date");
                  String book = res.getString("book");
                  int quantity = res.getInt("quantity");
                  float price = res.getFloat("price");
             
		  System.out.println(nr +". " + user + ": " + date + " " + "book" + " " + quantity + " " + price);
                }
            System.out.println();
            System.out.println("Enter the order to be processed: ");
            Scanner sc = new Scanner(System.in);
            int nro = sc.nextInt();
            res.absolute(nro);   
            st.executeUpdate("INSERT INTO `orders_history`(`nr`, `user`, `date`, `book`, `quantity`, `price`) VALUES ('"+res.getInt("nr")+"','"+res.getString("user")+"','"+res.getString("date")+"','"+res.getString("book")+"','"+res.getInt("quantity")+"','"+res.getString("price")+"')  ");
            st.executeUpdate("DELETE FROM unprocessed_orders WHERE nr = '"+res.getInt("nr")+"'   ");
            conn.close();
            
                
            } catch (Exception e) {
		  e.printStackTrace();
            }  
           
      }
       
       public void SeeHistory(){
           System.out.print("\b\b\b\b\b");
           SQLConnection s = new SQLConnection();
        try{
            Class.forName(s.getDriver()).newInstance();
            Connection conn = DriverManager.getConnection(s.getUrl()+s.getDbName(),s.getUsername(),s.getPassword());
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM  unprocessed_orders");
            
            while (res.next()) {
                 int nr = res.getInt("nr");
		  String user = res.getString("user");
		  String date = res.getString("date");
                  String book = res.getString("book");
                  int quantity = res.getInt("quantity");
                  float price = res.getFloat("price");
		  System.out.print(nr +". " + user + ": " + date + " " + "book" + " " + quantity + " " + price);
                  
            }
            //int i = st.executeUpdate("INSERT into books VALUES('"+bookname+"','"+author+"','"+pgnr+"','"+price+"')");
           // if(i==1) System.out.println("Correctly added");
            conn.close();
            }catch (Exception e) {
		  e.printStackTrace();
		  }
       
       } 
       
       
       public void AdminMenu()
       {
           //CreateUser();
           //AddCategory();
           //AddBook();
          //SeeCategories();
           SeeOrders();
           SeeHistory();
           
       }
}
