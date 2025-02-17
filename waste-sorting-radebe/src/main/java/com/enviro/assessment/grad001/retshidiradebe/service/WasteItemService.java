package com.enviro.assessment.grad001.retshidiradebe.service;

import java.util.List;
import com.enviro.assessment.grad001.retshidiradebe.model.WasteItem;

public interface WasteItemService {
    List<WasteItem> getWasteItemsByCategoryName(String categoryName);
    WasteItem createWasteItem(WasteItem wasteItem);
    WasteItem getWasteItemById(Long id);
    List<WasteItem> getWasteItems();
    WasteItem updateWasteItemById(Long id, WasteItem wasteItem);
    void deleteWasteItemById(Long id);
}