package com.fomin.ftpServer.core.services;

import com.fomin.ftpServer.core.DTO.FilePresentListDTO;
import com.fomin.ftpServer.core.DTO.NoteDTO;

import java.io.File;
import java.util.Set;

public interface InterfaceFilePresentListService {

    public FilePresentListDTO sortBy (String fieldToSort);

    public FilePresentListDTO delete(File file);

    public FilePresentListDTO getFilePresentList(File file);

    public FilePresentListDTO create(File file, String filetype);

    public <T> T open(File file);//???

    Set<NoteDTO> getNotes(File file);// или все таки

    void addNote(String ID, String text);

    public FilePresentListDTO up(File file);
}
