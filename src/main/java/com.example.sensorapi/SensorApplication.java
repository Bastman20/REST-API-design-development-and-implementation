package com.example.sensorapi;

import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api/v1")
public class SensorApplication extends ResourceConfig {

    public SensorApplication() {
        packages("com.example.sensorapi");
    }
}
