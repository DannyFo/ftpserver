package com.fomin.ftpServer.core.controllers;

import com.fomin.ftpServer.core.DTO.FilePresentListDTO;
import com.fomin.ftpServer.core.services.InterfaceFilePresentListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/browse")
public class BrowserController {

    private File initPath = new File("D://java//test");

    private String decode(String uri) throws UnsupportedEncodingException {
        return URLDecoder.decode(uri, StandardCharsets.UTF_8.toString());
    }

    private final InterfaceFilePresentListService filePresentListService;

    @GetMapping
    public FilePresentListDTO getList(@RequestParam(required = false) String uri) throws UnsupportedEncodingException {
        if(uri==null){
            return filePresentListService.getFilePresentList(new File("D://java//test"));
        }
        return openFolder(uri);
    }

    @GetMapping("/openFolder")
    public FilePresentListDTO openFolder(@RequestParam String uri) throws UnsupportedEncodingException {
        return filePresentListService.getFilePresentList(new File(decode(uri)));
    }

    @PostMapping
    public FilePresentListDTO createFile(@RequestBody Map<String,String> values) {
        String fileName = values.get("fileName");
        String fileType = values.get("fileType");
        String currentPath = values.get("currentPath");
        return filePresentListService.create(new File(currentPath+"/"+fileName), fileType);
    }

}
