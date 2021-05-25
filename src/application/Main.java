package application;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Registration");
        stage.setWidth(800);
        stage.setHeight(600);
        stage.setScene(slot(stage));
        stage.show();
    }

    public Scene slot(Stage stage){

        Label label = new Label();
        label. setText("Welcome\n Do you wish to register?\n Tap on any choice");

        Button choice1 = new Button("Register"); choice1.setPrefWidth(stage.getWidth() / 4);
        choice1.setOnAction(actionEvent -> {
            stage.close();
            stage.setScene(infoScene(stage));
            stage.show();
        });

        Button choice2 = new Button("Cancel"); choice2.setPrefWidth(stage.getWidth() / 4);
        choice2.setOnAction(actionEvent -> {
            stage.close();
        });

        HBox costPane = new HBox(choice1, choice2);
        costPane.setSpacing(15);
        costPane.setAlignment(Pos.CENTER);

        VBox hardpane = new VBox(label, costPane);
        hardpane.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(hardpane);

        return new Scene(borderPane);
    }

    public Scene infoScene(Stage stage){

        Label lbl = new Label("Please fill in this information.");

        Label lbl0 = new Label("Full Name:");
        TextField input = new TextField(); input.setPrefWidth(stage.getWidth() / 4);
        input.setPromptText("enter full name");
        HBox hbox = new HBox(lbl0, input); hbox.setSpacing(15);
        hbox.setAlignment(Pos.CENTER);

        Label lbl1 = new Label("Date of birth:");
        TextField input0 = new TextField(); input0.setPrefWidth(stage.getWidth() / 4);
        input0.setPromptText("enter date of birth");
        HBox hbox0 = new HBox(lbl1, input0); hbox0.setSpacing(15);
        hbox0.setAlignment(Pos.CENTER);

        Label lbl2 = new Label("Place of Birth:");
        TextField input1 = new TextField(); input1.setPrefWidth(stage.getWidth() / 4);
        input1.setPromptText("enter place of birth");
        HBox hbox1 = new HBox(lbl2, input1); hbox1.setSpacing(15);
        hbox1.setAlignment(Pos.CENTER);

        Label lbl3 = new Label("Email Address:");
        TextField input2 = new TextField(); input2.setPrefWidth(stage.getWidth() / 4);
        input2.setPromptText("enter Google email address");
        HBox hbox2 = new HBox(lbl3, input2); hbox2.setSpacing(15);
        hbox2.setAlignment(Pos.CENTER);

        Label lbl4 = new Label("Year of Study:");
        TextField input3 = new TextField(); input3.setPrefWidth(stage.getWidth() / 4);
        input3.setPromptText("enter year of study");
        HBox hbox3 = new HBox(lbl4, input3); hbox3.setSpacing(15);
        hbox3.setAlignment(Pos.CENTER);

        Label lbl5 = new Label("Department:");
        TextField input4 = new TextField(); input4.setPrefWidth(stage.getWidth() / 4);
        input4.setPromptText("enter department");
        HBox hbox4 = new HBox(lbl5, input4); hbox4.setSpacing(15);
        hbox4.setAlignment(Pos.CENTER);

        Button btn1 = new Button("Back"); btn1.setPrefWidth(stage.getWidth() / 10);
        btn1.setOnAction(actionEvent -> {
            stage.close();
            stage.setScene(slot(stage));
            stage.show();
        });

        TextField[] allInput = {input, input0, input1, input2, input3, input4};

        Button btn2 = new Button("Next"); btn2.setPrefWidth(stage.getWidth() / 10);
        btn2.setOnAction(actionEvent -> {
            String errorMessage = "";
            for(TextField eachInput : allInput){
                if(eachInput.getText().length() == 0){
                    errorMessage += "";
                }
                else{
                    stage.close();
                    stage.setScene(finalStage(stage));
                    stage.show();
                }
            }
        });


        Button btn3 = new Button("Cancel"); btn3.setPrefWidth(stage.getWidth() / 10);
        btn3.setOnAction(actionEvent -> {
            stage.close();
        });

        HBox choicePane = new HBox(btn1, btn2, btn3);
        choicePane.setSpacing(10);
        choicePane.setAlignment(Pos.CENTER);

        VBox corePane = new VBox();
        corePane.getChildren().addAll(lbl, hbox, hbox0, hbox1, hbox2, hbox3, hbox4, choicePane);
        corePane.setSpacing(10);
        corePane.setAlignment(Pos.CENTER);

        return new Scene(corePane);
    }

    public Scene finalStage(Stage stage){

        Label message = new Label();
        message.setText("Successfully Registered!!!\n Thank you!!!");

        Button button = new Button("Exit"); button.setPrefWidth(stage.getWidth() / 4);
        button.setOnAction(actionEvent -> {
            stage.close();
        });

        VBox clubPane = new VBox(message, button);
        clubPane.setSpacing(10);
        clubPane.setAlignment(Pos.CENTER);

        BorderPane dashPane = new BorderPane();
        dashPane.setCenter(clubPane);

        return new Scene(dashPane);
    }
}