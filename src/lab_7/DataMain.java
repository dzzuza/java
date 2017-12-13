package lab_7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Scanner;

public class DataMain extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/lab_7/DataSample.fxml"));
        primaryStage.setTitle("biblioteka");
        //StackPane pane = new StackPane();
        Scene scene = new Scene(root, 600, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
/*        DataBase data = new DataBase();
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
            Scanner input = new Scanner(System.in);
            switch (option) {
                case 1:
                    String findisbn = input.next();
                    data.findbyISBN(findisbn);
                    break;
                case 2:
                    String findauthor = input.next();
                    data.findbyauthor(findauthor);
                    break;
                case 3:
                    data.addBook();
                    break;
                case 4:
                    data.listNames();
                    break;
                case 5:
                    System.out.println("ThDe End");
                    ll = false;
                    break;
                default:
                    System.out.println("bledny wybor");
            }
        }
    }*/
    }
}
