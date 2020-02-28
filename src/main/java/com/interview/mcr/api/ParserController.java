package com.interview.mcr.api;

import com.interview.mcr.LineOne;
import com.interview.mcr.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParserController {

    @Autowired
    Parser parser;

    @RequestMapping("/lineOne/{mcrData}")
    public ResponseEntity lineOne(@PathVariable("mcrData") String mcrData) {
        try {
            LineOne lineOne = parser.parseLineOne(mcrData);
            return new ResponseEntity(lineOne, HttpStatus.OK);
        } catch (IllegalArgumentException iae) {
            return new ResponseEntity(iae.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }


}
