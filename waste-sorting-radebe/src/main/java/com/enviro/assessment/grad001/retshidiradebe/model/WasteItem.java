package com.enviro.assessment.grad001.retshidiradebe.model;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "WASTE_ITEM")
@ApiModel(description = "Waste item details")
public class WasteItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Auto generated waste item id")
    private Long id;

    @Column(name = "WASTE_ITEM_NAME")
    @ApiModelProperty(notes = "Waste item name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "id")
    @ApiModelProperty(notes = "Waste item category")
    private WasteCategory category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WasteCategory getCategory() {
        return category;
    }

    public void setCategory(WasteCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "WasteItem [id=" + id + ", name=" + name + ", category=" + category + "]";
    }
}