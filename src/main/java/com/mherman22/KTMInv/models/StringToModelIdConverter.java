package com.mherman22.KTMInv.models;

import java.util.UUID;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class StringToModelIdConverter implements Converter<String, ModelId> {

    /**
     * Converter instance that will tell Spring how to convert from String to
     * ModelId
     * 
     * @param uuid
     * @return ModelId
     */
    @Override
    public ModelId convert(@NonNull String uuid) {
        return new ModelId(UUID.fromString(uuid));
    }

}
