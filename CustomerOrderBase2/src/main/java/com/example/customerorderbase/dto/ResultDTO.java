package com.example.customerorderbase.dto;

import lombok.Data;

public @Data class ResultDTO<T> {

    private T data;
    private boolean success;
    private String msg;


}
