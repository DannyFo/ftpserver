package com.fomin.ftpServer.core.mappers;

import com.fomin.ftpServer.core.DTO.NoteDTO;
import com.fomin.ftpServer.core.DTO.NoteListDTO;
import com.fomin.ftpServer.core.model.Note;
import com.fomin.ftpServer.core.model.NoteList;
import org.mapstruct.Mapper;

@Mapper
public interface NoteMapper {
    NoteDTO toDTO(Note note);
}
