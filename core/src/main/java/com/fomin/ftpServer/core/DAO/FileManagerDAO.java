package com.fomin.ftpServer.core.DAO;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.List;

public class FileManagerDAO implements InterfaceFileManagerDAO {
    @Override
    public void createFile(File file) {

    }

    @Override
    public void deleteFile(File file) {

    }

    @Override
    public String openType(File file) {
        if(file.isFile()){
            return FilenameUtils.getExtension(file.getAbsolutePath());
        }
        return "directory";
    }

    @Override
    public File up(File file) {
        return null;
    }

    @Override
    public List<File> getListFiles() {
        return null;
    }
}
