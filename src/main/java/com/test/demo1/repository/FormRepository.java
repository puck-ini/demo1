package com.test.demo1.repository;

import com.test.demo1.entity.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form,Integer> {
}
