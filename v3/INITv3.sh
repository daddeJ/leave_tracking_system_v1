#!/bin/bash

echo "Making Directory for Leave Management System..."

mkdir -p src
mkdir -p test
mkdir -p classes

mkdir -p src/com/lms/domain/entities
mdkir -p src/com/lms/domain/services
mdkir -p src/com/lms/domain/interfaces

mkdir -p src/com/lms/application/services

mkdir -p src/com/lms/infrastracture/services

mkdir -p src/com/lms/presentation/controllers

touch src/com/lms/LeaveManagementSystem.java