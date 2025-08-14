package domain.port;

import java.util.HashMap;

import domain.leave.LeaveRequest;
import domain.models.Employee;

public interface IEmployeeService {
    boolean addEmployee(Employee employee);
    HashMap<Integer, Employee> getAllEmployee();
    HashMap<Integer, LeaveRequest> getEmployeeLeaveRequests(int employeeId);
    Employee getEmployeeById(int employeeId);
    boolean updateEmployee(Employee employee);
    boolean deleteEmployee(int employeeId);
}
