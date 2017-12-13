package lab_7;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class DataController implements Initializable {
    private String isbn,author,title,year,input;
    DataBase data = new DataBase();
    ArrayList<String> result=new ArrayList<String>();
    ArrayList<String> result2=new ArrayList<String>();

    @FXML
    private Button browseButton;

    @FXML
    private Button browseButton2;

    @FXML
    private Button addButton;
    @FXML
    private Button showButton;
    @FXML
    private TextField inputText;

    @FXML
    private ListView<String> list;


    @FXML
    public void browseISBN() {
        list.getItems().clear();
        //result=data.findbyISBN(isbn);
        isbn=inputText.getText();
        System.out.println("isbn"+isbn);
        result=data.findbyISBN(isbn);
        System.out.println("result"+ result);
        for (String in: result){
            list.getItems().addAll(in);
        }

    }
    @FXML
    public void browseAuthor() {
        list.getItems().clear();
        author=inputText.getText();
        result2=data.findbyauthor(author);
        System.out.println("autor"+ author);
        System.out.println("result"+ result2);
        for (String ii: result2){
            list.getItems().addAll(ii);
        }

    }

    @FXML
    public void show(){
        list.getItems().clear();
        for (String in: data.listNames()){
            list.getItems().addAll(in);
        }
    }
    @FXML
    public void add(){
        list.getItems().clear();
        input=inputText.getText();
        String[] MyStrings = input.split(",");
        isbn=MyStrings[0];
        title=MyStrings[1];
        author=MyStrings[2];
        year=MyStrings[3];
        System.out.println(isbn+title+author+year);
        data.addBook(isbn,title,author,year);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("View is now loaded!");

        showButton.setOnAction(e-> show());
        browseButton.setOnAction(e-> browseISBN());
        browseButton2.setOnAction(e-> browseAuthor());
        addButton.setOnAction(e-> add());

    }
}
