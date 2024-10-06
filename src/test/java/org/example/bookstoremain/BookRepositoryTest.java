package org.example.bookstoremain;

import org.example.bookstoremain.model.Book;
import org.example.bookstoremain.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testSaveBook() {
        Book book = new Book();
        book.setTitle("Test Title");
        book.setAuthor("Test Author");
        book.setIsbn("123456789");
        book.setPrice(9.99);

        Book savedBook = bookRepository.save(book);
        assertNotNull(savedBook.getId());
    }
}
