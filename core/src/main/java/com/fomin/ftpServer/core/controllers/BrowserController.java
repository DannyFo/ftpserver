package com.fomin.ftpServer.core.controllers;

import com.fomin.ftpServer.core.DTO.FilePresentDTO;
import com.fomin.ftpServer.core.services.InterfaceFilePresentListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BrowserController {
    private final InterfaceFilePresentListService filePresentListService;
    @GetMapping("/browse")
    public List<FilePresentDTO> getNote(){
        return filePresentListService.getFilePresentList(new File("D://java//test"));
    }
}
