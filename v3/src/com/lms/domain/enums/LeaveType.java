package com.lms.domain.enums;

public enum LeaveType {
    SICK(15),
    VACATION(16),
    MATERNITY(105);

    private final int entitlementDays;

    LeaveType(int entitlementDays) {
        this.entitlementDays = entitlementDays;
    }

    public int getEntitlementDays() {
        return entitlementDays;
    }
}
