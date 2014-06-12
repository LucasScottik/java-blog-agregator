package com.godzevych.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.godzevych.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
