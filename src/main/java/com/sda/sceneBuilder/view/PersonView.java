package com.sda.sceneBuilder.view;

import com.sda.sceneBuilder.Main;
import com.sda.sceneBuilder.controler.NewPersonController;
import com.sda.sceneBuilder.controler.PersonController;
import com.sda.sceneBuilder.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.IOException;

@Getter
public class PersonView {
    private ObservableList<Person> personList = FXCollections.observableArrayList();
    private VBox vBox;
    private Stage stage;
    private boolean flag;
public int index;
    public PersonView() {

    }

    public PersonView(Stage stage) {
        this.stage = stage;
        personList.add(new Person("jan", "kowalski", "kwiatowa", "Miasto", "11111", "444444444444"));
        personList.add(new Person("Adam", "Iksinski", "Uliczna", "Metropolia", "33333", "7777777777"));
        personList.add(new Person("Marek", "Przykładowski", "Uliczyńska", "Miejscowość", "8888", "77776555555"));

    }


    public void loadNewPerson() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/NewpPerson.fxml"));
        VBox newPersonView = null;
        try {
            newPersonView = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage newPersonStage = new Stage();
        Scene newPersonScene = new Scene(newPersonView);
        newPersonStage.setScene(newPersonScene);
        newPersonStage.show();


        NewPersonController newPersonController = loader.getController();
        newPersonController.setStage(newPersonStage);
        newPersonController.setPersonView(this);
        newPersonController.setFlag(false);
    }

    public void loadEditPerson(Person person,int index) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/NewpPerson.fxml"));
        VBox newPersonView = null;
        try {

            newPersonView = loader.load();


        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage newPersonStage = new Stage();
        Scene newPersonScene = new Scene(newPersonView);
        newPersonStage.setScene(newPersonScene);
        newPersonStage.show();

        NewPersonController newPersonController = loader.getController();
        newPersonController.setPersonEdit(person);
        newPersonController.setSelectedIndex(index);
        newPersonController.setFlag(true);
        newPersonController.setPersonView(this);
        getPersonList().set(index,person);

    }

    public void loadView() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/RootView.fxml"));
        try {
            vBox = (VBox) loader.load();
            Scene scene = new Scene(vBox);
            stage.setScene(scene);
            stage.show();

            PersonController personController = loader.getController();
            personController.setPersonView(this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadDeletedPerson() {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(Main.class.getResource("/RootView.fxml"));
//        try {
//            vBox = (VBox) loader.load();
//            Scene scene = new Scene(vBox);
//            stage.setScene(scene);
//            stage.show();
//
//            PersonController personController = loader.getController();
//            personController.setPersonView(this);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        loadView();
    }
}
