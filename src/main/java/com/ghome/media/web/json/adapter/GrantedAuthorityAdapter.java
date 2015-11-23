package com.ghome.media.web.json.adapter;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by Volodymyr_Honchar on 23.11.2015.
 */
public class GrantedAuthorityAdapter extends TypeAdapter<GrantedAuthority> {

    @Override
    public void write(JsonWriter jsonWriter, GrantedAuthority authority) throws IOException {

        jsonWriter.beginObject().name("group").value(authority.getAuthority()).endObject();
    }

    @Override
    public GrantedAuthority read(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        jsonReader.nextName();
        GrantedAuthority authority = new SimpleGrantedAuthority(jsonReader.nextString());
        jsonReader.endObject();
        return authority;
    }
}
