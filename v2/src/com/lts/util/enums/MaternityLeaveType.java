package com.lts.util.enums;

public enum MaternityLeaveType {
    MATERNITY_LIVE_BIRTH(ParentType.MOTHER, 105),          // Mother - 105 days
    MATERNITY_SOLO_PARENT(ParentType.MOTHER, 120),         // Mother - 120 days
    MATERNITY_MISCARRIAGE(ParentType.MOTHER, 60),         // Mother - 60 days
    PATERNITY_STANDARD(ParentType.FATHER, 7),            // Father - usually 7 days
    PATERNITY_EXTENDED_TRANSFER(ParentType.FATHER, 14),   // Father - up to 14 days if transferred from mother (RA 11210)
    ADOPTION_LEAVE(ParentType.EITHER, 7);              // Either parent - up to 7 days

    private final ParentType _parentType;
    private final int _allowedDays;

    MaternityLeaveType(ParentType parentType, int allowedDays) {
        this._parentType = parentType;
        this._allowedDays = allowedDays;
    }

    public ParentType getParentType() {
        return this._parentType;
    }

    public int getAllowedDays() {
        return this._allowedDays;
    }

}
