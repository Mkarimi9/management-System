package oop;

import java.io.Serializable;

public abstract class Employee implements Serializable {
     double salary;
     String name;
     String email;
     int hours= 0;

     String phone_no;
     int age;
     String employee_id;
     String password;
     int modules = 0;
     String project_name = " ";
     String empType;

    public String getEmpType() {
        return empType;
    }
    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getModules() {
        return modules;
    }

    public void setModules(int modules) {
        this.modules = modules;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }



    public String getPhone_no() {
        return phone_no;
    }

    public int getAge() {
        return age;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public String getPassword() {
        return password;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    @Override
    public String toString() {
        return "Employee{" +

                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone_no='" + phone_no + '\'' +
                ", age=" + age +
                ", employee_id='" + employee_id + '\'' +
                ", password='" + password + '\'' +
                ", modules=" + modules + '\'' +
                ", hours=" + hours + '\'' +
                ", project_name='" + project_name + '\'' +
                '}';
    }

    public abstract double calculateSalary();


}
