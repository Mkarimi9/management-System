package oop;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Cupdetails {
    Client c = Controller.a;

    String name1 = c.getName();
    @FXML
    TextField name;
    @FXML
    TextField email;
    @FXML
    TextField phone;
    @FXML
    TextField username;
    @FXML
    TextField project;
    @FXML
    TextField display;
    @FXML
    PasswordField pass;
    @FXML
    TextField cpass;

    public void back1Clicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("clogin.fxml"));
        Stage stage = Main.stageReturner();
        Scene layout = new Scene(root);
        stage.setScene(layout);

    }

    public void updateClicked() throws IOException, ClassNotFoundException {
        boolean b = true;
        ArrayList<Client> c1 = new ArrayList();
        c1 = Arrays.getClients();

        for (int i = 0; i < c1.size(); i++) {
            if (c1.get(i).getUsername().equals(username.getText())) {
                b = false;
                AlertBox.display("username taken");

            }
            if((!(pass.getText().equals(cpass.getText()))) || (pass.getText().length() < 6)){
                b=false;
                AlertBox.display("passwords do not match or length is less than 6");

            }
            else if(!(email.getText().matches("\\w+[@]\\w+[.]\\w+"))) {
                b = false;
                AlertBox.display("email invalid");
            }
            else if(!(username.getText().matches("\\w+"))){
                b=false;
                AlertBox.display("username invalid");
            }
            if (b) {
                ArrayList<Client> cle = Arrays.getClients();
                for (Client ct : cle) {

                    if (ct.name.equals(name1)) {
                        ct.setName(name.getText());
                        ct.setEmail(email.getText());
                        ct.setPassword(pass.getText());
                        ct.setPhone_no(phone.getText());
                        ct.setUsername(username.getText());
                        ct.setProject_name(project.getText());
                        break;
                    }
                }
                FileOutputStream f = new FileOutputStream(new File("Clients.txt"));
                ObjectOutputStream o = new ObjectOutputStream(f);


                o.writeObject(cle);
                o.close();
                f.close();


                Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                Stage stage = Main.stageReturner();
                Scene layout = new Scene(root);
                stage.setScene(layout);

            }
        }
    }
}