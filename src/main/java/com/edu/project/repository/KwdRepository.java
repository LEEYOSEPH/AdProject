package com.edu.project.repository;

import com.edu.project.entity.Kwd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KwdRepository extends JpaRepository<Kwd,Long> {

    Optional<Kwd> findByKwdName(String kwdName);
}
