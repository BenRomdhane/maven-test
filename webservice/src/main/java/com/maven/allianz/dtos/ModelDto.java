package com.maven.allianz.dtos;

import com.maven.allianz.Model;
import java.io.Serializable;
import java.time.LocalDate;

public class ModelDto implements Serializable {

  private Long id;

  private String label;

  private LocalDate date;


  public static ModelDto from(Model model) {
    if(model == null) {
      return null;
    }

    ModelDto modelDto = new ModelDto();
    modelDto.setId(model.getId());
    modelDto.setLabel(model.getLabel());
    modelDto.setDate(model.getDate());

    return modelDto;
  }

  public static Model to(ModelDto modelDto) {
    if (modelDto == null) {
      return null;
    }

    return new Model(modelDto.getId(), modelDto.getLabel(), modelDto.getDate());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }
}
