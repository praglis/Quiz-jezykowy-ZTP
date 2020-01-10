package controller.test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.Main;
import model.Dictionary;
import model.Level;
import model.question.OpenedQuestion;
import model.quiz.TestQuiz;

import java.util.HashSet;
import java.util.Set;

public class TestQuizLevelSelectController {
    public Stage window;
    private String selectedLevel;
    private Dictionary dictionary;

    //todo: Przerobić ze statycznych na zwykłe prywantne! Dr Bołdak byłby zawiedziony, gdyby to zobaczył...
    static int count, score;
    static Set<String> questionsSet;

    @FXML
    public void initialize() {
        this.window = Main.window;
        count = 0;
        score = 0;
        questionsSet = new HashSet<>();
        selectedLevel = null;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void startTestQuiz(ActionEvent actionEvent) throws Exception {
        this.selectedLevel = ((Button) actionEvent.getSource()).getText();
        this.dictionary = new Dictionary(new Level(this.selectedLevel));

        TestQuiz testQuiz = new TestQuiz(dictionary);
        if (testQuiz.getQuestion() instanceof OpenedQuestion) {
            new OpenedQuestionQuizController(testQuiz);
        } else {
            new ClosedQuestionQuizController(testQuiz);
        }
    }

    public void back() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/QuizSelectView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }
}