package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import MainPackage.Main;
import MainPackage.Menu;

public class MenuController {
    private Menu menuModel;
    public Stage window;

    public Button quizSelectButton;
    public Button rankingButton;
    public Button dictionaryButton;
    public Button exitButton;

    @FXML
    public void initialize(){
        this.menuModel = new Menu();
        this.window = Main.window;
    }

    public void quizSelect(ActionEvent actionEvent) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/QuizSelectView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void ranking(ActionEvent actionEvent) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/RankingView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void dictionary(ActionEvent actionEvent) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/CRUD/DictionaryView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void exit(ActionEvent actionEvent) throws Exception{
        System.exit(1);
    }

}