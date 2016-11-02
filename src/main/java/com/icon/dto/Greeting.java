package com.icon.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class Greeting {

    private long id;
    private String content;
    private String gender;


    public Greeting(){

    }


    public Greeting(long id, String content, String gender) {
        this.id = id;
        this.content = content;
        this.gender = gender;
    }

    @JsonProperty("idCustom")
    public long getId() {
        return id;
    }

    @JsonProperty("contentCustom")
    public String getContent() {
        return content;
    }


    public String getGender(){
        return gender;
    }
}
