package oop;

import java.io.Serializable;
import java.util.ArrayList;

public class Tester extends Employee implements Serializable {





    public Tester(String name,String email,String phone_no,int age,String employee_id,String password,String type) {

        this.name = name;
        this.email = email;
this.empType = type;
        this.phone_no = phone_no;
        this.age = age;
        this.employee_id = employee_id;
        this.password = password;


    }

    @Override
    public double calculateSalary() {
        return 1000 * hours + 1000 * modules;
    }


}
