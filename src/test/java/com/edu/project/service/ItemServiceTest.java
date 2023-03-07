package com.edu.project.service;

import com.edu.project.entity.Item;
import com.edu.project.repository.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    private ItemService itemService;
    @Autowired
    ItemRepository itemRepository;

}