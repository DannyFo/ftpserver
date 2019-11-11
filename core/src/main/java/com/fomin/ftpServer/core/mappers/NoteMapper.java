package com.fomin.ftpServer.core.mappers;

import com.fomin.ftpServer.core.DTO.NoteDTO;
import com.fomin.ftpServer.core.model.Note;
import org.mapstruct.Mapper;

@Mapper
public interface NoteMapper {
    NoteDTO toDTO(Note note);
}
