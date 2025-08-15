package com.lts.domain.leaverequest.entities;

import com.lts.domain.employees.entities.Employee;
import com.lts.util.enums.MaternityLeaveType;
import com.lts.util.helpers.DateFomatter;

public class MaternityLeaveRequest extends LeaveRequest{
    private MaternityLeaveType _maternityLeaveType;
    private boolean _isEmergency;

    public MaternityLeaveRequest(int requestId, Employee employee, String startDate, 
                                String endDate, String reason, MaternityLeaveType maternityLeaveType,
                                boolean isEmergency) {
        super(requestId, employee, startDate, endDate, reason);
        this._maternityLeaveType = maternityLeaveType;
        this._isEmergency = isEmergency;
    }

    public void setIsEmergency(boolean isEmergency) {
        this._isEmergency = isEmergency;
    }
    public void setMaternirtLeaveTpye(MaternityLeaveType maternityLeaveType) {
        this._maternityLeaveType = maternityLeaveType;
    }

    public boolean getIsEmergency() {
        return this._isEmergency;
    }
    public MaternityLeaveType setMaternirtLeaveTpye() {
        return this._maternityLeaveType;
    }
    
    @Override
    public boolean proceessRequest() {
        boolean filedInTime = DateFomatter.getDuration(getStartDate(), getEndDate()) > 29;

        if(this._isEmergency || filedInTime) {
            System.out.println("Processing vacation leave request...");
            return true;
        }
        // TODO: For future feature in maternity leave request
        //
        // switch (this._maternityLeaveType) {
        //     case MATERNITY_LIVE_BIRTH:
                
        //         break;
        //     case MATERNITY_SOLO_PARENT:
                
        //         break;
        //     case MATERNITY_MISCARRIAGE:
                
        //         break;
        //     case PATERNITY_STANDARD:
                
        //         break;
        //     case PATERNITY_EXTENDED_TRANSFER:
                
        //         break;
        //     case ADOPTION_LEAVE:
                
        //         break;
        //     default:
        //         break;
        // }

        System.out.println("Maternity leave should be filed at least 30 business days before the start date.");
        return false;
    }
}
