package com.test.demo1.repository;

import com.test.demo1.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristRepository extends JpaRepository<Tourist,Integer> {
}
