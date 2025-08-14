package domain.models;

public class Employee {
    private int _employeeId;
    private String _name;
    private String _department;
    private String _email;
    private int _leaveBalance;

    public Employee(int employeeId, String name, String department, String email) {
        this._employeeId = employeeId;
        this._name = name;
        this._department = department;
        this._email = email;
        this._leaveBalance = 20;
    }

    public void setEmployeeId(int employeeId) {
        this._employeeId = employeeId;
    }
    public void setName(String name) {
        this._name = name;
    }
    public void setDepartment(String department) {
        this._department = department;
    }
    public void setEmail(String email) {
        this._email = email;
    }

    public int getEmployeeId() {
        return this._employeeId;
    }
    public String getName() {
        return this._name;
    }
    public String getDepartment() {
        return this._department;
    }
    public String getEmail() {
        return this._email;
    }

    public int getLeaveBalance() {
        return this._leaveBalance;
    }

    public void setLeaveBalance(int leaveBalance) {
        if (leaveBalance >= 0) {
            this._leaveBalance = leaveBalance;
        } else {
            System.out.println("Leave balance cannot be negative.");
        }
    }

    public String toString() {
        return "Emplyee Name: " + getName() + "\nDepartment: " + getDepartment();
    }
}
