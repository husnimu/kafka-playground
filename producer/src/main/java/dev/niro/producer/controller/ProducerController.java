package dev.niro.producer.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.niro.producer.model.ProducerRequest;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping
public class ProducerController {

  private KafkaTemplate<String, Object> kafkaTemplate;

  @GetMapping
  public Boolean getAll() {
    System.out.println("generating producer...");

    ProducerRequest test = new ProducerRequest("halo", 12L);
    ObjectMapper objectMapper = new ObjectMapper();

    try {
      String jsonString = objectMapper.writeValueAsString(test);
      System.out.println(jsonString);
      kafkaTemplate.send("generateSpr", jsonString);
      System.out.println("done generating producer...");
    } catch (JsonProcessingException e) {
      System.out.println("gagal");
      // Tangkap dan cetak stack trace jika terjadi JsonProcessingException
      e.printStackTrace();
    }
    return true;
  }
}