package oop;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Elogin {
    public static Employee a;
    public static Project p;

    @FXML
    TextField username;
    @FXML
    PasswordField pass;
    @FXML
    ChoiceBox employee;
    @FXML
    Label mess;
    String empl;
    ObservableList<String> empType = FXCollections.observableArrayList("Admin", "ProjectManager", "Developer", "Tester", "Designer");
    @FXML
    public void initialize(){
        employee.setValue("Admin");
        employee.setItems(empType);

    }
    public void registerClicked()throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Eregister.fxml"));
        Stage stage = Main.stageReturner();
        Scene layout = new Scene(root);
        stage.setScene(layout);


    }
    public void loginClicked()throws IOException, ClassNotFoundException {


        ArrayList<Employee> emp;
        emp = Arrays.getAll();
        empl = (String) employee.getValue();
        for (int i = 0; i < emp.size(); i++) {
            Employee er = emp.get(i);

            if (er.employee_id.equals(username.getText()) && er.getPassword().equals(pass.getText()) && er.getEmpType().equals(empl)) {
                if (empl.equals("Admin")) {
                    a=er;
                    Parent root = FXMLLoader.load(getClass().getResource("Alog.fxml"));
                    Stage stage = Main.stageReturner();
                    Scene layout = new Scene(root);
                    stage.setScene(layout);
                } else if (empl.equals("ProjectManager")) {
                   a=er;
                    Parent root = FXMLLoader.load(getClass().getResource("manlog.fxml"));
                    Stage stage = Main.stageReturner();
                    Scene layout = new Scene(root);
                    stage.setScene(layout);
                } else if (empl.equals("Developer")) {
                    a=er;
                    Parent root = FXMLLoader.load(getClass().getResource("logged.fxml"));
                    Stage stage = Main.stageReturner();
                    Scene layout = new Scene(root);
                    stage.setScene(layout);
                } else if (empl.equals("Tester")) {
                    a=er;
                    Parent root = FXMLLoader.load(getClass().getResource("logged.fxml"));
                    Stage stage = Main.stageReturner();
                    Scene layout = new Scene(root);
                    stage.setScene(layout);
                } else if (empl.equals("Designer")) {
                    a=er;
                    Parent root = FXMLLoader.load(getClass().getResource("logged.fxml"));
                    Stage stage = Main.stageReturner();
                    Scene layout = new Scene(root);
                    stage.setScene(layout);
                }


            }
            else
                mess.setText("inavalid id or password");

        }
    }

    public void mode1Clicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage stage = Main.stageReturner();
        Scene layout = new Scene(root);
        stage.setScene(layout);

    }

}
