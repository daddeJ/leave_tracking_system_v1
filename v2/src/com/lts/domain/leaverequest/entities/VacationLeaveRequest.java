package com.lts.domain.leaverequest.entities;

import com.lts.domain.employees.entities.Employee;
import com.lts.util.helpers.DateFomatter;

public class VacationLeaveRequest extends LeaveRequest {

    public VacationLeaveRequest(int requestId, Employee employee, String startDate, String endDate, String reason) {
        super(requestId, employee, startDate, endDate, reason);
    }

    @Override
    public boolean proceessRequest() {
        boolean filedInTime = DateFomatter.getFiledDuration(getStartDate()) > 2;
        long fileDuration = DateFomatter.getDuration(getStartDate(), getEndDate());
        boolean durationValid = fileDuration > 0 && fileDuration < 31;

        if (filedInTime && durationValid) {
            System.out.println("Processing vacation leave request...");
            return true;
        }

        System.out.println(
            "Vacation leave should be filed at least 3 business days before the start date " +
            "\nand should be at least 1 day but not exceed 30 days."
        );
        return false;
    }
}
