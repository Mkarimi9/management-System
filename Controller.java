package oop;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class Controller {
    public static Client a;
    public static Project p;

    @FXML TextField username;
    @FXML PasswordField pass;
    @FXML Label mess;
    public void registerClicked()throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
        Stage stage = Main.stageReturner();
        Scene layout = new Scene(root);
        stage.setScene(layout);


    }
    public void loginClicked()throws IOException, ClassNotFoundException{


        ArrayList<Client> clients;
        clients = Arrays.getClients();

        for(int i=0; i<clients.size(); i++){

            if(clients.get(i).username.equals(username.getText()) && clients.get(i).getPassword().equals(pass.getText())){
                a = new Client(clients.get(i).getName(),clients.get(i).getEmail(),clients.get(i).getPhone_no(),clients.get(i).getUsername(),clients.get(i).getPassword(),clients.get(i).getProject_name());
                p = Arrays.getProject(clients.get(i).getProject_name());
                Parent root = FXMLLoader.load(getClass().getResource("clogin.fxml"));
                Stage stage = Main.stageReturner();
                Scene layout = new Scene(root);
                stage.setScene(layout);

            }
            else
                mess.setText("invalid username or password");


        }
    }
    public void modeClicked()throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("elogin.fxml"));
        Stage stage = Main.stageReturner();
        Scene layout = new Scene(root);
        stage.setScene(layout);
    }

}
