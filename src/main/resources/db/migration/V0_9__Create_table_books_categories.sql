create table books_categories
(
    book_id     INTEGER     not null
       constraint books_categories_book_id_fk references book(id),
    category_id INTEGER     not null
       constraint books_categories_category_id_fk references category(id)
);