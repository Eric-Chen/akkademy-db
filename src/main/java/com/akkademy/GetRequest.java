package com.akkademy;

import java.io.Serializable;

/**
 * Created by eric on 28/07/2017.
 */
public class GetRequest implements Serializable{

    public final String key;

    public GetRequest(String key) {
        this.key = key;
    }
}
