-- Create the quiz database
CREATE DATABASE IF NOT EXISTS quiz_app;

-- Use the database
USE quiz_app;

-- Create the questions table
CREATE TABLE IF NOT EXISTS questions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    question TEXT NOT NULL,
    option1 VARCHAR(255) NOT NULL,
    option2 VARCHAR(255) NOT NULL,
    option3 VARCHAR(255) NOT NULL,
    option4 VARCHAR(255) NOT NULL,
    correct_index INT NOT NULL -- 0-based index (0 to 3)
);

-- Insert sample questions
INSERT INTO questions (question, option1, option2, option3, option4, correct_index) VALUES
("What is the size of int in Java?", "4 bytes", "8 bytes", "2 bytes", "1 byte", 0),
("Which company created Java?", "Microsoft", "Apple", "Sun Microsystems", "Google", 2),
("Which keyword is used to inherit a class in Java?", "this", "super", "extends", "import", 2),
("What is JVM?", "Java Virtual Machine", "Java Volatile Method", "Java Variable Manager", "None", 0),
("Which method is the entry point in Java?", "main()", "start()", "init()", "run()", 0);
