package oop;

import javafx.fxml.FXML;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import static oop.Arrays.clients;

public class Cpro {
    @FXML
    TextField name;
    @FXML
    TextField genre;
    @FXML
    TextField budget;
    @FXML
    TextField date;
    @FXML
    TextField modules;
    public void backClicked()throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Alog.fxml"));
        Stage stage = Main.stageReturner();
        Scene layout = new Scene(root);
        stage.setScene(layout);


    }
    public void create()throws IOException,ClassNotFoundException{
        Project p = new Project(date.getText(), Double.parseDouble(budget.getText()),name.getText(),genre.getText(),Integer.parseInt(modules.getText()));
        FileInputStream fi = new FileInputStream(new File("Projects.txt"));
        ObjectInputStream oi = new ObjectInputStream(fi);
        ArrayList<Project> projects;
        projects = (ArrayList) oi.readObject();
        projects.add(p);
        oi.close();
        fi.close();


        FileOutputStream f = new FileOutputStream(new File("Projects.txt"));
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(projects);
        o.close();
        f.close();


        Parent root = FXMLLoader.load(getClass().getResource("Alog.fxml"));
        Stage stage = Main.stageReturner();
        Scene layout = new Scene(root);
        stage.setScene(layout);

    }






}
