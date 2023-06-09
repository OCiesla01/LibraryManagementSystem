INSERT INTO author (first_name, last_name, origin, date_of_birth, date_of_death, biography, is_deleted)
VALUES
  ('John', 'Smith', 'United States', '1980-05-15', '2022-07-19', 'John Smith is a passionate writer with a love for historical fiction. His vivid storytelling transports readers to different eras, weaving together captivating narratives with meticulous attention to detail. John\'s works have garnered critical acclaim and a dedicated following of history enthusiasts.', false),
  ('Emma', 'Johnson', 'United Kingdom', '1992-09-21', NULL, 'Emma Johnson is a bestselling author known for his gripping thrillers that keep readers on the edge of their seats. With her unique ability to create complex characters and craft intricate plots, Emma\'s novels have become page-turners that leave readers guessing until the very end.', false),
  ('Michael', 'Williams', 'Australia', '1975-12-10', NULL, 'Michael Williams is a talented poet whose words have the power to evoke deep emotions. His heartfelt verses explore themes of love, loss, and the beauty of the natural world. Michael\'s poetry collection has touched the hearts of many and continues to inspire readers with its profound imagery and lyrical style.', false),
  ('Sophia', 'Brown', 'Canada', '1988-07-04', NULL, 'Sophia Brown is a renowned expert in the field of self-help and personal development. Through her books and motivational speeches, Sophia empowers individuals to overcome challenges, discover their true potential, and lead fulfilling lives. Her practical advice and insightful teachings have helped countless people find the path to personal growth and success.', false);
  
INSERT INTO award (name, author_id, date_granted)
VALUES
    ('Best Author of the Year', 3, '2021-06-20'),
    ('Literary Excellence Award', 1, '2022-02-12'),
    ('Outstanding Contribution Award', 2, '2020-09-05');
    
INSERT INTO book (title, genre, date_published, description, rating, no_of_pages, is_available, row_num, shelf_num, no_of_copies_in_library, no_of_copies_loaned, is_deleted)
VALUES
    ('The Great Garby', 'FICTION', '1925-04-10', '"1974" is a captivating fiction novel set against the backdrop of a turbulent era, exploring the lives of diverse characters entangled in a web of secrets and personal struggles, as they navigate the complexities of love, friendship, and societal changes.', 4.8, 218, false, 1, 2, 8, 2 ,false),
    ('To Kill a Mockingbirds', 'FICTION', '1960-07-11', 'In "The Great Garby," follow the enigmatic protagonist Jay Garby through the roaring 1920s, as he immerses himself in opulence, parties, and illusory dreams, while questioning the true nature of wealth, happiness, and the pursuit of the American Dream.', 4.7, 324, false, 1, 7, 9, 1, false),
    ('1974', 'FICTION', '1949-06-08', '"To Kill a Mockingbirds" is a poignant tale set in the deep South, exposing the ingrained prejudices of a small town as seen through the eyes of Scout, a young girl, who learns valuable lessons about justice, compassion, and the power of empathy.', 4.2, 328, false, 2, 4, 12, 3, false),
    ('Perfect Vendetta', 'ROMANCE', '1999-11-12', '"Perfect Vendetta" is an enthralling romance novel that follows the tumultuous love affair between two star-crossed lovers, torn apart by a tragic past and bound by an unbreakable connection. Set against a backdrop of sweeping landscapes and emotional turmoil, their journey of love, sacrifice, and redemption will leave readers captivated until the very last page.', 4.5, 190, false, 4, 2, 9, 1, false);

INSERT INTO library_system_user (first_name, last_name, email, role_id, registered_since, total_books_loaned, books_on_loan, is_deleted)
VALUES
    ('John', 'Smith', 'john.smith@example.com', 1, '2022-01-15', 5, 2, false),
    ('Jane', 'Doe', 'jane.doe@example.com', 2, '2022-03-20', 8, 3, false),
    ('David', 'Johnson', 'david.johnson@example.com', 3, '2022-05-10', 12, 1, false),
    ('Patrick', 'Nore', 'patrick.nore@example.com', 4, '2022-01-01', 0, 0, false);
    
INSERT INTO author_book (author_id, book_id)
VALUES
  (1, 1),
  (1, 2),
  (2, 2),
  (3, 3),
  (4, 4);
