package com.fomin.ftpServer.core.mappers;

import com.fomin.ftpServer.core.DTO.NoteListDTO;
import com.fomin.ftpServer.core.model.NoteList;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NoteListMapper {
    NoteListDTO toDTO(NoteList NoteList);
}
