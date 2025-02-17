package com.enviro.assessment.grad001.retshidiradebe.service;

import java.util.List;
import java.util.Optional;

import com.enviro.assessment.grad001.retshidiradebe.model.WasteItem;
import com.enviro.assessment.grad001.retshidiradebe.repository.WasteItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WasteItemServiceImpl implements WasteItemService {

    @Autowired
    private WasteItemRepository wasteItemRepository;

    @Override
    public WasteItem createWasteItem(WasteItem wasteItem) {
        return wasteItemRepository.save(wasteItem);
    }

    @Override
    public List<WasteItem> getWasteItemsByCategoryName(String categoryName) {
        return wasteItemRepository.findByCategoryName(categoryName);
    }
    @Override
    public WasteItem getWasteItemById(Long id) {
        Optional<WasteItem> wasteItem = wasteItemRepository.findById(id);
        return wasteItem.orElse(null);
    }

    @Override
    public List<WasteItem> getWasteItems() {
        return wasteItemRepository.findAll();
    }

    @Override
    public WasteItem updateWasteItemById(Long id, WasteItem wasteItem) {
        if (wasteItemRepository.existsById(id)) {
            wasteItem.setId(id);
            return wasteItemRepository.save(wasteItem);
        }
        return null;
    }

    @Override
    public void deleteWasteItemById(Long id) {
        wasteItemRepository.deleteById(id);
    }
}