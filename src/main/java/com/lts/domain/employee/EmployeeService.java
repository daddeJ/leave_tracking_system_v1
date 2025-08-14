package domain.employee;

import java.util.HashMap;

import domain.leave.LeaveRequest;
import domain.models.Employee;
import domain.port.IEmployeeService;
import domain.port.ILeaveRequestService;

public class EmployeeService implements IEmployeeService{
    private HashMap<Integer, Employee> _employees = new HashMap<>();
    private ILeaveRequestService _leaveRequestService;

    public EmployeeService(ILeaveRequestService leaveRequestService) {
        this._leaveRequestService = leaveRequestService;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        if (!_employees.containsKey(employee.getEmployeeId())) {
            _employees.put(employee.getEmployeeId(), employee);
            System.out.println(
                "Employee added."
            );
            return true;
        }
        
        System.out.println(
            "Employee with this ID already exists."
        );
        return false;
    }

    @Override
    public HashMap<Integer, Employee> getAllEmployee() {
        return this._employees;
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        if (_employees.containsKey(employeeId)) {
            return _employees.get(employeeId);
        }

        System.out.println(
            "Employee request not found."
        );
        return null;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        if (_employees.containsKey(employee.getEmployeeId())) {
            _employees.put(employee.getEmployeeId(), employee);
            System.out.println(
                "Employee " + employee.getName() + " updated"
            );
            return true;
        }

        System.out.println(
            "No Employee found."
        );
        return false;
    }

    @Override
    public boolean deleteEmployee(int employeeId) {
        if (_employees.containsKey(employeeId)) {
            _employees.remove(employeeId);
            System.out.println(
                "Employee deleted"
            );
            return true;
        }

        System.out.println(
            "No Employee found."
        );
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
        return employeeRequests;
    }

}
