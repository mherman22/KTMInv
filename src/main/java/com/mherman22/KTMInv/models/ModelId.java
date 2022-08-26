package com.mherman22.KTMInv.models;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ModelId {

    private UUID id;

    @JsonValue
    public UUID getId() {
        return id;
    }

    @JsonCreator
    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ModelId [id=" + id + "]";
    }
}
