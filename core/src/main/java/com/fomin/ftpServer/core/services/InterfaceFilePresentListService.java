package com.fomin.ftpServer.core.services;

import com.fomin.ftpServer.core.DTO.FilePresentDTO;
import com.fomin.ftpServer.core.DTO.NoteDTO;

import java.io.File;
import java.util.List;
import java.util.Set;

public interface InterfaceFilePresentListService {

    public List<FilePresentDTO> sortBy (String fieldToSort);

    public List<FilePresentDTO> delete(File file);

    public List<FilePresentDTO> getFilePresentList(File file);

    public List<FilePresentDTO> create(File file, String filetype);

    public <T> T open(File file);//???

    Set<NoteDTO> getNotes(File file);// или все таки ListFilesDTO

    void addNote(String ID, String text);

    public List<FilePresentDTO> up(File file);
}
