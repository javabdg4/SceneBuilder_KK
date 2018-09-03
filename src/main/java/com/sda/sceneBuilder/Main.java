package com.sda.sceneBuilder;

import com.sda.sceneBuilder.controler.PersonController;
import com.sda.sceneBuilder.model.Person;
import com.sda.sceneBuilder.view.PersonView;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.IOException;
import java.util.Observable;
@Getter
public class Main extends Application {

    private VBox vBox;
    private Stage stage;
    private PersonView personView;

    public static void main(String[] args) {
        launch();
    }

    public void start(Stage primaryStage) throws Exception {
        this.stage=primaryStage;

        loadView();
    }

    public void loadView() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/RootView.fxml"));
        try {
            vBox = (VBox) loader.load();
            Scene scene= new Scene(vBox);
            stage.setScene(scene);
            stage.show();

            PersonController personController=loader.getController();
            PersonView personView=new PersonView();
            personController.setPersonView(personView);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
