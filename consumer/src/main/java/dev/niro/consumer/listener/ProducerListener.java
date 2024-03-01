package dev.niro.consumer.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import dev.niro.consumer.model.ProducerResponse;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProducerListener {

  @KafkaListener(topics = "generateSpr", groupId = "groupId")
  void generalListener(ConsumerRecord<String, Object> record) {
    Gson gson = new Gson();
    // Mengubah string JSON menjadi objek
    ProducerResponse obj = gson.fromJson(record.value().toString(), ProducerResponse.class);
    System.out.println(obj.getTest());
    System.out.println(obj.getNo());
    // ObjectMapper objectMapper = new ObjectMapper();

    // // try {
    // System.out.println("Received Message:");
    // System.out.println("Key: " + record.key());
    // // System.out.println("Value: " +
    // // objectMapper.readValue(record.value().toString(),
    // ProducerResponse.class));
    // System.out.println("Value: " + record.value());
    // System.out.println("Partition: " + record.partition());
    // System.out.println("Offset: " + record.offset());
    // System.out.println("------------------");
    // } catch (JsonProcessingException e) {
    // System.out.println("gagal");
    // // Tangkap dan cetak stack trace jika terjadi JsonProcessingException
    // e.printStackTrace();
    // }
  }
}
