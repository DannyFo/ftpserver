package com.fomin.ftpServer.core.DAO;

import java.io.File;
import java.util.List;

public interface InterfaceFileManagerDAO {

    void createFile(File file);

    void deleteFile(File file);

    String openType(File file);

    File up(File file);

    List<File> getListFiles();
}
