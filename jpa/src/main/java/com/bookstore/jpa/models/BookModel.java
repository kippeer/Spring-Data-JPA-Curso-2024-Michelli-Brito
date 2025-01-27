package com.bookstore.jpa.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_BOOK")
@Getter
@Setter
public class BookModel implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false,unique = true)
    private String title;

    @ManyToOne
    @JoinColumn( name = "publisher_id")
    pivate PublisherModel publisher;

}
