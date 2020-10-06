package com.navercorp.bookserver;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Objects;

@RestController
@RequestMapping("/api/books")
@Api(value="Book CRUD", description="책 CRUD")
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

    @ApiOperation("책 조회")
    @GetMapping("{id}")
    Book read(@PathVariable Integer id) {
        Book book = service.findById(id);
        // null 체크를 해주고 null 아닐시 그대로 반환, null 일 경우 NPE 발생
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
