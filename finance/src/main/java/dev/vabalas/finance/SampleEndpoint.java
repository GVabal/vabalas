package dev.vabalas.finance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SampleEndpoint {

    private static final Logger log = LoggerFactory.getLogger(SampleEndpoint.class);

    private final SampleRepository sampleRepository;

    public SampleEndpoint(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @GetMapping
    public List<Sample> getSamples() {
        log.info("GET ALL SAMPLES");
        return sampleRepository.findAll();
    }

    @GetMapping("add")
    public Sample add() {
        log.info("ADD SAMPLE");
        var sample = new Sample();
        sample.setText(String.valueOf(System.currentTimeMillis()));
        sampleRepository.save(sample);

        return sample;
    }

    @GetMapping("update")
    public Sample update() {
        log.info("UPDATE FIRST SAMPLE");
        var sample = getSamples().get(0);
        sample.setText("updated");
        sampleRepository.save(sample);

        return sample;
    }

    @GetMapping("clear")
    public void clear() {
        log.info("CLEAR ALL SAMPLES");
        sampleRepository.deleteAll();
    }
}
