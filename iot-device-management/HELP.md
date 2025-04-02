# IoT Device Management API

This project is a Spring Boot-based API for managing IoT devices with MySQL database and Apache Kafka integration.

## Features
- Register, update, delete IoT devices
- Send commands to devices using Kafka
- Secure API with JWT authentication
- Store device data in MySQL
- Kafka consumer listens for device responses

## How to Run

### 1. Build the project
```bash
mvn clean package
