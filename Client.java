package oop;

import java.io.Serializable;
import java.util.ArrayList;

public class Client implements Serializable {
     String name;
     String email;
     String phone_no;
     String username;
     String password;
     String project_name;



    public Client(String name, String email, String phone_no, String username, String password, String project_name) {
        this.name = name;
        this.email = email;
        this.phone_no = phone_no;
        this.username = username;
        this.password = password;
        this.project_name = project_name;

    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone_no='" + phone_no + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", project_name='" + project_name + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }
}
