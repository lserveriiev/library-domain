package io.lenur.library;

import io.lenur.library.domain.Author;
import io.lenur.library.domain.AuthorGender;
import io.lenur.library.domain.Book;
import io.lenur.library.domain.Category;
import io.lenur.library.service.AuthorService;
import io.lenur.di.Dependency;
import io.lenur.di.PackageContext;
import io.lenur.library.service.BookService;
import io.lenur.library.service.CategoryService;

import java.time.LocalDate;

public class Application {
    private static final PackageContext packageContext = Dependency
            .init("io.lenur.library");

    private static final AuthorService authorService = (AuthorService) packageContext
            .getInstance(AuthorService.class);

    private static final CategoryService categoryService = (CategoryService) packageContext
            .getInstance(CategoryService.class);

    private static final BookService bookService = (BookService) packageContext
            .getInstance(BookService.class);

    public static void main(String[] args) {
        Book book = new Book();
        book.setName("The hound of the baskervilles");
        book.setCreated(LocalDate.parse("1902-04-01"));
        bookService.create(book);

        Category category = new Category();
        category.setName("Detective");
        category.addBook(book);
        categoryService.create(category);

        Author author = new Author();
        author.setName("Conan Doyle");
        author.setBirthday(LocalDate.parse("1859-05-22"));
        author.setGender(AuthorGender.MALE);
        author.addBook(book);
        authorService.create(author);
    }
}
