package com.example.vmtung.example;


import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class CountryDto implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String name;
    private String code;
    private Drawable flagDrawable;
    
    public CountryDto()
    {
    }
    
    public CountryDto(Long id, String name, String code, Drawable flagDrawable)
    {
        super();
        this.id = id;
        this.name = name;
        this.code = code;
        this.flagDrawable = flagDrawable;
    }
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Drawable getFlagDrawable() {
        return flagDrawable;
    }

    public void setFlagDrawable(Drawable flagDrawable) {
        this.flagDrawable = flagDrawable;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("CountryDto [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append("]");
        return builder.toString();
    }
}
