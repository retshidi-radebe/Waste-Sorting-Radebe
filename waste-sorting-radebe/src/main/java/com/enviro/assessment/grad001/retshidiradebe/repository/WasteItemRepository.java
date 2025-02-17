package com.enviro.assessment.grad001.retshidiradebe.repository;

import com.enviro.assessment.grad001.retshidiradebe.model.WasteItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WasteItemRepository extends JpaRepository<WasteItem, Long> {
    List<WasteItem> findByCategoryName(String categoryName);
}