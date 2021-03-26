package oop;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Clogin {
    Client b = Controller.a;
    Project pro = Arrays.p;
    ArrayList<Employee> emp = new ArrayList<>();
    int sum =0;
    int count =0;
    double prog = 0.0;
    String s ="";
    @FXML
    TextArea display;


    public void updateDetails() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Cupdetails.fxml"));
        Stage stage = Main.stageReturner();
        Scene layout = new Scene(root);
        stage.setScene(layout);

    }
    public void showWorkers() throws IOException, ClassNotFoundException{

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
            s += i+1 + ")" + new1.get(i).getName() + "   ";
        }
        display.setText(s);
        s = " ";
        }

        public void delayed(){
         if(count < 10) {
             display.setText("unfortunately the project is delayed");
         }
         else
             display.setText("project is on time");
         }

         public void getProgress1()throws IOException, ClassNotFoundException {
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
                 sum += new1.get(i).getModules();
             }
             double prog = ((sum*100) / (pro.getModules()*3));
             String su = " " + prog + " %";
             display.setText(su);
             sum=0;

             //prog = pro.getModules();
             //System.out.println(prog)
         }
         public void showDetails(){
          display.setText(b.toString());
         }
         public void resetClicked(){



             display.clear();

         }
         public void logoutClicked()throws IOException{
            String s = AlertBox.display("logout confirmation","are you sure you want to log out?");
            if(s.equals("yes")) {

                Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                Stage stage = Main.stageReturner();
                Scene layout = new Scene(root);
                stage.setScene(layout);
            }


         }










}

