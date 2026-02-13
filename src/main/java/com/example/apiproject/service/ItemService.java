package com.example.apiproject.service;

import com.example.apiproject.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service class responsible for managing item operations.
 * Uses in-memory storage (ArrayList) as required in the assignment.
 */
@Service
public class ItemService {

    // In-memory data store
    private final List<Item> items = new ArrayList<>();

    // Auto-increment ID counter
    private Long nextId = 1L;

    /**
     * Adds a new item to the list.
     * Automatically assigns an ID.
     */
    public Item addItem(Item item) {
        item.setId(nextId++);
        items.add(item);
        return item;
    }

    /**
     * Returns all items in the system.
     */
    public List<Item> getAllItems() {
        return items;
    }

    /**
     * Returns a single item by ID.
     */
    public Optional<Item> getItemById(Long id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }
}