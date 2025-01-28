package com.bookstore.jpa.services;

import com.bookstore.jpa.models.BookModel;
import com.bookstore.jpa.repositories.AuthorRepository;
import com.bookstore.jpa.repositories.BookRepository;
import com.bookstore.jpa.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BookService(BookRepository bookRepository,
                       AuthorRepository authorRepository,
                       PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    // Salvar um novo livro
    public BookModel saveBook(BookModel bookModel) {
        // Regras de validação, se necessário (ex.: validar se autores e publisher existem)
        return bookRepository.save(bookModel);
    }

    // Listar todos os livros
    public List<BookModel> listAllBooks() {
        return bookRepository.findAll();
    }

    // Deletar livro por ID
    public void deleteBook(UUID id) {
        Optional<BookModel> book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.deleteById(id);
        } else {
            throw new RuntimeException("Book not found with id: " + id);
        }
    }
}
