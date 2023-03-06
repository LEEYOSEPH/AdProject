package com.edu.project.repository;

import com.edu.project.entity.DadDet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadDetRepository extends JpaRepository<DadDet,Long> {
}
