\# 🚗 Car Rental Vehicles System — Spring Boot REST API



\## Overview

Spring Boot REST API for managing a car rental system (Vehicles, Customers, Rentals).



\## Architecture

Controller → Service → Repository → PostgreSQL



\## Main Entities

\- Customer

\- Vehicle

\- Rental



\## REST Endpoints

\- /api/customers (GET, POST, PUT, DELETE)

\- /api/vehicles (GET, POST, PUT, DELETE)

\- /api/rentals (GET, POST, PUT, DELETE + return)



\## Design Patterns

\- Singleton (DB/config manager)

\- Factory (vehicle types creation)

\- Builder (rental object creation)



\## Other Requirements

Component Principles (REP, CCP, CRP), SOLID + OOP, Global Exception Handling.



\## Run

1\) Create DB: car\_rental\_db  

2\) Set application.properties  

3\) Run Application.java  

4\) Test in Postman



\## Author

Prepared by: Ibrahim Zhumagali



