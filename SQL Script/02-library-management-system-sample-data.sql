INSERT INTO author (first_name, last_name, origin, date_of_birth, date_of_death, total_books, is_deleted)
VALUES
    ('John', 'Doe', 'USA', '1970-05-15', NULL, 10, false),
    ('Jane', 'Smith', 'UK', '1985-10-21', '2022-03-10', 20, false),
    ('Robert', 'Johnson', 'Australia', '1968-12-03', NULL, 15, false);

INSERT INTO award_and_recognition (name, author_id, date_granted)
VALUES
    ('Best Author of the Year', 3, '2021-06-20'),
    ('Literary Excellence Award', 1, '2022-02-12'),
    ('Outstanding Contribution Award', 2, '2020-09-05');
    
INSERT INTO book (title, genre, date_published, rating, no_of_pages, is_available, is_deleted)
VALUES
    ('The Great Gatsby', 'Fiction', '1925-04-10', '4.5', 218, true, false),
    ('To Kill a Mockingbird', 'Fiction', '1960-07-11', '4.8', 324, true, false),
    ('1984', 'Fiction', '1949-06-08', '4.7', 328, true, false);

INSERT INTO library_system_user (first_name, last_name, email, role_id, registered_since, total_books_loaned, books_on_loan, is_deleted)
VALUES
    ('John', 'Smith', 'john.smith@example.com', 1, '2022-01-15', 5, 2, false),
    ('Jane', 'Doe', 'jane.doe@example.com', 2, '2022-03-20', 8, 3, false),
    ('David', 'Johnson', 'david.johnson@example.com', 3, '2022-05-10', 12, 1, false);
