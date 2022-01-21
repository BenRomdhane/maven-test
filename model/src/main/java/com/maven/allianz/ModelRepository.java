package com.maven.allianz;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

@Repository
@Scope(value="session", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class ModelRepository {

  private static final Logger logger = LoggerFactory.getLogger(ModelRepository.class.getName());


  private List<Model> models = new ArrayList<>();

  public List<Model> getModels() {
    try {
      ClassLoader classLoader = getClass().getClassLoader();
      File file = new File(classLoader.getResource(("model.json")).getFile());

      JSONParser jsonParser = new JSONParser();

      String json = jsonParser.parse(new FileReader(file)).toString();
      ObjectMapper mapper = new ObjectMapper();

      models = new LinkedList<>(Arrays.asList(mapper.readValue(json, Model[].class)));

    } catch (IOException | ParseException e) {
      logger.error("A problem occurred while reading json file", e);
    }
    return models;
  }

  public void addModel(Model model) {
    models.add(model);
  }

  public void updateModel(Model model, Long id) {
    Model modelById = models.stream().filter(model1 -> model1.getId().equals(id)).findFirst().orElse(null);
    if(modelById != null) {
      modelById.setId(model.getId());
      modelById.setLabel(model.getLabel());
      modelById.setDate(model.getDate());
    } else {
      Model newModel = new Model(id, model.getLabel(), model.getDate());
      models.add(newModel);
    }
  }

  public void deleteModel(Model model) {
    models.remove(model);
  }

}
