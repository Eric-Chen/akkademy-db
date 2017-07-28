package com.akkademy;

import java.io.Serializable;

/**
 * Created by eric on 28/07/2017.
 */
public class KeyNotFoundException extends Exception implements Serializable {

    public final String key;

    public KeyNotFoundException(String key) {
        this.key = key;
    }
}
