package com.fomin.ftpServer.core.services;

import com.fomin.ftpServer.core.DAO.NoteListRepository;
import com.fomin.ftpServer.core.model.NoteList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class NoteListService implements InterfaceListNoteService {

    private final NoteListRepository noteListRepository;


    @Override
    public NoteList getNoteList(Long id) {
        return noteListRepository.getById(id);
    }

    @Override
    public NoteList getNoteList(String path) {
        return noteListRepository.getByPath(path);
    }
}
