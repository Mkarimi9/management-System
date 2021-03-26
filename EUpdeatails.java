package oop;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class EUpdeatails {


    Employee c = Elogin.a;

    String name1 = c.getName();
    @FXML
    TextField name;
    @FXML
    TextField email;
    @FXML
    TextField phone;
    @FXML
    TextField id;
    @FXML
    TextField age;
    @FXML
    TextField display;
    @FXML
    PasswordField pass;
    @FXML
    TextField cpass;

    public void back1Clicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("elogin.fxml"));
        Stage stage = Main.stageReturner();
        Scene layout = new Scene(root);
        stage.setScene(layout);

    }

    public void updateClicked() throws IOException, ClassNotFoundException {
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
            ArrayList<Employee> cle = Arrays.getAll();
            for (Employee ct : cle) {

                if (ct.name.equals(name1)) {
                    ct.setName(name.getText());
                    ct.setEmail(email.getText());
                    ct.setPassword(pass.getText());
                    ct.setPhone_no(phone.getText());
                    ct.setEmployee_id(id.getText());
                    ct.setAge(Integer.parseInt(age.getText()));
                    break;
                }
            }
            FileOutputStream f = new FileOutputStream(new File("Employees.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);


            o.writeObject(cle);
            o.close();
            f.close();


            Parent root = FXMLLoader.load(getClass().getResource("elogin.fxml"));
            Stage stage = Main.stageReturner();
            Scene layout = new Scene(root);
            stage.setScene(layout);

        }
    }
}

