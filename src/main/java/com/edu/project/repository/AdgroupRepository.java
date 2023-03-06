package com.edu.project.repository;

import com.edu.project.entity.Adgroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdgroupRepository extends JpaRepository<Adgroup,Long> {

}
