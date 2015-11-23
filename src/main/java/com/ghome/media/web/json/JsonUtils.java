package com.ghome.media.web.json;

import com.ghome.media.web.json.adapter.GrantedAuthorityAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Volodymyr_Honchar on 23.11.2015.
 */
public class JsonUtils {

    private JsonUtils() {
    }

    public static Gson createGson() {
        return new GsonBuilder()
                .registerTypeAdapter(GrantedAuthority.class, new GrantedAuthorityAdapter())
                .create();
    }
}
