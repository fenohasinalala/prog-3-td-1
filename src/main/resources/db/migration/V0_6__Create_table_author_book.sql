
create table author_book
(
    id     integer
        constraint author_book_pk primary key ,
    author_id        integer                  not null
        constraint author_book_author_id_fk references author (id),
    book_id              integer                  not null
        constraint author_book_book_id_fk references book (id)
);