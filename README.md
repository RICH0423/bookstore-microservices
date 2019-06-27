# Building Bookstore application with Microservices

### Spring Cloud Framework
- Spring Cloud provides: 
  - tools for developers to quickly build Microservices patterns in distributed systems
  - features and components that make your application compliant with [Twelve-Factor rules](https://12factor.net).
	  - Distributed/versioned configuration
	  - Service registration and discovery
	  - Routing
	  - Load balancing
	  - Circuit Breakers
	  - Distributed messaging

### Architecture Design for Bookstore

- Services 
  - api-gateway
  - service-discovery
  - config-server
  - order-service
  - inventory-service

<img src="./doc/bookstore-micorservices-architecture.png" alt="drawing" width="900" />

