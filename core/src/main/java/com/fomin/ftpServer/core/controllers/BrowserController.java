package com.fomin.ftpServer.core.controllers;

import com.fomin.ftpServer.core.DTO.CreateFileDTO;
import com.fomin.ftpServer.core.DTO.FilePresentDTO;
import com.fomin.ftpServer.core.services.InterfaceFilePresentListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/openFolder")
    public List<FilePresentDTO> openFolder(@RequestParam String uri) throws UnsupportedEncodingException {
        return filePresentListService.getFilePresentList(new File(decode(uri)));
    }

    @PostMapping
    public List<FilePresentDTO> createFile(@RequestBody CreateFileDTO createFileDTO){
        CreateFileDTO fileDTO = createFileDTO;
        String name= fileDTO.getFileName();
        return filePresentListService.create(new File(fileDTO.getFileName()),fileDTO.getFileType());
    }

}
