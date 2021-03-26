package oop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import static oop.Arrays.employees;
import static oop.Arrays.getAll;

public class run {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

      /*  Client c = new Client("memon", "memon@", "00", "knight", "123", "yolo");
        ArrayList<Client> a = new ArrayList<Client>();
        a.add(c);

        FileOutputStream f = new FileOutputStream(new File("Clients.txt"));
        ObjectOutputStream o = new ObjectOutputStream(f);

        // Write objects to file
        o.writeObject(a);
        o.close();
        f.close();*/


       /* Project p = new Project("09", 100000, "yolo", "sports",  100);
        ArrayList<Project> por = new ArrayList<>();
        por.add(p);

        FileOutputStream fi = new FileOutputStream(new File("Projects.txt"));
        ObjectOutputStream oi = new ObjectOutputStream(fi);

        // Write objects to file
        oi.writeObject(por);
        oi.close();
        fi.close();*/

       Developer d = new Developer("mustafa","mk@","090",20,"18","123","Developer");
        Developer d1 = new Developer("memon","memon@","110",19,"19","123","Developer");
        d.setProject_name("yolo");
        d1.setProject_name("endgame");

        ArrayList<Employee> a = new ArrayList<>();
        a.add(d);
        a.add(d1);

        FileOutputStream f = new FileOutputStream(new File("Employees.txt"));
        ObjectOutputStream o = new ObjectOutputStream(f);

        // Write objects to file
        o.writeObject(a);
        o.close();
        f.close();


    }
}



