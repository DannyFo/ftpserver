package com.fomin.ftpServer.core.controllers;

import com.fomin.ftpServer.core.DTO.FilePresentDTO;
import com.fomin.ftpServer.core.services.InterfaceFilePresentListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/browse")
public class BrowserController {

    private String decode(String uri) throws UnsupportedEncodingException {
            return URLDecoder.decode(uri, StandardCharsets.UTF_8.toString());
    }

    private final InterfaceFilePresentListService filePresentListService;
    @GetMapping
    public List<FilePresentDTO> getList(){
        return filePresentListService.getFilePresentList(new File("D://java//test"));
    }

    @GetMapping("/openFolder/{uri}")
    public List<FilePresentDTO> openFolder(@PathVariable String uri) throws UnsupportedEncodingException {
        return filePresentListService.getFilePresentList(new File(decode(uri)));
    }

}
//http://localhost:8080/fileBrowser/browser?ID=D%3A%5Cjava%5Ctest%5Cdownload&action=open
//http://localhost:8080/browse/openFolder/D%3A%5Cjava%5Ctest%5Cdownload