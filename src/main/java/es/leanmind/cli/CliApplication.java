package es.leanmind.cli;

import es.leanmind.kpi.KpiApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {CliApplication.class, KpiApplication.class})
public class CliApplication {
    public static void main(String[] args) {
        SpringApplication.run(CliApplication.class, args);
    }
}

