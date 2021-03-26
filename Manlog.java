package oop;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Manlog {
    Employee b = Elogin.a;
    Project pro = Arrays.p;
    int count = 0;
    String s = "";
    ArrayList<Employee> emp = new ArrayList<>();

    @FXML
    TextArea display;
    @FXML
    TextField input;

    public void showWorkers() throws IOException, ClassNotFoundException {

        emp = Arrays.getAll();
        FileInputStream fi = new FileInputStream(new File("Employees.txt"));
        ObjectInputStream oi = new ObjectInputStream(fi);
        ArrayList <Employee> new1 = new ArrayList<>();
        for(int i =0; i<emp.size();i++){
            Employee e = emp.get(i);
            if(e.getProject_name().equals(b.getProject_name())){
                new1.add(e);}
        }
        oi.close();
        fi.close();
        for (int i = 0; i < new1.size(); i++) {
            s += i+1 + ") " + new1.get(i).getName()+ "  " + new1.get(i).getEmpType()+" " + new1.get(i).getModules() + "  " + new1.get(i).getHours() + "    /";
        }
        display.setText(s);
        s = " ";


    }
    public void updateDetails() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("eUpdetails.fxml"));
        Stage stage = Main.stageReturner();
        Scene layout = new Scene(root);
        stage.setScene(layout);

    }
    public void showDetails(){
        display.setText(b.toString());
    }
    public void leaveProject(){
        b.setProject_name(" ");
        display.setText("you have successfully left");
    }
    public void calculateSslary(){
        String st = " " + b.calculateSalary();
        display.setText(st);
    }
    public void showProject(){
       display.setText(pro.toString());
    }

    public void logout() throws IOException{
        String s = AlertBox.display("logout confirmation","are you sure you want to log out?");
        if(s.equals("yes")) {
            Parent root = FXMLLoader.load(getClass().getResource("elogin.fxml"));
            Stage stage = Main.stageReturner();
            Scene layout = new Scene(root);
            stage.setScene(layout);
        }

    }


    public void resetClicked(){
        display.clear();

    }
}
