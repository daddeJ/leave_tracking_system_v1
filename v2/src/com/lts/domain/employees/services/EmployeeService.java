package com.lts.domain.employees.services;

import com.lts.domain.employees.entities.Employee;
import com.lts.domain.employees.interfaces.IEmployeeService;
import com.lts.domain.leaverequest.entities.LeaveRequest;
import com.lts.domain.leaverequest.interfaces.ILeaveRequestService;
import com.lts.util.enums.LeaveType;
import java.util.HashMap;

public class EmployeeService implements IEmployeeService{
    private HashMap<Integer, Employee> _employees = new HashMap<>();
    private final ILeaveRequestService _leaveRequestService;

    public EmployeeService(ILeaveRequestService leaveRequestService) {
        this._leaveRequestService = leaveRequestService;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        if (employee == null) {
            System.out.println("Cannot add null employee.");
            return false;
        }

        if (!_employees.containsKey(employee.getEmployeeId())) {
            _employees.put(employee.getEmployeeId(), employee);
            return true;
        }

        System.out.println("Employee with ID " + employee.getEmployeeId() + " already exists.");
        return false;
    }

    @Override
    public HashMap<Integer, Employee> getAllEmployee() {
        System.out.println("Retrieving all employees. Total: " + _employees.size());
        return this._employees;
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        Employee employee = _employees.get(employeeId);
        if (employee != null) {
            System.out.println("Employee retrieved: ID = " + employeeId + ", Name = " + employee.getName());
            return employee;
        }

        System.out.println("Employee not found: ID = " + employeeId);
        return null;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        if (employee == null) {
            System.out.println("Cannot update null employee.");
            return false;
        }

        if (_employees.containsKey(employee.getEmployeeId())) {
            _employees.put(employee.getEmployeeId(), employee);
            System.out.println("Employee updated: ID = " + employee.getEmployeeId() + ", Name = " + employee.getName());
            return true;
        }

        System.out.println("No employee found with ID " + employee.getEmployeeId());
        return false;
    }

    @Override
    public boolean deleteEmployee(int employeeId) {
        if (_employees.containsKey(employeeId)) {
            Employee removed = _employees.remove(employeeId);
            System.out.println("Employee deleted: ID = " + removed.getEmployeeId() + ", Name = " + removed.getName());
            return true;
        }

        System.out.println("No employee found to delete: ID = " + employeeId);
        return false;
    }

    @Override
    public HashMap<Integer, LeaveRequest> getEmployeeLeaveRequests(int employeeId) {
        HashMap<Integer, LeaveRequest> allRequests = _leaveRequestService.getAllLeaveRequest();
        HashMap<Integer, LeaveRequest> employeeRequests = new HashMap<>();

        for (LeaveRequest lr : allRequests.values()) {
            if (lr.getEmployee().getEmployeeId() == employeeId) {
                employeeRequests.put(lr.getRequestId(), lr);
            }
        }

        System.out.println("Retrieved " + employeeRequests.size() + " leave request(s) for Employee ID = " + employeeId);
        return employeeRequests;
    }

    @Override
    public void updateLeaveBalance(int employeeId, LeaveType leaveType, long dayUsed) {
        Employee tmpEmployee = getEmployeeById(employeeId);
        if (tmpEmployee == null) {
            System.out.println("Cannot update leave balance. Employee not found: ID = " + employeeId);
            return;
        }

        int oldBalance = tmpEmployee.getLeaveBalance();

        if (leaveType != LeaveType.MATERNITY) {
            int newBalance = Math.max(0, oldBalance - (int) dayUsed);
            tmpEmployee.setLeaveBalance(newBalance);
            _employees.put(employeeId, tmpEmployee);
            System.out.println("Leave balance updated for Employee ID = " + employeeId + 
                            ". Old Balance = " + oldBalance + ", Days Used = " + dayUsed + 
                            ", New Balance = " + newBalance);
        } else {
            System.out.println("Maternity leave does not affect leave balance. Employee ID = " + employeeId);
        }
    }

}
