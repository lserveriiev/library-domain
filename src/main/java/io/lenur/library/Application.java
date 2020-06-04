package io.lenur.library;

import io.lenur.library.domain.Author;
import io.lenur.library.domain.AuthorGender;
import io.lenur.library.service.AuthorService;
import io.lenur.di.Dependency;
import io.lenur.di.PackageContext;

import java.time.LocalDate;

public class Application {
    private static final PackageContext packageContext = Dependency
            .init("io.lenur.library");

    private static final AuthorService authorService = (AuthorService) packageContext
            .getInstance(AuthorService.class);

    public static void main(String[] args) {
        Author author = new Author();
        author.setName("Conan Doyle");
        author.setBirthday(LocalDate.parse("1859-05-22"));
        author.setGender(AuthorGender.MALE);
        authorService.create(author);
    }
}
