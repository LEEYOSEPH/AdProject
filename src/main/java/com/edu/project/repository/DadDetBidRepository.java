package com.edu.project.repository;

import com.edu.project.entity.DadDetBid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadDetBidRepository extends JpaRepository<DadDetBid,Long> {
}
