package lab_7;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataBase {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    int flag=1;
    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn =
                    DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/dziezuza",
                            "dziezuza", "XZNXtBadLXdePsLm");
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());

            if(flag<4){
                System.out.println("nieudana proba nr"+flag);
                flag++;
                connect();}

            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (Exception e)

        {
            e.printStackTrace();
        }
    }
    public ArrayList<String> listNames() {
        ArrayList<String> list=new ArrayList<String>();
        String isbn;
        String title;
        String author;
        String year;
        try {
            connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM books");
            while (rs.next()) {
                isbn = rs.getString(1);
                title = rs.getString(2);
                author = rs.getString(3);
                year = rs.getString(4);
                System.out.println("ISBN " + isbn + ",   TITLE " + title + ",   AUTHOR " + author + ",   YEAR " + year);
                list.add("ISBN " + isbn + ",   TITLE " + title + ",   AUTHOR " + author + ",   YEAR " + year);
            }
    }catch(
    SQLException ex)
    {
        // handle any errors
    }finally
    {
        // zwalniamy zasoby, które nie będą potrzebne
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
return list;
}


    public ArrayList<String> findbyISBN(String findisbn){
        ArrayList<String> list=new ArrayList<String>();
        try {
            connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM books WHERE isbn=" + findisbn);
            while (rs.next()) {
                String isbn = rs.getString(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String year = rs.getString(4);
                System.out.println("ISBN " + isbn + ",   TITLE " + title + ",   AUTHOR " + author + ",   YEAR " + year);
                list.add("ISBN " + isbn + ",   TITLE " + title + ",   AUTHOR " + author + ",   YEAR " + year);
            }
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
        return list;
    }

    public ArrayList<String> findbyauthor(String findauthor){
        ArrayList<String> list =new ArrayList<String>();
        try {
            connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM books WHERE author LIKE '% "+findauthor+"'");
            while (rs.next()) {
                String isbn = rs.getString(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String year = rs.getString(4);
                System.out.println("ISBN " + isbn + ",   TITLE " + title + ",   AUTHOR " + author + ",   YEAR " + year);
                list.add("ISBN " + isbn + ",   TITLE " + title + ",   AUTHOR " + author + ",   YEAR " + year);
            }
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
        return list;
    }
    public void addBook(String newisbn, String newtitle, String newauthor, String newyear){
        String sql="";
/*        Scanner input = new Scanner(System.in);
        String newisbn = input.nextLine();
        String newtitle = input.nextLine();
        String newauthor = input.nextLine();
        int newyear = input.nextInt();*/
        try {
            connect();
   /*         input = new Scanner(System.in);
            newisbn = input.nextLine();
            newtitle = input.nextLine();
            newauthor = input.nextLine();
            newyear = input.nextInt();*/
            stmt = conn.createStatement();
            sql = "INSERT INTO books (isbn, title, author, year) VALUES('"+ newisbn + "','" + newtitle + "','" + newauthor + "','" + newyear + "')";
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

}

