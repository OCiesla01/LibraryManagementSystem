CREATE TABLE roles (
    role_id INT PRIMARY KEY,
    role_name VARCHAR(255) NOT NULL
);

INSERT INTO roles
VALUES 
		(1, "CUSTOMER"), 
        (2, "LIBRARIAN"), 
        (3, "MANAGER"),
        (4, "ADMIN");

CREATE TABLE library_system_user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    role_id INT,
    registered_since DATE NOT NULL,
    total_books_loaned INT,
    books_on_loan INT,
    is_deleted BOOLEAN NOT NULL,
    FOREIGN KEY (role_id) REFERENCES roles (role_id)
)AUTO_INCREMENT=1;

CREATE TABLE awards_and_recognitions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    date_granted DATE
)AUTO_INCREMENT=1;

CREATE TABLE author (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    origin VARCHAR(255),
    date_of_birth DATE,
    date_of_death DATE,
    biography VARCHAR(255),
    total_books INT,
    is_deleted BOOLEAN NOT NULL
);

CREATE TABLE book (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    genre VARCHAR(255),
    date_published DATE NOT NULL,
    rating VARCHAR(255),
    no_of_pages INT,
    is_available BOOLEAN NOT NULL,
    row_num INT,
    shelf_num INT,
    no_of_copies_in_library INT,
    no_of_copies_loaned INT,
    is_deleted BOOLEAN
)AUTO_INCREMENT=1;

CREATE TABLE author_book (
    author_id INT,
    book_id INT,
    FOREIGN KEY (author_id) REFERENCES author (id),
    FOREIGN KEY (book_id) REFERENCES book (id),
    PRIMARY KEY (author_id, book_id)
);