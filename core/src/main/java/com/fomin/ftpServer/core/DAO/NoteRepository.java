package com.fomin.ftpServer.core.DAO;

import com.fomin.ftpServer.core.model.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends CrudRepository <Note,Long> {
    Note getById(Long id);
}
