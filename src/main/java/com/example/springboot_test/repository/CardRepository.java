package com.example.springboot_test.repository;

import com.example.springboot_test.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
