package com.lms.domain.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lms.domain.entities.Employee;
import com.lms.domain.entities.LeaveBalance;
import com.lms.domain.entities.LeaveRequest;
import com.lms.domain.enums.LeaveType;
import com.lms.domain.interfaces.LeaveBalanceServiceImp;

public class LeaveBalanceService implements LeaveBalanceServiceImp{
    private Map<Integer, Map<LeaveType, LeaveBalance>> leaveBalances = new HashMap<>();

    @Override
    public LeaveBalance deductLeaveBalance(LeaveRequest leaveRequest) {
        var empBalances = leaveBalances.get(leaveRequest.getEmployee().getEmployeeId());

        if (empBalances == null || !empBalances.containsKey(leaveRequest.getLeaveType())) {
            throw new IllegalStateException("Leave balance not found for employee");
        }

        LeaveBalance balance = empBalances.get(leaveRequest.getLeaveType());
        balance.deduct(leaveRequest.getDayRequested());

        return balance;
    }

    @Override
    public void addLeaveBalance(Employee employee, LeaveType leaveType) {
        int entitlement = leaveType.getEntitlementDays();
        leaveBalances
            .computeIfAbsent(employee.getEmployeeId(), id -> new HashMap<>())
            .put(leaveType, new LeaveBalance(leaveType, entitlement, employee));
    }

    @Override
    public List<LeaveBalance> getLeaveBalanceByEmployee(Employee employee) {
        return new ArrayList<>(
            leaveBalances.getOrDefault(employee.getEmployeeId(), Map.of()).values()
        );
    }

}
