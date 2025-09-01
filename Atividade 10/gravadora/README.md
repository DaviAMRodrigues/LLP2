# Gravadora App

## Overview
The Gravadora App is a Java application that connects to a MySQL database to retrieve and display songs from the "musica" table. This project demonstrates how to interact with a database using JDBC and follows a structured approach with separate layers for database connection, data access, and model representation.

## Project Structure
```
gravadora-app
├── src
│   ├── Main.java               # Entry point of the application
│   ├── db
│   │   └── DatabaseConnection.java  # Manages database connections
│   ├── dao
│   │   └── MusicaDAO.java      # Data access object for music data
│   └── model
│       └── Musica.java         # Model representing a song
├── lib                          # Directory for external libraries
├── .gitignore                   # Specifies files to ignore in Git
└── README.md                    # Documentation for the project
```

## Setup Instructions

1. **Database Setup**:
   - Use the provided SQL backup (`LP2-10-bd-Gravadora.sql`) to create the "Gravadora" database and the necessary tables.
   - Import the SQL file into your MySQL database using a tool like phpMyAdmin or MySQL Workbench.

2. **JDBC Driver**:
   - Download the MySQL JDBC driver and place it in the `lib` directory.

3. **Build and Run**:
   - Compile the Java files in the `src` directory.
   - Run the `Main.java` file to start the application. It will connect to the database, retrieve the songs, and display them on the screen.

## Usage
- Upon running the application, it will display a list of songs retrieved from the "musica" table in the console.

## Contributing
Feel free to fork the repository and submit pull requests for any improvements or features you would like to add.