package com.example.sensorapi.resource;

import com.example.sensorapi.exception.LinkedResourceNotFoundException;
import com.example.sensorapi.model.Sensor;
import com.example.sensorapi.store.DataStore;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/sensors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorResource {

    @GET
    public Response getSensors(@QueryParam("type") String type) {
        if (type == null || type.isBlank()) {
            return Response.ok(DataStore.sensors.values()).build();
        }

        java.util.List<Sensor> filteredSensors = DataStore.sensors.values()
                .stream()
                .filter(sensor -> type.equalsIgnoreCase(sensor.getType()))
                .toList();

        return Response.ok(filteredSensors).build();
    }

    @POST
    public Response createSensor(Sensor sensor) {
        if (sensor.getSensorId() == null || sensor.getSensorId().isBlank()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("sensorId is required")
                    .build();
        }

        if (sensor.getRoomId() == null || !DataStore.rooms.containsKey(sensor.getRoomId())) {
            throw new LinkedResourceNotFoundException("The roomId does not exist.");
        }

        DataStore.sensors.put(sensor.getSensorId(), sensor);

        return Response.status(Response.Status.CREATED)
                .entity(sensor)
                .build();
    }
    @Path("/{sensorId}/readings")
    public SensorReadingResource getSensorReadingResource(@PathParam("sensorId") String sensorId) {
        return new SensorReadingResource(sensorId);
    }
}