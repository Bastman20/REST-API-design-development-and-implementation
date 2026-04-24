package com.example.sensorapi;

import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api/v1")
public class SensorApplication extends ResourceConfig {

    public SensorApplication() {
        register(com.example.sensorapi.resource.DiscoveryResource.class);
        register(com.example.sensorapi.resource.SensorRoomResource.class);
        register(com.example.sensorapi.resource.SensorResource.class);

        register(com.example.sensorapi.mapper.RoomNotEmptyExceptionMapper.class);
        register(com.example.sensorapi.mapper.LinkedResourceNotFoundExceptionMapper.class);
        register(com.example.sensorapi.mapper.SensorUnavailableExceptionMapper.class);
        register(com.example.sensorapi.mapper.GlobalExceptionMapper.class);
        register(com.example.sensorapi.filter.ApiLoggingFilter.class);
    }
}