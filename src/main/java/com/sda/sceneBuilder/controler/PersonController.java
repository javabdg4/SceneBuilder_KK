package com.sda.sceneBuilder.controler;

import com.sda.sceneBuilder.model.Person;
import com.sda.sceneBuilder.view.PersonView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lombok.Getter;

@Getter
public class PersonController {
    @FXML
    private TableView<Person> personTableView;
    @FXML
    private TableColumn<Person, String> nameCol;
    @FXML
    private TableColumn<Person, String> lastNameCol;
    @FXML
    private Label nameLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label streetLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Label postalCodeLabel;

    @FXML
    private Label telephoneLabel;

    private PersonView personView;

    public void setPersonView(PersonView personView) {
        this.personView = personView;
        personTableView.setItems(personView.getPersonList());
    }

    public void initialize(){
        System.out.println("to jest test");
        nameCol.setCellValueFactory(cell -> cell.getValue().nameProperty());
        lastNameCol.setCellValueFactory(cell->cell.getValue().lastnameProperty());
        personTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldField, newField)->viewPersonInfoOnLabel(newField)
        );
    }

    private void viewPersonInfoOnLabel(Person person) {

        nameLabel.setText(person.getName());
        lastNameLabel.setText(person.getLastname());
        streetLabel.setText(person.getCity());
        postalCodeLabel.setText(person.getPostalCode());
        telephoneLabel.setText(person.getTelephone());
        cityLabel.setText(person.getCity());
    }
}
