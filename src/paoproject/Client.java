
package paoproject;
import java.sql.*;
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
      static Integer usersnumber;
      

      
      
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

    public Client(String username, String firstname, String lastname, String email, String password) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        //Client.usersnumber++;
        //odata ce e creat un client nou, va fi si pus in baza de date
        //connection to java
        SQLConnection s = new SQLConnection();
        try{
            Class.forName(s.getDriver()).newInstance();
            Connection conn = DriverManager.getConnection(s.getUrl()+s.getDbName(),s.getUsername(),s.getPassword());
            Statement st = conn.createStatement();
            int i = st.executeUpdate("INSERT into users VALUES('"+this.username+"','"+this.firstname+"','"+this.lastname+"','"+this.email+"','"+this.password+"')");
            if(i==1) System.out.println("Correctly added");
            conn.close();
        } catch (Exception e) {
		  e.printStackTrace();
		  }
    }
      
    
    public void AddToCart(String bookname){
        
    }
    
    public void SeeCart(){
        
    }
    
    public void Order(){
        
    }
}
