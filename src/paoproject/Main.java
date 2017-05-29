
package paoproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Main {

    /**
     */
    
    public void Register() //doar pentru admin
    {
        
    }
    
    /**
     *
     */
    public void Login() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
           String username;
           String password;
           Scanner sc = new Scanner(System.in);
           System.out.println("Username: ");
           username = sc.next();
           System.out.println("Password: ");
           password = sc.next();
           SQLConnection s = new SQLConnection();
        try{
            Class.forName(s.getDriver()).newInstance();
            Connection conn = DriverManager.getConnection(s.getUrl()+s.getDbName(),s.getUsername(),s.getPassword());
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT username, password, property FROM  users");
            
            while (res.next()) {
                  String username2 = res.getString("username");
		  String password2 = res.getString("password");
                  String property = res.getString("property");
                  if(username.equals(username2) && password.equals(password2) && "user".equals(property))
                      break;
                  else if(username.equals(username2) && password.equals(password2) && "admin".equals(property))
                       break;
                  
                  
                }
                  String username2 = res.getString("username");
		  String password2 = res.getString("password");
                  String property = res.getString("property");
                if("user".equals(property))
                {
                     Client userr = new Client(username2, password2);
                     userr.ClientMenu();
                }
                if("admin".equals(property))
                {
                    Admin adminn = new Admin(username2, password2);
                    adminn.AdminMenu();
                }
            } catch (Exception e) {
                  System.out.println("Incorrect username or password!");
		  e.printStackTrace();
		  }   
            
            }

           
    
         
    public static void main(String[] args)  {
        // TODO code application logic here
        //Client newclient;
        //newclient = new Client ("user2","alex","popa","alex@gmail.com","parola2");
       /* SQLConnection s = new SQLConnection();
        try{
            Class.forName(s.getDriver()).newInstance();
            Connection conn = DriverManager.getConnection(s.getUrl()+s.getDbName(),s.getUsername(),s.getPassword());
            Statement st = conn.createStatement();
            int i = st.executeUpdate("SELECT from users VALUES('"+this.username+"','"+this.firstname+"','"+this.lastname+"','"+this.email+"','"+this.password+"')");
            if(i==1) System.out.println("Correctly added");
            conn.close();
        } catch (Exception e) {
		  e.printStackTrace();
		  }*/
            
}
}
