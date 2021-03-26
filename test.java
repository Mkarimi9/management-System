package oop;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import oop.Arrays;

public class test implements Serializable{
public static void main(String[] args) throws IOException,ClassNotFoundException{
    ArrayList<Project> are = new ArrayList<>();
    are = Arrays.getProjects();
    for(int i=0; i<are.size(); i++)
        System.out.println(are.get(i).getModules());

}

}