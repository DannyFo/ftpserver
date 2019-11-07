package com.fomin.ftpServer.core.services;

import com.fomin.ftpServer.core.DAO.NoteRepository;
import com.fomin.ftpServer.core.model.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class NoteService implements InterfaceNoteService {

    private final NoteRepository noteRepository;


    @Override
    public Note getNote(Long id) {
        return noteRepository.getById(id);
    }
}
