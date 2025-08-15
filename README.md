# leave_tracking_system_v1
Case study in Java Development course

# Leave Request Workflow (Basic Entry to End Point)

## 1. Employee creates leave request
- **Action:** Employee → files → `LeaveRequest`
- **Data:** Selects a `LeaveType` (e.g., Sick, Vacation, Maternity, etc.)

---

## 2. System queues request
- **Action:** Employee → adds → `LeaveRequest` *(to Queue)*

---

## 3. HR reviews pending requests
- **Action:** HR Employee → views → `LeaveRequest` *(Queue)*
- **Action:** HR Employee → selects → specific `LeaveRequest`

---

## 4. Retrieve request details
- **Action:** HR Employee → gets → `LeaveRequest` *(full details)*

---

## 5. HR reviews and decides
- **Action:** HR Employee → reviews → request details
- **Action:** HR Employee → processes → decision
- **Outcome:** Approve or Deny

---

## 6. Conditional balance update (if approved)
- **Condition:** If **Approved** AND `LeaveType` is **NOT** `MaternityLeave`  
- **Action:** Update `Employee` → `LeaveBalance`

---

## 7. Update request status
- **Action:** `LeaveRequestService` → updates status → `Status` *(APPROVED/DENIED)*
- **Metadata:**
  - `ChangedBy` = HR Name
  - `ChangedDate` = Current Date

---

## 8. Remove from queue
- **Action:** `LeaveRequest` *(Queue)* → removes → processed request

---

## 9. Archive request
- **Action:** `LeaveRequest` → adds to → `LeaveRequestHistory`
