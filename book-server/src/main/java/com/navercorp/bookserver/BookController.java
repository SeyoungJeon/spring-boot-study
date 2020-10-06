package com.navercorp.bookserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Objects;

@Controller
@RequestMapping("/api/books")
public class BookController {
    private final BookService service;

    @Autowired
    public BookController(BookService service){
        this.service = service;
    }

    @GetMapping
    Collection<Book> readList(){
        return service.findAll();
    }

    @GetMapping("{id}")
    Book read(@PathVariable Integer id) {
        Book book = service.findById(id);
        Objects.requireNonNull(book, "cannot find book with id: " + id);
        return book;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Book create(@RequestBody Book book){
        return service.create(book);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@PathVariable Integer id, @RequestBody Book book){
        book.setId(id);
        service.update(book);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
