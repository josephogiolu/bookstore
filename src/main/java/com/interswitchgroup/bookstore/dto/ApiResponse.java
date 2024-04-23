package com.interswitchgroup.bookstore.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private boolean valid;
    private String status;
    @JsonIgnore
    private int httpstatus;
    private String message;
    private T data;

    public ApiResponse( int httpstatus, String message, T data) {
        this.message = message;
        this.data = data;
        this.httpstatus = httpstatus;
    }

    public ApiResponse( boolean valid,String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.valid=valid;
    }

}