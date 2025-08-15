package com.lts.domain.leaverequest.entities;

import com.lts.domain.employees.entities.Employee;
import com.lts.util.helpers.DateFomatter;

public class SickLeaveRequest extends LeaveRequest {
    private boolean _medicalCertificateProvided;

    public SickLeaveRequest(int requestId, Employee employee, String startDate, 
                            String endDate, String reason, boolean medicalCertificateProvided) {
        super(requestId, employee, startDate, endDate, reason);
        this._medicalCertificateProvided = medicalCertificateProvided;
    }
    
    public boolean isMedicalCertificateProvided() {
        return this._medicalCertificateProvided;
    }
    
    @Override
    public boolean proceessRequest() {
        if (!this._medicalCertificateProvided && DateFomatter.getDuration(getStartDate(), getEndDate()) > 2) {
            System.out.println("Sick leave longer than 2 days requires a medical certificate");
            return false;
        }

        System.out.println("Processing sick leave request...");
        return true;
    }
}
