# MyFitness Scheduler

A Java Swing desktop application for planning workouts, built with NetBeans and PostgreSQL.

## Features
- Register, Login and Forget Password
- Guest home page; Workouts, Schedule and Profile need login
- Generate a workout by category (random exercises) and save it by email
- Schedule screen: view current and previous workouts by date
- Update Profile (user and admin)
- Admin: view/edit/delete exercises, manage workouts, add new workouts, verify users

## Tech Stack
Java (Swing), NetBeans 8.2, PostgreSQL, pgAdmin 4, JDBC

## Setup
1. Create a PostgreSQL database named `myfitness_scheduler`
2. Import the data: `psql -U postgres -d myfitness_scheduler -f database.sql`
3. Open the project in NetBeans
4. In `ConnectionProviderClass.java` set your own PostgreSQL password
5. Run the project (main class: `Main_Page`)

## Author
Vishal Singh

