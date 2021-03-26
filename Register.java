package oop;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Register {
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
    public void backClicked()throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage stage = Main.stageReturner();
        Scene layout = new Scene(root);
        stage.setScene(layout);


    }
    public void signupClicked() throws IOException,ClassNotFoundException {
        boolean b = true;
        ArrayList<Client> c1 = new ArrayList();
        c1 = Arrays.getClients();
        for(int i=0; i< c1.size(); i++) {
            if (c1.get(i).getUsername().equals(username.getText())){
                b = false;
                AlertBox.display("username taken");

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
        else if(!(username.getText().matches("\\w+"))){
            b=false;
            AlertBox.display("username invalid");
        }

            if(b){
            Client c = new Client(name.getText(), email.getText(), phone.getText(), username.getText(), pass.getText(), project.getText());
            FileInputStream fi = new FileInputStream(new File("Clients.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            ArrayList<Client> clients;
            clients = (ArrayList) oi.readObject();
            clients.add(c);
            oi.close();
            fi.close();


            FileOutputStream f = new FileOutputStream(new File("Clients.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(clients);
            o.close();
            f.close();


            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Stage stage = Main.stageReturner();
            Scene layout = new Scene(root);
            stage.setScene(layout);
        }

    }
}
