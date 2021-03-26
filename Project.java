package oop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Project implements Serializable {
     double progress;
     String due_date;
     double budget;
     String name;
     String genre;
     int modules;


    public Project(String due_date, double budget, String name, String genre,int modules) {

        this.due_date = due_date;
        this.budget = budget;
        this.name = name;
        this.genre = genre;
        this.modules = modules;

    }

    public int getModules() {
        return modules;
    }

    public void setModules(int modules) {
        this.modules = modules;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Project{" +
                "progress=" + progress +
                ", due_date='" + due_date + '\'' +
                ", budget=" + budget +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
