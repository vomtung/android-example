package com.example.vmtung.example;

import java.io.Serializable;

/**
 * Created by vmtung on 21/08/2017.
 */

public class ItemJuiceListExampleObject implements Serializable
{
    private String name;

    public ItemJuiceListExampleObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
