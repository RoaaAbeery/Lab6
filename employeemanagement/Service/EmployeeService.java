package com.example.employeemanagement.Service;

import com.example.employeemanagement.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeService {
    ArrayList<Employee> employees = new ArrayList<>();

    public ArrayList getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public boolean updateEployee(String id, Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(id)) {
                employees.set(i, employee);
                return true;
            }
        }
        return false;
    }

    public boolean deleteEmployee(String id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(id)) {
                employees.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Employee> getPosition(String postion) {
        ArrayList<Employee> e = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getPosition().equals(postion)) {
                e.add(employee);
            }

        }
        return e;
    }

    public ArrayList<Employee> getAge(int maxage,int minage) {
        ArrayList<Employee> a = new ArrayList<>();
        for (Employee employee : employees) {
            if(employee.getAge()<=maxage&&employee.getAge()>=minage){
                a.add(employee);
            }
        }
        return a;
    }

    public boolean getAnnualleave(String id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                if (!employee.isOnLeave()) {
                    if (employee.getAnnualLeave() >= 1) {
                        employee.setOnLeave(true);
                       employee.setAnnualLeave(employee.getAnnualLeave() - 1);
                        return true;
                    }
                }
            }
        }
        return false;

    }

    public ArrayList<Employee> getNoleave() {
        ArrayList<Employee> e = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAnnualLeave() == 0) {
                e.add(employee);
            }
        }
        return e;
    }

    public boolean promoteEmployee(String id1, String id2) {
        for (Employee supervisor : employees) {
            if (supervisor.getId().equals(id1)) {
                for (Employee employee : employees) {
                    if (employee.getId().equals(id2)) {
                        if (supervisor.getPosition().equals("supervisor")) {
                            if (employee.getAge() >= 30) {
                                if (!employee.isOnLeave()) {
                                    employee.setPosition("supervisor");
                                    return true;
                                }
                            }
                        }
                    }
                }

            }
        }
        return false;
    }

}