package com.classroom2.demo.models;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Response {
    private String Response;
    private String Detail;
    private String Code;
    private Object object;

    public  Response(){
    }
}
