package com.fomin.ftpServer.core.DAO;

import java.io.File;

public interface InterfaceFileDAO {

    void createFile(File file, String fileType);

    void deleteFile(File file);

    String openType(File file);

    File up(File file);

    File[] getListFiles(File file);
}
