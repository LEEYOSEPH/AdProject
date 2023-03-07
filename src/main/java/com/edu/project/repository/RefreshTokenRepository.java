package com.edu.project.repository;

import com.edu.project.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Long> {
}
