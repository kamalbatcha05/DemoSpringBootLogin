package com.example.demo.utils;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import com.example.demo.entity.Category;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JsonObjectSerializer extends JsonSerializer<Object> {

	@Override
	public void serialize(Object obj, JsonGenerator jgen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {


        jgen.writeStartObject();
        if(obj instanceof Category) {
        	Category category = (Category) obj;
        	jgen.writeNumberField("id", category.getId());
        	jgen.writeStringField("categoryName", category.getCategoryName());
        }
        
        // Iterator for collection of object
        if(obj instanceof Set) {
        	Iterator itr = ((Set) obj).iterator();
            while (itr.hasNext()) {
            	Object itrObject = itr.next();
            	
            }
        }
        
        jgen.writeEndObject();
		
	}

}
