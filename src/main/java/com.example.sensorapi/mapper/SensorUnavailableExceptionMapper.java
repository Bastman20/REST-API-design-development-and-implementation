package com.example.sensorapi.mapper;

import com.example.sensorapi.exception.SensorUnavailableException;
import com.example.sensorapi.model.ErrorResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class SensorUnavailableExceptionMapper implements ExceptionMapper<SensorUnavailableException> {

    @Override
    public Response toResponse(SensorUnavailableException ex) {
        ErrorResponse error = new ErrorResponse(
                403,
                "Forbidden",
                ex.getMessage()
        );

        return Response.status(Response.Status.FORBIDDEN)
                .entity(error)
                .build();
    }
}