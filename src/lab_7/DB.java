package lab_7;
import java.sql.*;
import java.util.Scanner;

public class DB {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
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
        System.out.println("Menu");
        System.out.println("1.Wyszukaj po ISBN");
        System.out.println("2.Wyszukaj po autorze");
        System.out.println("3.Dodaj książkę");
        System.out.println("4.Pokaż listę pozycji");
        System.out.println("5.Zakończ");
        Scanner in = new Scanner(System.in);
        int option = in.nextInt();
        boolean ll = true;
        while (option != 0 && ll == true) {
            try {
                Scanner input = new Scanner(System.in);
                switch (option) {
                    case 1:
                        System.out.println("1");
                        String findisbn = input.next();
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery("SELECT * FROM books WHERE isbn=" + findisbn);
                        while (rs.next()) {
                            String isbn = rs.getString(1);
                            String title = rs.getString(2);
                            String author = rs.getString(3);
                            String year = rs.getString(4);
                            System.out.println("ISBN " + isbn + ",   TITLE " + title + ",   AUTHOR " + author + ",   YEAR " + year);
                        }
                        break;
                    case 2:
                        System.out.println("2");
                        String findauthor = input.nextLine();
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery("SELECT * FROM books WHERE author LIKE '% "+findauthor+"'");
                        while (rs.next()) {
                            String isbn = rs.getString(1);
                            String title = rs.getString(2);
                            String author = rs.getString(3);
                            String year = rs.getString(4);
                            System.out.println("ISBN " + isbn + ",   TITLE " + title + ",   AUTHOR " + author + ",   YEAR " + year);
                        }
                        break;
                    case 3:
                        System.out.println("3");
                        String newisbn = input.nextLine();
                        String newtitle = input.nextLine();
                        String newauthor = input.nextLine();
                        int newyear = input.nextInt();
                        stmt = conn.createStatement();
                        String sql = "INSERT INTO books (isbn, title, author, year) VALUES('"+ newisbn + "','" + newtitle + "','" + newauthor + "','" + newyear + "')";
                        System.out.println(sql);
//                        String sql1 = "INSERT INTO books (isbn, title, author, year) VALUES ('1234567899999','Bajki robotow', 'Stanislaw Lem',2008)";
//                        System.out.println(sql1);

                        stmt.executeUpdate(sql);
                        break;
                    case 4:
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery("SELECT * FROM books");
                        while (rs.next()) {
                            String isbn = rs.getString(1);
                            String title = rs.getString(2);
                            String author = rs.getString(3);
                            String year = rs.getString(4);
                            System.out.println("ISBN " + isbn + ",   TITLE " + title + ",   AUTHOR " + author + ",   YEAR " + year);
                        }
                        break;
                    case 5:
                        System.out.println("The End");
                        ll = false;
                        break;
                    default:
                        System.out.println("bledny wybor");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
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
            //break;
            if (ll == true) {
                System.out.println("Menu");
                option = in.nextInt();
            }
        }
    }
}