package br.com.reneg.oslc.processor;


import br.com.reneg.oslc.processor.interfaces.Processor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@SpringBootApplication
@EnableBinding({Processor.class})
public class ProcessorImpl {

    @StreamListener(Processor.SAMPLE)
  //  @SendTo(Processor.OUTPUT)
    public void process(String s) {
        System.out.println("Received ProcessorImpl: " + s);
    //    return s.toUpperCase();
    }
}