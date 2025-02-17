package com.enviro.assessment.grad001.retshidiradebe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "WASTE_CATEGORY")
@ApiModel(description = "Waste category details")
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Auto generated waste category id")
    private Long id;

    @Column(name = "WASTE_CATEGORY_NAME")
    @ApiModelProperty(notes = "Waste category name")
    private String name;

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

    @Override
    public String toString() {
        return "WasteCategory [id=" + id + ", name=" + name + "]";
    }
}