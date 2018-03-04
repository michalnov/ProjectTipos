package sk.akademiasovy.tipos.server.db;

import sk.akademiasovy.tipos.server.resources.NewUser;
import sk.akademiasovy.tipos.server.resources.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MySQL {
    private Connection conn;
    private String driver = "com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/tipos";
    private String dbusername="tiper1";
    private String dbpassword="reabc";

    public User getUser(String username, String password){
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, this.dbusername, this.dbpassword);

            String query = "SELECT * from users where login like ? and password like ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                 User user=new User(rs.getString("firstname"),rs.getString("lastname"),rs.getString("login"),rs.getString("email"),rs.getString("password"));
                 query = "UPDATE tokens SET token=? WHERE idu=?";
                ps = conn.prepareStatement(query);
                ps.setString(1, user.getToken());
                ps.setInt(2,rs.getInt("id"));
                ps.setInt(3,rs.getInt("login"));
                ps.executeUpdate();
                System.out.println(ps);
                conn.close();
                return user;
            }
            return null;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public User createNewUser(NewUser newUser){
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, this.dbusername, this.dbpassword);

            String query = "SELECT count(*) as num FROM users WHERE login like ? OR email like ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,newUser.getlogin());
            ps.setString(2,newUser.getEmail());
            ResultSet rs=ps.executeQuery();
            System.out.println(ps);

            rs.next();
            if(rs.getInt("num")==0)
            {
                registerNewUserIntoDb(new User(newUser.getFirstName(),newUser.getLastName(),newUser.getlogin(),newUser.getEmail(),newUser.getPassword()));
            }
            else
                return null;

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void registerNewUserIntoDb(User user) {
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, this.dbusername, this.dbpassword);
            String query = "INSERT INTO users(firstname, lastname, email, login, password) "+
                    " VALUES (?,?,?,?,?)";
            PreparedStatement ps= conn.prepareStatement(query);
            ps.setString(1,user.getFirstname());
            ps.setString(2,user.getLastname());
            ps.setString(3,user.getEmail());
            ps.setString(4,user.getLogin());
            ps.setString(5,user.getPasword());
            ps.executeUpdate();
            registerNewToken(user);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void registerNewToken(User user)
    {
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, this.dbusername, this.dbpassword);

            String query = "SELECT * from users where login like ? and password like ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPasword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                query = "INSERT into token (token, idu, login) values (?,?,?)";
                ps = conn.prepareStatement(query);
                ps.setString(1, user.getToken());
                ps.setInt(2, rs.getInt("id"));
                ps.setInt(3, rs.getInt("login"));
                ps.executeUpdate();
                conn.close();

            }
            else
            {
                return;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public Boolean controllToken(String login, String token)
    {

        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, this.dbusername, this.dbpassword);

            String query = "SELECT * from token where login like ? and token like ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,login);
            ps.setString(2,token);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
