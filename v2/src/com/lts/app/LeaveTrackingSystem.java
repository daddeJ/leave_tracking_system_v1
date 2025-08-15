package com.lts.app;

import com.lts.domain.employees.entities.Employee;
import com.lts.domain.employees.interfaces.IEmployeeService;
import com.lts.domain.employees.services.EmployeeService;
import com.lts.domain.leaverequest.interfaces.ILeaveRequestService;
import com.lts.domain.leaverequest.interfaces.ILeaveTrackingService;
import com.lts.domain.leaverequest.services.LeaveRequestService;
import com.lts.domain.leaverequest.services.LeaveTrackingService;
import com.lts.util.enums.EmployeeType;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LeaveTrackingSystem {
    private static IEmployeeService employeeService;
    private static ILeaveRequestService leaveRequestService;
    private static ILeaveTrackingService leaveTrackingService;

    public static void main(String[] args) {
        leaveRequestService = new LeaveRequestService();
        leaveTrackingService = new LeaveTrackingService();
        employeeService = new EmployeeService(leaveRequestService);
        
        loadEmployeesFromTxt("documents/employees.txt");

        HashMap<Integer, Employee> tmpEmployeeList = employeeService.getAllEmployee();

        for (Employee emp : tmpEmployeeList.values()) {
            System.out.println(emp);
        }
        
    }

    private static void loadEmployeesFromTxt(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] idAndRest = line.split("=");
                if (idAndRest.length != 2) continue;

                int id = Integer.parseInt(idAndRest[0].trim());

                String[] parts = idAndRest[1].split(",");
                if (parts.length != 5) continue;

                String name = parts[0].trim();
                String department = parts[1].trim();
                String email = parts[2].trim();
                EmployeeType type = EmployeeType.valueOf(parts[3].trim());
                int leaveBalance = Integer.parseInt(parts[4].trim());

                Employee emp = new Employee(id, name, department, email, type);
                emp.setLeaveBalance(leaveBalance);
                employeeService.addEmployee(emp);
            }

            System.out.println("Employees loaded from TXT.");
        } catch (IOException e) {
            System.out.println("Error reading employees TXT file: " + e.getMessage());
        }
    }
}

