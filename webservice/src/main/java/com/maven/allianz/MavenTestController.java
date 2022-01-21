package com.maven.allianz;

import com.maven.allianz.dtos.ModelDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MavenTestController {

  @Autowired
  private ModelRepository modelRepository;


  @GetMapping("/models")
  public ResponseEntity<List<ModelDto>> getModels() {
    List<Model> models = modelRepository.getModels();
    return ResponseEntity.status(HttpStatus.OK).body(models.stream().map(ModelDto::from).collect(Collectors.toList()));
  }

  @PostMapping("/models")
  public ResponseEntity<String> addNewModel(@RequestBody ModelDto modelDto) {
    modelRepository.addModel(ModelDto.to(modelDto));
    return ResponseEntity.status(HttpStatus.OK).build();

  }

  @PutMapping("/models/{id}")
  public ResponseEntity<String> updateModel(@RequestBody ModelDto modelDto, @PathVariable Long id) {

    modelRepository.updateModel(ModelDto.to(modelDto), id);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @DeleteMapping("/models")
  public ResponseEntity<String> deleteModel(@RequestBody ModelDto modelDto) {
    modelRepository.deleteModel(ModelDto.to(modelDto));
    return ResponseEntity.status(HttpStatus.OK).build();
  }

}
