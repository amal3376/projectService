package dev.amalendu.projectservice.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
public class ExceptionDto {

    private HttpStatus errorCode;
    private String message;

    public ExceptionDto(HttpStatus httpStatus, String message){
        this.errorCode = httpStatus;
        this.message=message;
    }
}
