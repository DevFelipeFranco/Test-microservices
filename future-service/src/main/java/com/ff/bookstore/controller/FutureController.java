package com.ff.bookstore.controller;

import com.ff.bookstore.services.FutureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/v1/api/future")
public class FutureController {

    private FutureService futureService;

    @Autowired
    public FutureController(FutureService futureService) {
        this.futureService = futureService;
    }

    @GetMapping(value = "/{symbol}")
    public ResponseEntity getFuture(@PathVariable("symbol") String symbol) {
        return futureService.getFuture(symbol).orElse(null);
    }
}
