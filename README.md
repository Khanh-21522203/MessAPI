# MessAPI
MessAPI is scalable Backend-as-a-Service (BaaS) platform for real-time messaging with WebSocket and RESTAPI support.

## Services Overview

- User Service
- Rate Limiter (Redis distributed lock)
- Message queue (Kafka)

## Tech Stack

The technologies used in this project are:

- Java
- Spring
- Kafka
- Redis
- WebSocket
- Docker
- MySQL

## Application Architecture
![image](https://github.com/user-attachments/assets/fabb747b-56a0-4c1a-821b-ea9311202993)

## How to Run

To get MeesBaaS up and running, follow these steps:
### Prerequisites

Before running the application, ensure you have the following installed:
- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)
- Gradle
- JDK 21
  
### 1. Clone the Repository

First, clone the GoLoad repository to your local machine:
```
git clone https://github.com/Khanh-21522203/MessBaaS
cd goLoad
```
### 2. Docker Setup
Run the application using Docker Compose. This will start the necessary services like MySQL, Kafka, Redis, and GoLoad:
```
docker-compose up -d
```
### 3. Run the application
```
./gradlew bootRun
```
