ALTER TABLE books DROP INDEX genre;

ALTER TABLE books ADD CONSTRAINT unique_isbn UNIQUE (isbn);
