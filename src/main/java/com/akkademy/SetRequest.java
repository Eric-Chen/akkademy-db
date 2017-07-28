package com.akkademy;


/**
 * Created by eric on 21/07/2017.
 */
public final class SetRequest {

    private final String key;

    private final Object value;

    public SetRequest(String key, Object value){
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}
