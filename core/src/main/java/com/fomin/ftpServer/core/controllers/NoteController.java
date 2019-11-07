package com.fomin.ftpServer.core.controllers;

import com.fomin.ftpServer.core.DTO.NoteDTO;
import com.fomin.ftpServer.core.DTO.NoteListDTO;
import com.fomin.ftpServer.core.mappers.NoteMapper;
import com.fomin.ftpServer.core.model.Note;
import com.fomin.ftpServer.core.model.NoteList;
import com.fomin.ftpServer.core.services.InterfaceListNoteService;
import com.fomin.ftpServer.core.services.InterfaceNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class NoteController {

    private final InterfaceNoteService noteService;
    private final NoteMapper noteMapper;

    @GetMapping("/note/{id}")
    public NoteDTO getNote(@PathVariable Long id){
        Note note = noteService.getNote(id);
        return noteMapper.toDTO(note);
    }

//    @PostMapping("note")
//    public ResponseEntity<?> saveNote(@RequestParam("file")MultipartFile file,
//                                      @RequestBody NoteDTO noteDTO){
//        Note note = noteMapper.t
//    }

}

