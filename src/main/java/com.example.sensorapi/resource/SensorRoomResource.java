package com.example.sensorapi.resource;

import com.example.sensorapi.model.Room;
import com.example.sensorapi.store.DataStore;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import com.example.sensorapi.exception.RoomNotEmptyException;

@Path("/rooms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorRoomResource {

    @GET
    public Response getAllRooms() {
        Collection<Room> rooms = DataStore.rooms.values();
        return Response.ok(rooms).build();
    }

    @POST
    public Response createRoom(Room room) {
        if (room.getRoomId() == null || room.getRoomId().isBlank()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("roomId is required")
                    .build();
        }

        DataStore.rooms.put(room.getRoomId(), room);

        return Response.status(Response.Status.CREATED)
                .entity(room)
                .build();
    }

    @GET
    @Path("/{roomId}")
    public Response getRoomById(@PathParam("roomId") String roomId) {
        Room room = DataStore.rooms.get(roomId);

        if (room == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Room not found")
                    .build();
        }

        return Response.ok(room).build();
    }

    @DELETE
    @Path("/{roomId}")
    public Response deleteRoom(@PathParam("roomId") String roomId) {
        if (!DataStore.rooms.containsKey(roomId)) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Room not found")
                    .build();
        }

        boolean hasSensors = DataStore.sensors.values().stream()
                .anyMatch(sensor -> roomId.equals(sensor.getRoomId()));

        if (hasSensors) {
            throw new RoomNotEmptyException("Room has active sensors");
        }

        DataStore.rooms.remove(roomId);

        return Response.noContent().build();
    }
}