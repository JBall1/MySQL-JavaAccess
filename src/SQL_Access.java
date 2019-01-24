import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQL_Access {

private Connection con;
private Statement st;
private ResultSet rs;

private String username = "root";
private String password = "josh";

public SQL_Access(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/Diseases",username,password);
        st = con.createStatement();
    }
    catch (Exception e){
        System.out.println("Error: " + e);
    }
}

public void getData(){

    try{
        String query = "select * from a";
        rs = st.executeQuery(query);
        System.out.println("Info:");
        while(rs.next()){
            String id = rs.getString("id");
            String name = rs.getString("title");

            System.out.println(name);

        }

    }
    catch (Exception e){
        System.out.println("Error: " + e);
    }
}

}
