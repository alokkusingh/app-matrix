package com.alok.app.matrix.config;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class MatrixConfiguration {

    // io.micrometer.core.aop.TimedAspect
    // org.springframework.context.annotation.Bean
    // io.micrometer.core.instrument.MeterRegistry
    @Bean
    public TimedAspect timedAspect(MeterRegistry registry) {
        return new TimedAspect(registry);
    }

    @Bean
    MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
        String hostname = System.getenv("HOSTNAME");
        return registry -> registry.config().commonTags(
                "region", "India",
                "service", "hello-service",
                "application", "hello-service",
                "instance", hostname,
                "host", hostname
        );
    }
}
