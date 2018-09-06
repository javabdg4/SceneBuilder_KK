package com.sda.sceneBuilder.controler;

import com.sda.sceneBuilder.model.Person;
import com.sda.sceneBuilder.view.PersonView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lombok.Getter;
import com.sda.sceneBuilder.view.PersonView;

@Getter
public class PersonController {
public int index;
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

    public void initialize() {
        //System.out.println("to jest test");
        nameCol.setCellValueFactory(cell -> cell.getValue().nameProperty());
        lastNameCol.setCellValueFactory(cell -> cell.getValue().lastnameProperty());
        personTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldField, newField) -> viewPersonInfoOnLabel(newField)
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

    public void handleEditButton(ActionEvent actionEvent) {
        System.out.println("edit");

        Person selectedPerson = personTableView.getSelectionModel().getSelectedItem();
        index=personTableView.getSelectionModel().getFocusedIndex();


        personView.loadEditPerson(selectedPerson,index);
    }

    public void handleDeleteButton(ActionEvent actionEvent) {
        System.out.println("delete");
        Alert alert = new Alert
                (Alert.AlertType.CONFIRMATION,
                        "Are you sure?",
                        ButtonType.YES,
                        ButtonType.NO);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            Person personToDelete = personTableView.getSelectionModel().getSelectedItem();
            personView.getPersonList().remove(personToDelete);

            personView.loadDeletedPerson();
        }
    }
    public void handleNewButton(ActionEvent actionEvent) {
        System.out.println("new");

        personView.loadNewPerson();
    }

    public void handleSaveButton(ActionEvent actionEvent) {
        System.out.println("save");
    }

    public int getIndex() {
        return index;
    }
}
