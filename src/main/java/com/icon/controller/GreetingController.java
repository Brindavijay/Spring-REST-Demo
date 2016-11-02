package com.icon.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.icon.dto.Greeting;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
public class GreetingController {


    @RequestMapping(value = "/greeting")
    public Greeting greeting(@RequestParam(value = "idValue", defaultValue = "1") Long id,
                             @RequestParam(value = "contentValue", defaultValue = "Hi Brinda") String content,
                             @RequestParam (value = "genderValue", defaultValue = "F") String gender, HttpServletRequest request, HttpServletResponse response) {


        System.out.println(request.getQueryString());
        System.out.println(request.getRequestURL());
        System.out.println(request.getRequestURI());

        return new Greeting(id, content, gender);
    }


    @RequestMapping(value = "/greetingPost", method = RequestMethod.POST)
    public Greeting greeting(@RequestBody Greeting greeting,HttpServletRequest request, HttpServletResponse response) {

        String brindaHeaderName = request.getHeader("Brinda");
        System.out.println("Brinda Header Value is "+ brindaHeaderName);

        if(greeting.getId() > 10){
            response.setStatus( HttpServletResponse.SC_BAD_REQUEST  );
            return null;
        }

        response.setHeader("BrindaResponse", "I am doing it");
        return greeting;
    }


}
