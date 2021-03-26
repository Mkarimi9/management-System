package oop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;

public class Eregister {
    @FXML
    TextField name;
    @FXML
    TextField email;
    @FXML
    TextField phone;
    @FXML
    TextField age;
    @FXML
    TextField id;
    @FXML
    TextField display;
    @FXML
    PasswordField pass;
    @FXML
    TextField cpass;
    @FXML
    ChoiceBox<String> employee;
    String emp;
    Employee empl;
    ObservableList<String> empType = FXCollections.observableArrayList("Admin", "ProjectManager", "Developer", "Tester", "Designer");

    public void initialize() {
        employee.setItems(empType);

    }

    public void backClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("elogin.fxml"));
        Stage stage = Main.stageReturner();
        Scene layout = new Scene(root);
        stage.setScene(layout);


    }

    public void signupClicked() throws IOException, ClassNotFoundException {
        boolean b = true;
        ArrayList<Employee> c1 = new ArrayList();
        c1 = Arrays.getAll();
        for (int i = 0; i < c1.size(); i++) {
            if (c1.get(i).getEmployee_id().equals(id.getText())) {
                b = false;
                AlertBox.display("employee id taken taken");

            }

        }
        if((!(pass.getText().equals(cpass.getText()))) || (pass.getText().length() < 6)){
            b=false;
            AlertBox.display("passwords do not match");

        }
        else if(!(email.getText().matches("\\w+[@]\\w+[.]\\w+"))) {
            b = false;
            AlertBox.display("email invalid");
        }
        else if(!(id.getText().matches("\\w+"))){
            b=false;
            AlertBox.display("username invalid");
        }
        if (b) {
            emp = (String) employee.getValue();
            System.out.println(emp);
            if (emp.equals("Admin")) {
                empl = new Admin(name.getText(), email.getText(), phone.getText(), Integer.parseInt(age.getText()), id.getText(), pass.getText(), emp);

            } else if (emp.equals("ProjectManager")) {
                empl = new ProjectManager(name.getText(), email.getText(), phone.getText(), Integer.parseInt(age.getText()), id.getText(), pass.getText(), emp);
            } else if (emp.equals("Developer")) {
                empl = new Developer(name.getText(), email.getText(), phone.getText(), Integer.parseInt(age.getText()), id.getText(), pass.getText(), emp);
            } else if (emp.equals("Tester")) {
                empl = new Tester(name.getText(), email.getText(), phone.getText(), Integer.parseInt(age.getText()), id.getText(), pass.getText(), emp);
            } else if (emp.equals("Designer")) {
                empl = new Designer(name.getText(), email.getText(), phone.getText(), Integer.parseInt(age.getText()), id.getText(), pass.getText(), emp);
            }
            FileInputStream fi = new FileInputStream(new File("Employees.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            ArrayList<Employee> cempl;
            cempl = (ArrayList) oi.readObject();
            cempl.add(empl);
            oi.close();
            fi.close();


            FileOutputStream f = new FileOutputStream(new File("Employees.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(cempl);
            o.close();
            f.close();


            Parent root = FXMLLoader.load(getClass().getResource("elogin.fxml"));
            Stage stage = Main.stageReturner();
            Scene layout = new Scene(root);
            stage.setScene(layout);

        }
    }
}
