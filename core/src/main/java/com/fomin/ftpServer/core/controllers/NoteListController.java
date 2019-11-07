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

    private final InterfaceListNoteService noteService;
    private final NoteListMapper noteMapper;

    @GetMapping("/noteList/{id}")
    public NoteListDTO getNote(@PathVariable Long id){
        NoteList noteList = noteService.getNoteList(id);
        return noteMapper.toDTO(noteList);
    }
}

