package com.fomin.ftpServer.core.services;

import com.fomin.ftpServer.core.DAO.FileDAO;
import com.fomin.ftpServer.core.DAO.NoteListRepository;
import com.fomin.ftpServer.core.DTO.FilePresentDTO;
import com.fomin.ftpServer.core.DTO.NoteDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class FilePresentListService implements InterfaceFilePresentListService {

    private final FileDAO fileDAO;
    private final NoteListRepository noteListRepository;

    @Override
    public List<FilePresentDTO> sortBy(String fieldToSort) {
        return null;
    }

    @Override
    public List<FilePresentDTO> delete(File file) {
        File parentFile = file.getParentFile();
        fileDAO.deleteFile(file);
        return getFilePresentList(parentFile);
    }

    @Override
    public List<FilePresentDTO> getFilePresentList(File file) {
        List<FilePresentDTO> list = new ArrayList<>();
        File[] files = fileDAO.getListFiles(file);
        for (File presentFile : files) {
            list.add(new FilePresentDTO(presentFile,noteListRepository.getByPath(file.getAbsolutePath()).getNotes().size()));
        }
        return list;
    }

    @Override
    public List<FilePresentDTO> create(File file, String filetype) {
        File parentFile = file.getParentFile();
        fileDAO.createFile(file,filetype);
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
    public List<FilePresentDTO> up(File file) {
        return getFilePresentList(fileDAO.up(file));
    }

}
