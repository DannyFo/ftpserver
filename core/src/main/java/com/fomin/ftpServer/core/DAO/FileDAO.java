package com.fomin.ftpServer.core.DAO;

import com.fomin.ftpServer.core.util.FileUtil;
import lombok.NoArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
@NoArgsConstructor
public class FileDAO implements InterfaceFileDAO {

    @Override
    public void createFile(File file, String fileType) {
        File directory = new File(FileUtil.isExistName(file.getAbsolutePath()));
        if (fileType.equals("file")) {
            try {
                directory.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            directory.mkdir();
        }
    }

    @Override
    public void deleteFile(File file) {
        if(file.isDirectory()){
            try {
                FileUtils.deleteDirectory(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            FileUtils.deleteQuietly(file);
        }
    }

    @Override
    public String openType(File file) {
        if (file.isFile()) {
            return FilenameUtils.getExtension(file.getAbsolutePath());
        }
        return "directory";
    }

    @Override
    public File up(File file) {
        return file.getParentFile();
    }

    @Override
    public File[] getListFiles(File file) {
        return file.listFiles();
    }
}
