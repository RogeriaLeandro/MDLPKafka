package br.mil.defesa.interc2.mdlp;

import java.util.Properties;
import java.util.function.Function;

import javax.annotation.PostConstruct;

import org.apache.kafka.common.serialization.Serdes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Component;

@Component
public class MdlpKafkaProcessor {

    @Value("${in.kafka.topic}")
    private String inKafkaTopic;

    @Value("${out.BR2.X}")
    private String out_BR2_X;

    @Value("${out.BR2.KC}")
    private String out_BR2_KC;

    @Value("${out.YB.44}")
    private String out_YB_44;

    @Value("${out.YB.42}")
    private String out_YB_42;

    @Value("${out.kafka.topic}")
    private String outKafkaTopic;

    @Autowired
    private StreamBuilder streamBuilder;

    @PostConstruct
    public void streamTopology(){

        KStream<String, JsonObject> kStream = streamBuilder.stream(inKafkaTopic, Consumed.with(Serdes.String(), Serdes.String()));
        
        //Pegar os topicos de acordo com o getSource e o getId
        //pegar os topicos dessas propriedades e colocar numa array
        //para cada topico dentro da array, produced.with
        String source =  kstream.getSource;
        String idSource = kStream.getIdSource;

        String outProperties = "out_"+ source + "_" + idSource;
        
        String topics = String.valueOf(outProperties);

        String[] listTopics = util.devolveArrayTopics(topics);

        for (int i = 0; i < listTopics.length; i++){
            kstream.to(listTopics[i], Produced.with(Serdes.String(), Serdes.String()));

        }

        // kStream.filter =((key, value) -> value.startsWith("Message_"))
        //     .mapValues((k, v) -> System.out.println("Key: " + k + " Value: " + v + ))
        //     .to(outKafkaTopic, Produced.with(Serdes.String(), Serdes.String())); 
        
    }

}