package oop;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Logged {
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
            s += i+1 + ") " + new1.get(i).getName()+ "  " + new1.get(i).getEmpType() + "  /";
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
    public void updateHours() throws IOException,ClassNotFoundException {
        String st = "old " + b.getHours();
        b.setHours(Integer.parseInt(input.getText())+b.getHours());
        st += " new " + b.getHours();
        display.setText(st);
        emp = Arrays.getAll();
        for(int i=0; i<emp.size();i++){
            if(emp.get(i).getEmployee_id().equals(b.getEmployee_id())){
                emp.set(i,b);
                break;
            }
        }
        FileOutputStream f = new FileOutputStream(new File("Employees.txt"));
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(emp);
        o.close();
        f.close();
    }
    public void updateModules()throws IOException,ClassNotFoundException{
        String st = "old " + b.getModules();
        b.setModules(Integer.parseInt(input.getText())+b.getModules());
        st += " new " + b.getModules();
        display.setText(st);
        emp = Arrays.getAll();
        for(int i=0; i<emp.size();i++){
            if(emp.get(i).getEmployee_id().equals(b.getEmployee_id())){
               emp.set(i,b);
                break;
            }
        }
        FileOutputStream f = new FileOutputStream(new File("Employees.txt"));
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(emp);
        o.close();
        f.close();

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
