package org.example.bookstoremain;

import org.example.bookstoremain.model.Book;
import org.example.bookstoremain.repository.BookRepository;
import org.example.bookstoremain.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class BookServiceTest {
    private final BookRepository bookRepository = Mockito.mock(BookRepository.class);
    private final BookService bookService = new BookService(bookRepository);

    @Test
    public void testFindAllReturnsBooks() {
        Mockito.when(bookRepository.findAll()).thenReturn(Collections.singletonList(new Book()));
        assertThat(bookService.findAll()).isNotEmpty();
    }
}