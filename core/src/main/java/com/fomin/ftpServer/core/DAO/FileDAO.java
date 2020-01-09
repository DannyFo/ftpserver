package com.fomin.ftpServer.core.DAO;

import com.fomin.ftpServer.core.DTO.FilePresentDTO;
import com.fomin.ftpServer.core.DTO.FilePresentListDTO;
import com.fomin.ftpServer.core.util.FileUtil;
import lombok.NoArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        if (file.isDirectory()) {
            try {
                FileUtils.deleteDirectory(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
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
    public FilePresentListDTO getListFiles(File file) {
        List<FilePresentDTO> list = new ArrayList<>();
        for (File fileToAdd : Objects.requireNonNull(file.listFiles())) {
            list.add(new FilePresentDTO()
                    .setID(fileToAdd)
                    .setFileName(FilenameUtils.getBaseName(fileToAdd.getAbsolutePath()))
                    .setFileType(FileUtil.getFileType(fileToAdd))
                    .setSize(FileUtil.sizeConvert(fileToAdd))
                    .setUri(setUri(fileToAdd)));
        }
        return new FilePresentListDTO().setCurrentPath(setUri(file)).setFilePresentDTOList(list);
    }

    private String setUri(File file) {
        try {
            return URLEncoder.encode(file.toString(), StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("БЕДА");
        }
    }

}
