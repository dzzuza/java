package lab_7;
import lab_04.zad_2_3.*;
import lab_01.pesel.Pesel;
import java.sql.*;

public class EmploymentBase {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn =
                    DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/dziezuza",
                            "dziezuza", "XZNXtBadLXdePsLm");
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (Exception e)

        {
            e.printStackTrace();
        }
    }

    public void createTable() throws SQLException {
        connect();
        stmt = conn.createStatement();
        stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS Pracownicy ("
                        + "pesel VARCHAR(11) NOT NULL, "
                        + "brutto DOUBLE, PRIMARY KEY (pesel))");
    }


    public void addBook(Pesel pesel, double brutto){
        String sql="";
        try {
            connect();
            stmt = conn.createStatement();
            sql = "INSERT INTO books (isbn, title, author, year) VALUES('"+ pesel.getPesel()+"','"+brutto+"')";
            System.out.println(sql);
            stmt.executeUpdate(sql);
        }catch(
                SQLException ex)
        {
        }finally
        {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                } // ignore
                stmt = null;
            }
        }
    }

    public static void main(String[] args) {
        EmploymentBase managment=new EmploymentBase();
        try {
            managment.createTable();}
        catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }
}
