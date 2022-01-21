package com.maven.allianz;

import com.maven.allianz.dtos.ModelDto;
import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

public class ModelDtoTest {


  @Test
  public void should_return_modelDto_when_model_is_not_null() {
    //Given
    Model model = new Model(1L, "Model1", LocalDate.now());

    //When
    ModelDto result = ModelDto.from(model);

    //Then
    Assert.assertEquals(result.getId(), model.getId());
    Assert.assertEquals(result.getLabel(), model.getLabel());
    Assert.assertEquals(result.getDate(), model.getDate());

  }

  @Test
  public void should_return_null_when_model_is_null() {
    //When
    ModelDto result = ModelDto.from(null);

    //Then
    Assert.assertNull(result);
  }

  @Test
  public void should_return_model_when_modelDto_is_not_null() {
    //Given
    ModelDto modelDto = new ModelDto();
    modelDto.setId(1L);
    modelDto.setLabel("ModelDto");
    modelDto.setDate(LocalDate.now());

    //When
    Model result = ModelDto.to(modelDto);

    //Then
    Assert.assertEquals(result.getId(), modelDto.getId());
    Assert.assertEquals(result.getLabel(), modelDto.getLabel());
    Assert.assertEquals(result.getDate(), modelDto.getDate());

  }

  @Test
  public void should_return_null_when_modelDto_is_null() {
    //When
    Model result = ModelDto.to(null);

    //Then
    Assert.assertNull(result);
  }

}
