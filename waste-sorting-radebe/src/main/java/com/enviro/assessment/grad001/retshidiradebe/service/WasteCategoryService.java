package com.enviro.assessment.grad001.retshidiradebe.service;

import java.util.List;
import com.enviro.assessment.grad001.retshidiradebe.model.WasteCategory;

public interface WasteCategoryService {

    WasteCategory createWasteCategory(WasteCategory wasteCategory);
    WasteCategory getWasteCategoryById(Long id);
    List<WasteCategory> getWasteCategories();
    WasteCategory updateWasteCategoryById(Long id, WasteCategory wasteCategory);
    void deleteWasteCategoryById(Long id);
}