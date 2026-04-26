# Username and password

username: 24RP01750
password: 24RP05514

# Inventory Management System

## Overview

The Inventory Management System is a web-based application designed to help organizations efficiently manage company devices and track their usage among employees.

The system focuses on:

- Assigning devices to employees
- Monitoring device status and condition
- Tracking device history (issued, returned, damaged, etc.)
- Managing employee-device relationships

This ensures transparency, accountability, and proper utilization of company assets.

---

## Objectives

- Keep a centralized record of all company devices
- Track which employee is using which device
- Monitor the condition of devices over time
- Improve asset accountability and reduce loss or misuse

---

## Features

### 1. Device Management

- Add new devices to the system
- Update device details
- Delete devices when no longer in use
- View all available and assigned devices

### 2. Employee Management

- Register employees in the system
- Update employee information
- View employee details and assigned devices

### 3. Device Assignment

- Assign devices to employees
- Record assignment details
- Prevent assigning already assigned devices

### 4. Device Return

- Mark devices as returned
- Update availability and condition

### 5. Assignment History

- Track issued and returned devices
- Maintain logs for auditing

---

## Workflow (Transaction-Based Data Flow)

This system uses transactions to ensure data consistency when transferring data between entities such as devices, employees, and assignments.

### 1. Device Assignment Transaction

When a device is assigned to an employee, a single transaction performs multiple operations:

- Step 1: Check if the device is available
- Step 2: Insert a new record into the assignments table
- Step 3: Update device status to ISSUED
- Step 4: Link the device to the selected employee

All steps succeed together. If one fails, the transaction is rolled back.

Example (conceptual):

- BEGIN TRANSACTION
- INSERT INTO assignments (device_id, employee_id, assigned_date, status)
- UPDATE devices SET status = 'ISSUED' WHERE id = device_id
- COMMIT

---

### 2. Device Return Transaction

When a device is returned, the system updates multiple records within a single transaction:

- Step 1: Update assignment record with return date
- Step 2: Update assignment status to RETURNED
- Step 3: Update device status to AVAILABLE
- Step 4: Update device condition

Example (conceptual):

- BEGIN TRANSACTION
- UPDATE assignments SET return_date = CURRENT_DATE, status = 'RETURNED'
- UPDATE devices SET status = 'AVAILABLE', condition = 'GOOD'
- COMMIT

---

### 3. Device Update Transaction

When editing device details:

- Step 1: Validate input
- Step 2: Update device information
- Step 3: Save changes

If any step fails, changes are not saved.

---

### 4. Employee Update Transaction

When updating employee details:

- Step 1: Validate employee data
- Step 2: Update employee record
- Step 3: Ensure relationships with assignments remain intact

---

## System Modules

- Dashboard – Overview of system activity
- Devices Module – Manage devices
- Employees Module – Manage employees
- Assignments Module – Handle issuing and returning
- Logs – Track all transactions

---

## Technologies Used

- Backend: Java (Spring Boot with transaction management)
- Frontend: HTML, CSS, Thymeleaf
- Database: MySQL / PostgreSQL
- Version Control: Git

---

## Transaction Management

The system uses transactional control to ensure:

- Data consistency
- Atomic operations (all succeed or all fail)
- Prevention of partial updates
- Reliable device assignment and return processes

In Spring Boot, this is typically handled using:

- @Transactional annotation
- Service layer transaction control

---

## User Roles

- Admin
  - Manage devices and employees
  - Perform assignments and returns
  - Monitor system activity

- Employee
  - View assigned devices

---

## Future Improvements

- Notifications for overdue devices
- Barcode or QR code integration
- Advanced reporting system
- Role-based access control

---

## Conclusion

This Inventory Management System ensures reliable tracking of device usage through transaction-based operations. By handling assignments and returns within controlled transactions, the system maintains data integrity and improves overall asset management efficiency.

---
