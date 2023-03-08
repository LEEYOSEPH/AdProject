package com.edu.project.repository;

import com.edu.project.entity.Adv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvRepository extends JpaRepository<Adv, String> {
}
