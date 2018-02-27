package pl.edu.agh.project.drill.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OptionWindowController implements Initializable {

    private boolean shuffleAnswer;
    private boolean shuffleQuestions;
    private boolean replayQuestions;
    private int counterOptions; // 0 - normalnie, 1 - odejmowanie  pkt, 2 - odejmowanie części
    private ToggleGroup group = new ToggleGroup();

    @FXML
    public Button okButton, statButton, pointChooserButton;

    @FXML
    public CheckBox shuffleAnswersCheckbox, shuffleQuestionsCheckbox, replayQuestionsCheckbox;

    @FXML
    public HBox pointBox;

    @FXML
    public RadioButton subPoints,partPoints;

    public boolean isShuffleQ() {
        return shuffleQuestions;
    }

    public boolean isShuffleA() {
        return shuffleAnswer;
    }

    public boolean isReplayQ() {
        return replayQuestions;
    }

    public int getCounterOptions() {
        return counterOptions;
    }

    public OptionWindowController(){
        this.shuffleQuestions = false;
        this.shuffleAnswer = false;
        this.replayQuestions = false;
        this.counterOptions = 0;
    }

    @FXML
    public void handleOkButtonAction(ActionEvent actionEvent) {
        if(shuffleAnswersCheckbox.isSelected()) shuffleAnswer = true;
        if(shuffleQuestionsCheckbox.isSelected()) shuffleQuestions = true;
        if(replayQuestionsCheckbox.isSelected()) replayQuestions = true;
        if(subPoints.isSelected()) counterOptions = 1;
        else if(partPoints.isSelected()) counterOptions = 2;

        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void handleStatAction(ActionEvent event) throws IOException {
        FXMLLoader floader = new FXMLLoader();
        floader.setLocation(getClass().getResource("/logsWindow.fxml"));
        Parent p = floader.load();
        LogWindowController controller = floader.getController();
        Scene scene = new Scene(p);
        Stage mainStage = new Stage();
        mainStage.setScene(scene);
        mainStage.setTitle("Statystyki");
        mainStage.show();
    }

    @FXML
    public void handlePointChooserAction(ActionEvent event){
        pointBox.getChildren().clear();
        pointChooserButton.setVisible(false);
        subPoints.setToggleGroup(group);
        partPoints.setToggleGroup(group);
        pointBox.getChildren().addAll(partPoints);
        pointBox.getChildren().addAll(subPoints);
        pointBox.setVisible(true);
        subPoints.setVisible(true);
        partPoints.setVisible(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {}
}
