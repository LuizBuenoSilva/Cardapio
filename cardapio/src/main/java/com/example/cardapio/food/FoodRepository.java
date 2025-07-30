package com.example.cardapio.food;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {

    // Additional query methods can be defined here if needed
}
