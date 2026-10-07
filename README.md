# HostelPulse

A Java + MySQL hostel food review and analytics system that allows students to submit meal feedback and provides simple analytics based on their ratings.

## Features

* Student food reviews using registration number
* Separate reviews for:

  * Breakfast
  * Lunch
  * Dinner
* Rating system from 1 to 5
* Review comments
* Date-based review storage
* Average rating calculation
* Total rating count
* Identifies the best and worst rated meal
* MySQL database integration using JDBC

## Tech Stack

* **Java**
* **MySQL**
* **JDBC**
* **VS Code**
* **Git & GitHub**

## Database Structure

The project uses three separate tables:

```text
breakfast_reviews
lunch_reviews
dinner_reviews
```

Each table stores:

```text
reg_no
rating
review
review_date
```

A composite primary key of `reg_no` and `review_date` prevents the same student from submitting multiple reviews for the same meal on the same day.

## How It Works

1. The student selects a meal.
2. The student enters their registration number.
3. A rating between 1 and 5 is entered.
4. The student provides a review.
5. The review is stored in MySQL.
6. The analytics section calculates average ratings for each meal.
7. The system identifies the best and worst rated meals.

## Project Structure

```text
HostelManager
├── lib
│   └── mysql-connector-j-26.7.0.jar
├── src
│   ├── DatabaseConnection.java
│   └── Main.java
├── .gitignore
└── README.md
```

## Future Improvements

* Student login system
* Admin dashboard
* Graphical analytics
* Monthly food quality reports
* Review filtering and search
* Web-based interface
* Automated alerts for low-rated meals

## Author

**Prajan A**

B.Tech Artificial Intelligence & Data Science
