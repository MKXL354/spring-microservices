package org.example.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Mehdi Kamali
 * @since 14/07/2025
 */
@Entity
@Table(name = "ORGANIZATION")
@Getter
@Setter
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "BIGINT", unique = true)
    private Long id;

    @Column(name = "NAME", columnDefinition = "VARCHAR(100)", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", columnDefinition = "VARCHAR(500)")
    private String description;
}
