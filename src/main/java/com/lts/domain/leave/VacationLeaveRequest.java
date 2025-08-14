package domain.leave;

import domain.models.Employee;

public class VacationLeaveRequest extends LeaveRequest {

    public VacationLeaveRequest(int requestId, Employee employee, String startDate, String endDate, String reason) {
        super(requestId, employee, startDate, endDate, reason);
    }

    @Override
    public boolean proceessRequest() {
        boolean filedInTime = getFiledDuration() > 2;
        boolean durationValid = getDuration() > 0 && getDuration() < 31;

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
