INSERT INTO author (first_name, last_name, origin, date_of_birth, date_of_death, total_books, is_deleted)
VALUES
  ('John', 'Smith', 'United States', '1980-05-15', '2022-07-19', 5, false),
  ('Emma', 'Johnson', 'United Kingdom', '1992-09-21', NULL, 3, false),
  ('Michael', 'Williams', 'Australia', '1975-12-10', NULL, 8, false),
  ('Sophia', 'Brown', 'Canada', '1988-07-04', NULL, 6, false);
  
INSERT INTO award_and_recognition (name, author_id, date_granted)
VALUES
    ('Best Author of the Year', 3, '2021-06-20'),
    ('Literary Excellence Award', 1, '2022-02-12'),
    ('Outstanding Contribution Award', 2, '2020-09-05');
    
INSERT INTO book (title, genre, date_published, description, rating, no_of_pages, is_available, is_deleted)
VALUES
    ('The Great Gatsby', 'FICTION', '1925-04-10', 'testdesc1', 'FOUR', 218, true, false),
    ('To Kill a Mockingbird', 'FICTION', '1960-07-11', 'testdesc2', 'FIVE', 324, true, false),
    ('1984', 'FICTION', '1949-06-08', 'testdesc3', 'FIVE', 328, true, false);

INSERT INTO library_system_user (first_name, last_name, email, role_id, registered_since, total_books_loaned, books_on_loan, is_deleted)
VALUES
    ('John', 'Smith', 'john.smith@example.com', 1, '2022-01-15', 5, 2, false),
    ('Jane', 'Doe', 'jane.doe@example.com', 2, '2022-03-20', 8, 3, false),
    ('David', 'Johnson', 'david.johnson@example.com', 3, '2022-05-10', 12, 1, false);
    
INSERT INTO author_book (author_id, book_id)
VALUES
  (1, 1),
  (1, 2),
  (2, 2),
  (3, 3);
