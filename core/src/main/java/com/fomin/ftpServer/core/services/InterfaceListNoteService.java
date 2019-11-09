package com.fomin.ftpServer.core.services;

import com.fomin.ftpServer.core.model.NoteList;

public interface InterfaceListNoteService {
    NoteList getNoteList(Long id);

    NoteList getNoteList(String path);

}
