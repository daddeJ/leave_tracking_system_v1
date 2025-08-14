package domain.leave;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import domain.models.Employee;
import domain.port.Approvable;
import domain.status.LeaveStatus;

public abstract class LeaveRequest implements Approvable{
    private int _requestId;
    private Employee _employee;
    private String _startDate;
    private String _endDate;
    private LeaveStatus _status;
    private String _reason;
    private ArrayList<StatusChange> statusHistory = new ArrayList<>();

    public LeaveRequest(int requestId, Employee employee, String startDate,
                        String endDate, String reason) {
        this._requestId = requestId;
        this._employee = employee;
        this._startDate = startDate;
        this._endDate = endDate;
        this._status = LeaveStatus.Pending;
        this._reason = reason;
    }
    public class StatusChange {
        private LeaveStatus _oldStatus;
        private LeaveStatus _newStatus;
        private String _changeDate;
        private String _changeBy;

        public StatusChange(LeaveStatus oldStatus, LeaveStatus newStatus, 
                          String changeDate, String changedBy) {
            this._oldStatus = oldStatus;
            this._newStatus = newStatus;
            this._changeDate = changeDate;
            this._changeBy = changedBy;
        }

        public void setOldStatus(LeaveStatus status) {
            this._oldStatus = status;
        }
        public void setNewStatus(LeaveStatus status) {
            this._newStatus = status;
        }
        public void setChangeDate(String changeDate) {
            this._changeDate = changeDate;
        }
        public void setChangeBy(String changeBy) {
            this._changeBy = changeBy;
        }

        public LeaveStatus getOldStatus() {
            return this._oldStatus;
        }
        public LeaveStatus getNewStatus() {
            return this._newStatus;
        }
        public String getChangeDate() {
            return this._changeDate;
        }
        public String getChangeBy() {
            return this._changeBy;
        }
    }

    public void changeStatus(LeaveStatus newStatus, String changeBy) {
        LeaveStatus olStatus = this._status;
        this._status = newStatus;

        StatusChange change = new StatusChange(olStatus, newStatus, getCurrentDate(), changeBy);
        statusHistory.add(change);
    }

    public String getCurrentDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return today.format(formatter);
    }

    public boolean proceessRequest() {
        System.out.println("Processing leave request...");
        return true;
    }
    
    public long getDuration() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDateLocal = LocalDate.parse(_startDate, formatter);
        LocalDate endDateLocal = LocalDate.parse(_endDate, formatter);

        Instant startUtc = startDateLocal.atStartOfDay().toInstant(ZoneOffset.UTC);
        Instant endUtc = endDateLocal.atStartOfDay().toInstant(ZoneOffset.UTC);

        return ChronoUnit.DAYS.between(startUtc, endUtc);
    }

    @Override
    public boolean approve(String approverName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'approve'");
    }

    @Override
    public boolean deny(String approverName, String reason) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deny'");
    }

    
}
