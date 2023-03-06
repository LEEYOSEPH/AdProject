package com.edu.project.repository;

import com.edu.project.entity.AD;
import com.edu.project.response.ItemIdResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdRepository extends JpaRepository<AD, Long> {

    ItemIdResponseDto findByItemId(Long itemId);
}
