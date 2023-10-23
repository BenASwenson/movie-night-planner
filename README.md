# Movie Night planner

## Database
The Movie Night Planner database serves as a key component for the movie night planner application. Its primary purpose is to manage user accounts. The user account functionality allows users to register, log in, and access specific features of the application. 

### Tables

**1. Users**:
- Table Name: Users
- Columns:
    - ID (Primary Key)
    - First Name
    - Last Name
    - Username (email)
    - Password (hashed)
- Purpose: This table stores user account information, including unique user IDs, usernames, email addresses, and securely hashed passwords. User accounts are created upon registration and used for authentication and granting access to certain features.

### Configuration
The application is configured to connect to the Movie Night Planner database using MySQL driver and the appropriate connection strings. This allows the application to communicate with the MySQL database.

**Connection Information**
```yml
spring.datasource.url=jdbc:mysql://localhost:3306/movie_night_planner
spring.datasource.username=[Database Username]
spring.datasource.password=[Database Password]
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```


The URL indicates the database server's location and port, the username and password provide authentication, and the driver class defines the MySQL database driver used for communication.

