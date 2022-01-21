package com.maven.allianz;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ModelRepositoryTest {

  @InjectMocks
  private ModelRepository modelRepository;

  @Mock
  private Model model;

  @Mock
  private List<Model> models;


  @Test
  public void should_return_all_models() {
    //Given

    //When
    List<Model> result = modelRepository.getModels();

    //Then
    Assert.assertEquals(result.size(), 7);

  }

  @Test
  public void should_add_new_model() {
    //Given

    //When
    modelRepository.addModel(model);

    //Then
    verify(models, times(1)).add(any(Model.class));

  }

  @Test
  public void should_update_model_when_find_model_by_id_is_null() {
    //Given

    //When
    modelRepository.updateModel(model, 1L);

    //Then
    verify(models, times(1)).add(any(Model.class));

  }

  @Test
  public void should_update_model_when_find_model_by_id_is_not_null() {
    //Given
    List<Model> list = new ArrayList<>();
    Model modelTest = new Model(1L, "test", LocalDate.now());
    list.add(modelTest);

    //When
    Mockito.when(models.stream()).thenReturn(list.stream());

    modelRepository.updateModel(model, 1L);

    //Then
    Assert.assertEquals(model.getId(), modelTest.getId());
    Assert.assertEquals(model.getLabel(), modelTest.getLabel());
    Assert.assertEquals(model.getDate(), modelTest.getDate());


  }

  @Test
  public void should_delete_model() {
    //Given

    //When
    modelRepository.deleteModel(model);

    //Then
    verify(models, times(1)).remove(any(Model.class));

  }


}
