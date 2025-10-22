# **CI/CD Week 6 Lab**

In this lab I continued working on my Passenger Service from week 5. I updated this application to validate input and handle errors centrally using Lombok and @RestControllerAdvice

## **Features Added:**

- Validation Annotations in Passenger Model, using Jakarta Bean Validation.

- Validation of incoming data in Passenger Controller, using @Valid to trigger validation and keep controller methods thin.

- Created a Global Exception Handler with @ControllerAdvice to intercept validation errors and return custom error responses.

- Added ErrorPayload, a small DTO used by the handler to standardizze error responses.

- Created an exception handler for Duplicate Exceptions
