package com.fomin.ftpServer.core.controllers;

import com.fomin.ftpServer.core.DTO.NoteListDTO;
import com.fomin.ftpServer.core.mappers.NoteListMapper;
import com.fomin.ftpServer.core.model.NoteList;
import com.fomin.ftpServer.core.services.InterfaceListNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NoteListController {

    private final InterfaceListNoteService listNoteService;
    private final NoteListMapper noteListMapper;

    @GetMapping("/noteList/{id}")
    public NoteListDTO getNote(@PathVariable Long id){
        NoteList noteList = listNoteService.getNoteList(id);
        return noteListMapper.toDTO(noteList);
    }

    @GetMapping("/noteListPath/{path}")
    public NoteListDTO getNoteByPath(@PathVariable String path){
        NoteList noteList = listNoteService.getNoteList(path);
        return noteListMapper.toDTO(noteList);
    }
}
