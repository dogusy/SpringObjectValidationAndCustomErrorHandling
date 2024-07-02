package com.example.demo.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ObjectNotValidException extends RuntimeException {

    private final Set<String> errorMessages;

}