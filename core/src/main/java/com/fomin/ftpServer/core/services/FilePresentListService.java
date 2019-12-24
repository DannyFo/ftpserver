package com.fomin.ftpServer.core.services;

import com.fomin.ftpServer.core.DAO.FileDAO;
import com.fomin.ftpServer.core.DTO.FilePresentListDTO;
import com.fomin.ftpServer.core.DTO.NoteDTO;
import com.fomin.ftpServer.core.mappers.NoteListMapper;
import com.fomin.ftpServer.core.model.NoteList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class FilePresentListService implements InterfaceFilePresentListService {

    private final FileDAO fileDAO;
    private final InterfaceListNoteService listNoteService;
    private final NoteListMapper noteListMapper;

    private int countNotes(String path) {
        Optional<NoteList> noteList = Optional.ofNullable(listNoteService.getNoteList(path));
        return noteList.map(list -> noteListMapper.toDTO(list).getNotes().size()).orElse(0);
    }

    @Override
    public FilePresentListDTO sortBy(String fieldToSort) {
        return null;
    }

    @Override
    public FilePresentListDTO delete(File file) {
        File parentFile = file.getParentFile();
        fileDAO.deleteFile(file);
        return getFilePresentList(parentFile);
    }

    @Override
    public FilePresentListDTO getFilePresentList(File file) {
        FilePresentListDTO files = fileDAO.getListFiles(file);
        files.getFilePresentDTOList()
                .forEach((filePresentDTO -> filePresentDTO
                        .setCountNotes(countNotes(filePresentDTO
                                .getID()
                                .getAbsolutePath()))));
        return files;
    }

    @Override
    public FilePresentListDTO create(File file, String filetype) {
        File parentFile = file.getParentFile();
        fileDAO.createFile(file, filetype);
        return getFilePresentList(parentFile);
    }

    @Override
    public <T> T open(File file) {
        return null;
    }

    @Override
    public Set<NoteDTO> getNotes(File file) {
        return null;
    }

    @Override
    public void addNote(String ID, String text) {

    }

    @Override
    public FilePresentListDTO up(File file) {
        return getFilePresentList(fileDAO.up(file));
    }

}
