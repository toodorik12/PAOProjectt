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
public class SQLConnection {
    String url;
    String dbName;
    String driver;
    String username;
    String password;

    public String getUrl() {
        return url;
    }

    public String getDbName() {
        return dbName;
    }

    public String getDriver() {
        return driver;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    

    public SQLConnection() {
        url = "jdbc:mysql://localhost:3306/";
        dbName = "bookstore_users";
        driver = "com.mysql.jdbc.Driver";
        username = "root"; 
        password = "1234";
    }
    
    
}
