package com.ff.bookstore.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
@Service
public class FutureService {

    private RestTemplate restTemplate;

    @Value("${future.url}")
    private String futureUrl;

    @Autowired
    public FutureService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Optional<ResponseEntity> getFuture(String symbol) {

        //&symbols=NIO,PLTR,SOFI,T,TSLA
//        String url = futureUrl + "?formatted=true&crumb=IgCHyddcAYl&lang=en-US&region=US&fields=symbol,shortName,longName,regularMarketPrice,regularMarketChange,regularMarketChangePercent,corporateActions&corsDomain=finance.yahoo.com&symbols=NIO,PLTR,SOFI,T,TSLA";
        String url = futureUrl + symbol + "?symbol=" + symbol + "&interval=1m";

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        return Optional.of(responseEntity);
    }
}
