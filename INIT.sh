#!/bin/bash

echo "Creating base directories..."
mkdir -p classes
mkdir -p src/main/java
mkdir -p src/main/resources

echo "Creating Java package structure..."
mkdir -p src/main/java/com/lts/domain/model
mkdir -p src/main/java/com/lts/domain/leaves
mkdir -p src/main/java/com/lts/domain/enums
mkdir -p src/main/java/com/lts/domain/ports

mkdir -p src/main/java/com/lts/application
mkdir -p src/main/java/com/lts/infrastructure
mkdir -p src/main/java/com/lts/interfaceadapters

echo "Folder structure created successfully!"
