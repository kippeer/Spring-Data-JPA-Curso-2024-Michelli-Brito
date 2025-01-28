package com.bookstore.jpa.repositories;

import com.bookstore.jpa.models.BookModel;
import com.bookstore.jpa.models.PublisherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PublisherRepository extends JpaRepository<PublisherModel, UUID> {

    BookModel findBookModelByTitle(String title);

    @Query(value= " SELECT * FROM tb_book WHERE publisher_id = :id", nativeQuery = true)
    List<BookModel> findBooksPublisherId(@Param("id")UUID id);
}
