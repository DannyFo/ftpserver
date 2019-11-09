package com.fomin.ftpServer.core.DAO;

import com.fomin.ftpServer.core.model.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends CrudRepository <Note,Long> {
    Note getById(Long id);

    List<Note> getAllByText(String string);
}
