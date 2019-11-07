package com.fomin.ftpServer.core.DAO;

import com.fomin.ftpServer.core.model.NoteList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository//надо будет сделать через path с кодированием
public interface NoteListRepository extends CrudRepository<NoteList, Long> {
    NoteList getById(Long id);
}
