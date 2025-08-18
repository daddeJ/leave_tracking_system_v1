package com.lms;

import com.lms.domain.entities.Employee;
import com.lms.domain.enums.Department;
import com.lms.domain.enums.LeaveType;
import com.lms.domain.interfaces.ApprovalServiceImp;
import com.lms.domain.interfaces.LeaveBalanceServiceImp;
import com.lms.domain.interfaces.LeaveRequestServiceImp;
import com.lms.domain.interfaces.QueueManagerServiceImp;
import com.lms.domain.services.ApprovalService;
import com.lms.domain.services.ArchiveService;
import com.lms.domain.services.LeaveBalanceService;
import com.lms.domain.services.LeaveRequestService;
import com.lms.domain.services.QueueManagerService;

public class LeaveManagementSystem {
    public static void main(String[] args) {
    LeaveRequestServiceImp leaveRequestService = new LeaveRequestService();
    LeaveBalanceServiceImp leaveBalanceService = new LeaveBalanceService();
    QueueManagerServiceImp queueManagerService = new QueueManagerService();
    ArchiveService archiveService = new ArchiveService();
    ApprovalServiceImp approvalService = new ApprovalService(queueManagerService, leaveBalanceService);

    Employee employee = new Employee(1, "Dexter Morgan", Department.REGULAR);
    leaveBalanceService.addLeaveBalance(employee, LeaveType.VACATION);
    leaveBalanceService.addLeaveBalance(employee, LeaveType.MATERNITY);
    leaveBalanceService.addLeaveBalance(employee, LeaveType.SICK);
    Employee hrEmployee = new Employee(2, "Angel Batista", Department.HR);

    var leaveRequest = leaveRequestService.createLeaveRequest(employee, 3, LeaveType.VACATION);
    System.out.println("Employee filed leave request: \n" + leaveRequest);

    queueManagerService.addRequest(leaveRequest);

    var pendingRequest = approvalService.reviewRequest(hrEmployee);
    if (pendingRequest != null) {
        System.out.println("HR reviewing leave request: \n" + pendingRequest);

        var approvedRequest = approvalService.approveRequest(pendingRequest);
        System.out.println("HR approved leave request: \n" + approvedRequest);

        queueManagerService.removeRequest(pendingRequest);
        archiveService.archiveLeaveRequest(approvedRequest);
    } else {
        System.out.println("No pending leave requests.");
    }
}
}