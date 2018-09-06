package com.sda.sceneBuilder.controler;

import com.sda.sceneBuilder.model.Person;
import com.sda.sceneBuilder.view.PersonView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import lombok.Getter;

import javafx.*;


public class NewPersonController {
    private PersonView personView;
    private PersonController personController;

    public void setIndex(int index) {
        this.index = index;
    }

    private int index;
    @FXML
    public TextField name;

    @FXML
    public TextField lastname;

    @FXML
    public TextField city;

    @FXML
    public TextField street;

    @FXML
    public TextField postalCode;

    @FXML
    public TextField telephone;

    @FXML
    private Button closeButton;


    public Stage stage;
    public boolean flag;

    public void handleSaveNewPersonButton(ActionEvent actionEvent) {
        System.out.println("save");
        //personView.loadView();
        System.out.println(name.getText());
        System.out.println(lastname.getText());
        System.out.println(city.getText());
        System.out.println(street.getText());
        System.out.println(postalCode.getText());
        System.out.println(telephone.getText());

        if (!flag) {
            handleCancel(actionEvent);
            System.out.println("zapis");
            personView.getPersonList().add(new Person(name.getText(), lastname.getText(), city.getText(), street.getText(), postalCode.getText(), telephone.getText()));

        } else {
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"" +
                    "Do you want to save?",
                    ButtonType.YES,
                    ButtonType.NO);
            alert.showAndWait();
            if(alert.getResult()==ButtonType.YES) {
                Person person = new Person(name.getText(), lastname.getText(), city.getText(), street.getText(), postalCode.getText(), telephone.getText());
                personView.getPersonList().set(this.index, person);
                //setPersonEdit(person);
                System.out.println("edycja");
                System.out.println(person.toString());
            }
        }
        handleCancel(actionEvent);
    }

    public void handleCancel(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        //this.stage.close();
    }

    public void setPersonView(PersonView personView) {
        this.personView = personView;
    }

    public void setPersonEdit(Person person) {
        name.setText(person.getName());
        lastname.setText(person.getLastname());
        city.setText(person.getCity());
        postalCode.setText(person.getCity());
        telephone.setText(person.getTelephone());
        street.setText(person.getStreet());
    }



    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
    public void setPersonController(PersonController personController){
        this.personController=personController;
    }

    public void setSelectedIndex(int index) {
        this.index=index;
    }
}
