package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class Producer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        
        // Skenario Mengirim 10 Data
        // topic-java-lagi di set sebanyak 3 partisi
        for (int i = 0; i < 10 ; i++) {
            String key = "Key-" + i;
            String data = "Data ke-" + i;

            ProducerRecord<String, String> record = new ProducerRecord<>("topic-java-lagi", key, data);
            producer.send(record);
        }

        producer.close();
    }
}







