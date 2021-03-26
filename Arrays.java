package oop;

import java.io.Serializable;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Arrays implements Serializable {

    public static ArrayList<Employee> employees = new ArrayList<Employee>();
    public static ArrayList<Project> projects = new ArrayList<Project>();
    public static ArrayList<Client> clients = new ArrayList<Client>();
    public static Project p;

    public static ArrayList<Employee> getAll() throws IOException, ClassNotFoundException {
        FileInputStream fi = new FileInputStream(new File("Employees.txt"));
        ObjectInputStream oi = new ObjectInputStream(fi);
        employees = (ArrayList) oi.readObject();
        oi.close();
        fi.close();
        return employees;
    }

    public static ArrayList<Project> getProjects() throws IOException, ClassNotFoundException{
        FileInputStream fi = new FileInputStream(new File("Projects.txt"));
        ObjectInputStream oi = new ObjectInputStream(fi);
        projects = (ArrayList) oi.readObject();
        oi.close();
        fi.close();
        return projects;


    }
    public static ArrayList<Client> getClients() throws IOException, ClassNotFoundException{
        FileInputStream fi = new FileInputStream(new File("Clients.txt"));
        ObjectInputStream oi = new ObjectInputStream(fi);
        clients = (ArrayList) oi.readObject();
        oi.close();
        fi.close();
        return clients;

}
public static Project getProject(String name) throws IOException, ClassNotFoundException{
        ArrayList<Project> po = new ArrayList<>();
        po = getProjects();
        for(int i =0; i<po.size(); i++){
            if(po.get(i).getName().equals(name)){
                p=po.get(i);
                break;
            }

        }
    return p;
}


}




















