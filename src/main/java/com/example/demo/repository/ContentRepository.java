package com.example.demo.repository;

import com.example.demo.entity.ContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<ContentEntity, Integer> {

    ContentEntity findById(int id);
}
