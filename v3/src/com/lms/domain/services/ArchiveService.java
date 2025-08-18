package com.lms.domain.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.lms.domain.entities.LeaveRequest;
import com.lms.domain.interfaces.ArchiveServiceImp;

public class ArchiveService implements ArchiveServiceImp{
    private static final String ARCHIVE_FILE = "leave_archive.txt";

    @Override
    public void archiveLeaveRequest(LeaveRequest leaveRequest) {
        if (leaveRequest == null) {
            throw new IllegalArgumentException("Leave request cannot be null");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVE_FILE, true))) {
            writer.write(formatLeaveRequest(leaveRequest));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to archive leave request", e);
        }
    }

    private String formatLeaveRequest(LeaveRequest leaveRequest) {
        return "ID: " + leaveRequest.getRequestId() +
               ", Employee: " + leaveRequest.getEmployee().getName() +
               ", Type: " + leaveRequest.getLeaveType() +
               ", Days: " + leaveRequest.getDayRequested() +
               ", Status: " + leaveRequest.getLeaveStatus();
    }
}
