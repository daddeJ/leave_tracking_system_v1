package com.lms.domain.entities;

import com.lms.domain.enums.Department;

public class Employee {
    private int _employeeId;
    private String _name;
    private Department _department;

    public Employee(int employeeId, String name, Department department) {
        this._employeeId = employeeId;
        this._name = name;
        this._department = department;
    }

    public void setEmployeeId(int employeeId) {
        this._employeeId = employeeId;
    }
    public void setName(String name) {
        this._name = name;
    }
    public void setDepartment(Department department) {
        this._department = department;
    }

    public int getEmployeeId() {
        return this._employeeId;
    }
    public String getName() {
        return this._name;
    }
    public Department getDepartment() {
        return this._department;
    }
}
