package com.sda.sceneBuilder.view;

import com.sda.sceneBuilder.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

@Getter
public class PersonView {
    private ObservableList<Person> personList=FXCollections.observableArrayList();

    public PersonView() {
        personList.add(new Person("jan","kowalski", "kwiatowa", "Miasto","11111","444444444444"));
        personList.add(new Person("Adam","Iksinski","Uliczna","Metropolia","33333","7777777777"));
        personList.add(new Person("Marek","Przykładowski","Uliczyńska","Miejscowość","8888","77776555555"));
    }
}
