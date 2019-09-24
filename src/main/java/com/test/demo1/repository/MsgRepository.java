package com.test.demo1.repository;

import com.test.demo1.entity.Msg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MsgRepository extends JpaRepository<Msg, Integer> {

    List<Msg> findByUserId(Integer id);

    List<Msg> findByTitle(String title);

    List<Msg> findByContent(String content);

    List<Msg> findByUsername(String username);
}
