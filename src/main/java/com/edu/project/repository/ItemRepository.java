package com.edu.project.repository;

import com.edu.project.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long>{

    List<Item> findByItemNameContaining(String itemName);

}
