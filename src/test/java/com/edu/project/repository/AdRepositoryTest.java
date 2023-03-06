package com.edu.project.repository;

import com.edu.project.entity.AD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AdRepositoryTest {
    @Autowired
    AdRepository adRepository;

    void test() {
        adRepository.save(new AD(1L, 1L));


    }
}