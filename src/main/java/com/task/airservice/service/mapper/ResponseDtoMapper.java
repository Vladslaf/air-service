package com.task.airservice.service.mapper;

public interface ResponseDtoMapper<D, M> {
    D mapToDto(M m);
}
