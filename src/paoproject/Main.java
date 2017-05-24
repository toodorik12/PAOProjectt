
package paoproject;

import java.sql.SQLException;


public class Main {

    /**
     */
    
    public void Register()
    {
        
    }
    
    /**
     *
     */
    public void Login(){
        
    }
         
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // TODO code application logic here
        //Client newclient;
        //newclient = new Client ("user2","alex","popa","alex@gmail.com","parola2");
        Admin a = new Admin("admin","parola");
        a.SeeCategories();
    }
    
}
