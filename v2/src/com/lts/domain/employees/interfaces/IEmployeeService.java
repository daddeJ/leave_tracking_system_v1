package com.lts.domain.employees.interfaces;

import com.lts.domain.employees.entities.Employee;
import com.lts.domain.leaverequest.entities.LeaveRequest;
import com.lts.util.enums.LeaveType;
import java.util.HashMap;

public interface IEmployeeService {
    boolean addEmployee(Employee employee);
    HashMap<Integer, Employee> getAllEmployee();
    HashMap<Integer, LeaveRequest> getEmployeeLeaveRequests(int employeeId);
    Employee getEmployeeById(int employeeId);
    boolean updateEmployee(Employee employee);
    boolean deleteEmployee(int employeeId);
    void updateLeaveBalance(int employeeId, LeaveType leaveType, long dayUsed);
}
