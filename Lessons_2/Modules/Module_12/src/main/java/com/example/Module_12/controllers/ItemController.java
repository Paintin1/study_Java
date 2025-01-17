package com.example.Module_12.controllers;

import com.example.Module_12.models.Item;
import com.example.Module_12.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/item/add")
    public String add() {
        return "add-item";
    }

    @GetMapping("/item/{id}")
    public String showItem(@PathVariable(value = "id") long id, Model model) {
        Item item = itemRepository.findById(id).orElse(new Item());
        model.addAttribute("item", item);

        return "show-item";
    }

    @GetMapping("/item/{id}/update")
    public String update(@PathVariable(value = "id") long id, Model model) {
        Item item = itemRepository.findById(id).orElse(new Item());
        model.addAttribute("item", item);

        return "item-update";
    }

    @PostMapping("/item/{id}/update")
    public String updateItem(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String image, @RequestParam String price, @RequestParam String info) {
        Item item = itemRepository.findById(id).orElse(new Item());
        item.setTitle(title);
        item.setImage(image);
        item.setInfo(info);
        item.setPrice(Short.parseShort(price));

        itemRepository.save(item);
        return "redirect:/item/" + id;
    }

    @PostMapping("/item/add")
    public String store(@RequestParam String title,@RequestParam String image, @RequestParam String price, @RequestParam String info) {
        Item item = new Item(title, info, image, Short.parseShort(price));

        itemRepository.save(item);
        return "redirect:/";
    }

    @PostMapping("/item/{id}/delete")
    public String itemDelete(@PathVariable(value = "id") long id) {
        Item item = itemRepository.findById(id).orElse(new Item());
        itemRepository.delete(item);
        return "redirect:/";
    }
}
