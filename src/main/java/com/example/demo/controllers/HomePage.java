package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import newSDK.conncet.library.com.payne.reader.Reader;
import newSDK.conncet.library.com.payne.reader.bean.config.AntennaCount;
import newSDK.conncet.library.com.payne.reader.process.ReaderImpl;

@RestController
public class HomePage {
    private final String HELLO = "Hello world!";

    @GetMapping("/")
    public String sayHello() {
        Reader mReader = ReaderImpl.create(AntennaCount.SIXTEEN_CHANNELS);
        return  HELLO;
    }

}
