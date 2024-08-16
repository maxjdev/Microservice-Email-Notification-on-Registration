<div align="center">

# Email Notification on Registration Microservice

![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![RabbitMQ](https://img.shields.io/badge/Rabbitmq-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

</div>

## Description

The project consists of two main microservices: one for user management (ms-user) and another for sending email notifications (ms-email). The goal is to create a solution that enables the automatic sending of welcome emails whenever a new user registers on the platform.

The user microservice (ms-user) manages the registration of new users and, after saving the information to the database, publishes a message via RabbitMQ to notify the email microservice (ms-email). Upon receiving this notification, the email microservice composes and sends a welcome email using Spring Mail. Additionally, the status of each sent email is recorded in the database, allowing for tracking of any potential failures.

This decoupled and event-driven architecture ensures that the system is scalable and easy to maintain. The separation of responsibilities between the microservices enhances modularity and facilitates the addition of new features in the future.

## Technologies and Project Dependencies

- **RabbitMQ:** Message broker for asynchronous communication.
- **Spring AMQP:** Integration of Spring with RabbitMQ for sending and receiving messages.
- **Spring Mail:** Integration with email servers for sending messages.
- **Spring Boot:** Framework for building microservices.
- **Spring Web:** For creating RESTful APIs.
- **Spring Devtools:** Additional tools for development, like automatic reload.
- **Spring Data JPA:** Abstraction for data access and JPA entity manipulation.
- **Spring Validation:** For input data validation.
- **Lombok:** Reduces boilerplate code like getters, setters, and constructors.
- **PostgreSQL:** Relational (SQL) database for data persistence.
- **Docker Compose:**

## Testing the Project

- With Docker and Docker Compose installed, navigate to the project directory, open your terminal, and run the following command:

```bash
docker-compose up -d 
```

- Add your <i>username</i> and <i>password</i> to the Spring-Mail configurations in the email microservice.

- Add your <i>address</i> to the RabbitMQ configurations in both microservices.

- Start each project using the following command:

```bash
mvn spring-boot:run
```

## Endpoint for testing

| route                                  | description                                                               |
|----------------------------------------|---------------------------------------------------------------------------|
| <kbd>POST /users/post/save</kbd> | Save a new user                                      |

#### JSON

<b>User:</b>
```json
{
  "name": "Jhon",
  "email": "jhon@domain.com"
}
```

## Contribution

- Fork this repository and submit your changes via pull requests.
- To report bugs or suggest improvements, open an issue on the project page.
