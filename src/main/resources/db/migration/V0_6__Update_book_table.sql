ALTER TABLE book
    DROP COLUMN author;
ALTER TABLE book
    ADD COLUMN author_id integer
        constraint book_author_id_fk references author (id);

UPDATE book
SET author_id = 1
    WHERE id=1;
UPDATE book
SET author_id = 2
    WHERE id=2;
UPDATE book
SET author_id = 3
    WHERE id=3;
UPDATE book
SET author_id = 4
    WHERE id=4;
UPDATE book
SET author_id = 5
    WHERE id=5;
UPDATE book
SET author_id = 6
    WHERE id=6;
UPDATE book
SET author_id = 7
    WHERE id=7;
UPDATE book
SET author_id = 8
    WHERE id=8;