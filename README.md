## Saga Pattern Implementation
Distributed transactions with eventual consistency using event-driven microservices.

This project demonstrates how to handle complex business transactions across multiple microservices using the Saga Pattern with asynchronous messaging.

## Problem

In a microservice architecture:

Each service owns its own database

There is no global transaction (no distributed ACID transaction)

If one service fails, the system can become inconsistent

Rolling back across services is complex

How do we guarantee data consistency without using distributed transactions?

### Solution

This project implements the Choreography-based Saga Pattern, where:

Each service performs a local transaction

Services communicate via message broker

If a step fails, a compensating transaction is triggered

The system guarantees eventual consistency

Each service reacts to events and publishes new events to continue the transaction flow.

## Features

##### Distributed transaction management

##### Event-driven communication

##### Asynchronous messaging

##### Local database per service

##### Compensating transactions

##### Order lifecycle management

##### Payment validation flow

##### Shipment processing

##### User notification system

##### Order state finalization (APPROVED / FAILED)

## Tech Stack

Java / Spring Boot

Message Broker (RabbitMQ or Kafka)

REST APIs

JPA / Hibernate

Relational Database (PostgreSQL or similar)

Docker (optional)

## Architecture
#### Saga Flow (Choreography Model)

Client ---- Order Service    ----  Payment Service ---- Shipment Service ---- Notification Service --> Order Service (Final State Update)
 

### Services Overview
#### Order Service

Receives client request

Creates order with status: PROCESSING

Publishes OrderCreated event

#### Payment Service

Consumes OrderCreated

Attempts payment processing

On success:

Saves status PROCESSING

Publishes PaymentProcessed

On failure:

Publishes compensating event

#### Shipment Service

Consumes PaymentProcessed

Attempts shipment process

On success:

Saves status PROCESSING

Publishes ShipmentProcessed

On failure:

Publishes compensating event

#### Notification Service

Consumes ShipmentProcessed

Sends asynchronous notification

Updates order state to APPROVED

Publishes OrderApproved

## How to Run
#### Clone the repository
git clone <repository-url>

#### Start the message broker

Example using Docker:

docker-compose up

#### Run each microservice

Start services individually:

Order Service

Payment Service

Shipment Service

Notification Service

#### Test the flow

Send a POST request:

POST /orders


The saga flow will start automatically via events.

#### Add architecture diagrams, broker dashboard screenshots, logs, and database states here to increase visual impact.

## Technical Decisions
🔹 Why Choreography over Orchestration?

Loosely coupled services

No central coordinator

Better scalability

Simpler event-driven model

🔹 Why Asynchronous Messaging?

Improves resilience

Enables eventual consistency

Avoids blocking calls

Better fault tolerance

🔹 Why Compensating Transactions?

Since distributed ACID transactions are not feasible in microservices, compensating actions guarantee business consistency when failures occur.

#### Next Steps

Implement Saga Orchestration version for comparison

Add Observability (OpenTelemetry + Zipkin)

Implement Retry & Dead Letter Queue

Add Circuit Breaker (Resilience4j)

Implement idempotency handling

Improve monitoring dashboard

Add integration tests for full saga flow
