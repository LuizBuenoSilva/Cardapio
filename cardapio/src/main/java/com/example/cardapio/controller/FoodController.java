package com.example.cardapio.controller;

import com.example.cardapio.food.Food;
import com.example.cardapio.food.FoodRepository;
import com.example.cardapio.food.FoodRequestDTO;
import com.example.cardapio.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @PostMapping
    public ResponseEntity<String> saveFood(@RequestBody FoodRequestDTO data) {
        Food foodData = new Food(data);
        foodRepository.save(foodData);
        return ResponseEntity.ok("Registro criado com sucesso!");
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll(){

            List<FoodResponseDTO> foodList = foodRepository.findAll().stream()
                    .map(FoodResponseDTO::new)
                    .toList();
            return foodList;
    }

}
