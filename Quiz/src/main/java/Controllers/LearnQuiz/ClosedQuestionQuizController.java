package Controllers.LearnQuiz;

import MainPackage.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.*;

import static Controllers.CRUD.DictionaryController.dictionary;

public class ClosedQuestionQuizController {
    public Stage window;

    public Button returnButton;
    public Button nextButton;
    @FXML
    public Button buttonA, buttonB, buttonC, buttonD;
    public Label respondLabel;
    public Text questionText;

    private String question;
    private Set<String> answerSet = new HashSet<>();

    @FXML
    public void initialize() {
        this.window = Main.window;
        question = getRandomQuestion();
        questionText.setText(question);

        answerSet.add(dictionary.get(question));
        for(int i=1; i<4; i++) {
            String answer = getRandomAnswer();
            while (!answerSet.add(answer)) answer = getRandomAnswer();
        }
        String[] myArray = new String[answerSet.size()];
        answerSet.toArray(myArray);

        int item = new Random().nextInt(4);
        switch (item){
            case 0:
                buttonA.setText(myArray[0]);
                buttonB.setText(myArray[1]);
                buttonC.setText(myArray[2]);
                buttonD.setText(myArray[3]);
                break;
            case 1:
                buttonA.setText(myArray[1]);
                buttonB.setText(myArray[0]);
                buttonC.setText(myArray[2]);
                buttonD.setText(myArray[3]);
                break;
            case 2:
                buttonA.setText(myArray[1]);
                buttonB.setText(myArray[2]);
                buttonC.setText(myArray[0]);
                buttonD.setText(myArray[3]);
                break;
            case 3:
                buttonA.setText(myArray[1]);
                buttonB.setText(myArray[2]);
                buttonC.setText(myArray[3]);
                buttonD.setText(myArray[0]);
                break;
        }
    }

    private String getRandomQuestion() {
        Set<String> map = dictionary.keySet();
        int size = map.size();
        int item = new Random().nextInt(size);
        int i=0;
        for(String string : map){
            if(i == item) return string;
            i++;
        }
        return null;
    }

    private String getRandomAnswer() {
        Collection<String> map = dictionary.values();
        int size = map.size();
        int item = new Random().nextInt(size);
        int i=0;
        for(String string : map){
            if(i == item) return string;
            i++;
        }
        return null;
    }

    public void next(ActionEvent actionEvent) throws Exception {
        int type = new Random().nextInt(2);
        if(type == 0) {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/LearnQuiz/ClosedQuestionQuizView.fxml"));
            window.setScene(new Scene(root));
            window.show();
        }else if(type == 1){
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/LearnQuiz/OpenedQuestionQuizView.fxml"));
            window.setScene(new Scene(root));
            window.show();
        }
    }

    public void checkA(ActionEvent actionEvent){
        if(buttonA.getText().equals(dictionary.get(question))){
            respondLabel.setText("Dobrze!");
        } else respondLabel.setText("Źle!");
    }

    public void checkB(ActionEvent actionEvent){
        if(buttonB.getText().equals(dictionary.get(question))){
            respondLabel.setText("Dobrze!");
        } else respondLabel.setText("Źle!");
    }

    public void checkC(ActionEvent actionEvent){
        if(buttonC.getText().equals(dictionary.get(question))){
            respondLabel.setText("Dobrze!");
        } else respondLabel.setText("Źle!");
    }

    public void checkD(ActionEvent actionEvent){
        if(buttonD.getText().equals(dictionary.get(question))){
            respondLabel.setText("Dobrze!");
        } else respondLabel.setText("Źle!");
    }

    public void back(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/QuizSelectView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }
}
