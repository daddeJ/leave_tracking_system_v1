#!/bin/bash

# Navigate to project root (optional: only if script is run from anywhere)
cd "$(dirname "$0")"

# Variables
SRC_DIR="src/main/java"
OUT_DIR="classes"
MAIN_CLASS="com.lts.Main"

# Step 1: Clean previous compiled files
echo "Cleaning old class files..."
rm -rf "$OUT_DIR"
mkdir -p "$OUT_DIR"

# Step 2: Compile all Java files
echo "Compiling Java source files..."
find "$SRC_DIR" -name "*.java" > sources.txt
javac -d "$OUT_DIR" @sources.txt

# Step 3: Check compilation success
if [ $? -ne 0 ]; then
    echo "Compilation failed."
    rm sources.txt
    exit 1
fi
rm sources.txt

# Step 4: Run the main class
echo "Running application..."
java -cp "$OUT_DIR" "$MAIN_CLASS"
