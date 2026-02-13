package com.example.apiproject.controller;

import com.example.apiproject.model.Item;
import com.example.apiproject.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // ===============================
    // 🌐 UI PART
    // ===============================

    // Home page
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("item", new Item());
        model.addAttribute("items", itemService.getAllItems());
        return "index";
    }

    // Add item from UI
    @PostMapping("/add")
    public String addItemFromUI(@Valid @ModelAttribute Item item,
                                BindingResult result,
                                Model model) {

        if (result.hasErrors()) {
            model.addAttribute("items", itemService.getAllItems());
            return "index";
        }

        itemService.addItem(item);
        return "redirect:/";
    }

    // View single item in UI
    @GetMapping("/view/{id}")
    public String viewItem(@PathVariable Long id, Model model) {

        itemService.getItemById(id).ifPresentOrElse(
                item -> model.addAttribute("item", item),
                () -> model.addAttribute("error", "Item not found")
        );

        return "view-item";
    }

@GetMapping("/search")
public String searchItem(@RequestParam Long id, Model model) {

    itemService.getItemById(id).ifPresentOrElse(
            item -> model.addAttribute("selectedItem", item),
            () -> model.addAttribute("error", "Item not found")
    );

    model.addAttribute("items", itemService.getAllItems());
    model.addAttribute("item", new Item());

    return "index";
}
    // ===============================
    // 🔗 REST API PART
    // ===============================

    // Add new item (API)
    @PostMapping("/api/items")
    @ResponseBody
    public ResponseEntity<Item> addItem(@Valid @RequestBody Item item) {
        return ResponseEntity.ok(itemService.addItem(item));
    }

    // Get item by ID (API)
    @GetMapping("/api/items/{id}")
    @ResponseBody
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        return itemService.getItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}