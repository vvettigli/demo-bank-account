package com.example.numeri_fibonacci.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.numeri_fibonacci.numeriDiFibonacci.NumeriDiFibonacci;

@RestController
public class restController {

    @Autowired
    NumeriDiFibonacci numeriDiFibonacci;

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @ResponseBody
    @RequestMapping("/numeri")
    public String sequenzaDiFibonacci(int quantiNumeri) {
      List <Integer> lista = numeriDiFibonacci.numeriDiFibonacci(quantiNumeri);
      return lista.toString();

    }
}
