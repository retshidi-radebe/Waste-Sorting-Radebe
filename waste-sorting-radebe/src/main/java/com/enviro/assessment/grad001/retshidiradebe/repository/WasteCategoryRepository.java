package com.enviro.assessment.grad001.retshidiradebe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enviro.assessment.grad001.retshidiradebe.model.WasteCategory;

@Repository
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {
}