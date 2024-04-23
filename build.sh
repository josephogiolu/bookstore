#!/bin/bash

# Step 1: Build Maven project
echo "Building Maven project..."
mvn clean package

# Step 3: Build Docker image
echo "Building Docker image..."
docker build -t bookstore-service:latest .