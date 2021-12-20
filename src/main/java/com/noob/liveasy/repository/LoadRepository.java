package com.noob.liveasy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noob.liveasy.model.Load;

public interface LoadRepository extends JpaRepository<Load, Long> {
  //List<Tutorial> findByTitleContaining(String title);
  List<Load> findByshipperIdContaining (String shipperId);
}

