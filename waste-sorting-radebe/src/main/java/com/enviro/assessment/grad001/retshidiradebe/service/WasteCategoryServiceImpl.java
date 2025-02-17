package com.enviro.assessment.grad001.retshidiradebe.service;

import java.util.List;
import java.util.Optional;

import com.enviro.assessment.grad001.retshidiradebe.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.retshidiradebe.model.WasteCategory;

@Service
public class WasteCategoryServiceImpl implements WasteCategoryService {

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    @Override
    public WasteCategory createWasteCategory(WasteCategory wasteCategory) {
        return wasteCategoryRepository.save(wasteCategory);
    }

    @Override
    public WasteCategory getWasteCategoryById(Long id) {
        Optional<WasteCategory> wasteCategory = wasteCategoryRepository.findById(id);
        return wasteCategory.orElse(null);
    }

    @Override
    public List<WasteCategory> getWasteCategories() {
        return wasteCategoryRepository.findAll();
    }

    @Override
    public WasteCategory updateWasteCategoryById(Long id, WasteCategory wasteCategory) {
        if (wasteCategoryRepository.existsById(id)) {
            wasteCategory.setId(id);
            return wasteCategoryRepository.save(wasteCategory);
        }
        return null;
    }

    @Override
    public void deleteWasteCategoryById(Long id) {
        wasteCategoryRepository.deleteById(id);
    }
}