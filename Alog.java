package oop;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


import java.io.*;
import java.util.ArrayList;

public class Alog {
    @FXML
    TextArea display;
    Employee b = Elogin.a;
    ArrayList<Employee> emp = new ArrayList<>();
    String s= "";
    @FXML
    TextField empid;
    @FXML
    TextField project;


    public void updateDetails() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("eUpdetails.fxml"));
        Stage stage = Main.stageReturner();
        Scene layout = new Scene(root);
        stage.setScene(layout);

    }
    public void showDetails(){
        display.setText(b.toString());
    }
    public void showWorkers() throws IOException, ClassNotFoundException {

        emp = Arrays.getAll();

        for (int i = 0; i < emp.size(); i++) {
            s += i + 1 + ") " + emp.get(i).getName() + "  " + emp.get(i).getEmpType() + "  /";
        }
        display.setText(s);
        s = " ";


    }

    public void remove()throws IOException, ClassNotFoundException{
        emp = Arrays.getAll();
        for(int i =0; i<emp.size(); i++){
            if(emp.get(i).getEmployee_id().equals(empid.getText())){
                emp.get(i).setProject_name(" ");
                break;
            }
        }
        FileOutputStream f = new FileOutputStream(new File("Employees.txt"));
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(emp);
        o.close();
        f.close();
        display.setText("employee removed from project");

    }
    public void view()throws IOException, ClassNotFoundException{
            emp = Arrays.getAll();
            for(int i =0; i<emp.size(); i++){
                if(emp.get(i).getEmployee_id().equals(empid.getText())){
                    s = emp.get(i).toString();
                    break;

                }
            }
            display.setText(s);

    }
    public void fire()throws IOException, ClassNotFoundException{
        emp = Arrays.getAll();
        for(int i =0; i<emp.size(); i++) {
            if (emp.get(i).getEmployee_id().equals(empid.getText())) {
                emp.remove(i);
                break;
            }
        }
            FileOutputStream f = new FileOutputStream(new File("Employees.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);


            o.writeObject(emp);
            o.close();
            f.close();
            display.setText("employee has been removed from the company");
    }
    public void newProject()throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("cpro.fxml"));
        Stage stage = Main.stageReturner();
        Scene layout = new Scene(root);
        stage.setScene(layout);


    }
    public void viewClients() throws IOException, ClassNotFoundException{
        ArrayList<Client> c = new ArrayList<>();
        c = Arrays.getClients();
        for(int i=0; i<c.size(); i++){
            s += i +")" + c.get(i).getName() + " pn " + c.get(i).getProject_name() + "     ";
        }
        display.setText(s);
        s="";
    }
    public void viewProjects() throws IOException, ClassNotFoundException{
        ArrayList<Project> p = new ArrayList<>();
        p = Arrays.getProjects();
        for(int i=0; i<p.size(); i++){
            s += i +")" + p.get(i).getName() + " due " + p.get(i).getDue_date() + "     ";
        }
        display.setText(s);
        s="";

    }


    public void addtoProject() throws IOException, ClassNotFoundException{
        emp = Arrays.getAll();
        for(int i =0; i<emp.size(); i++){
            if(emp.get(i).getEmployee_id().equals(empid.getText())){
                emp.get(i).setProject_name(project.getText());
                break;
            }
        }
        FileOutputStream f = new FileOutputStream(new File("Employees.txt"));
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(emp);
        o.close();
        f.close();
        display.setText("employee added to project");


    }
    public void logout()throws IOException{
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
