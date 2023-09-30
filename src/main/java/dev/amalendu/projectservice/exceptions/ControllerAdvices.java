package dev.amalendu.projectservice.exceptions;

import dev.amalendu.projectservice.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ControllerAdvices {
//
//    @ExceptionHandler(NotFoundException.class)
//    private ResponseEntity<ExceptionDto> handelNotFoundException(
//            NotFoundException notFoundException){
//        return  new ResponseEntity(
//                new ExceptionDto(HttpStatus.NOT_FOUND, notFoundException.getMessage()),
//                HttpStatus.NOT_FOUND
//        );
////        System.out.println("Not Found Exception Response");
//    }
//
//    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
//    private ResponseEntity<ExceptionDto> handelArrayIndexOutOfBound(
//            ArrayIndexOutOfBoundsException notFoundException){
//        return  new ResponseEntity(
//                new ExceptionDto(HttpStatus.NOT_FOUND, notFoundException.getMessage()),
//                HttpStatus.NOT_FOUND
//        );
////        System.out.println("Not Found Exception Response");
//    }
}
