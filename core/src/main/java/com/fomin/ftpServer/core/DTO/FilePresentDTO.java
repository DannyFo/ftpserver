package com.fomin.ftpServer.core.DTO;

import com.fomin.ftpServer.core.util.FileUtil;
import lombok.Getter;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Getter

public class FilePresentDTO {

    private File ID ;
    private String fileName;
    private String fileType;
    private String size;
    private String uri;
    private int countNotes;

    public FilePresentDTO(File ID, int countNotes) {
        this.ID = ID;
        this.fileName = FilenameUtils.getBaseName(ID.getAbsolutePath());
        this.fileType = FileUtil.getFileType(ID);
        this.size= FileUtil.sizeConvert(ID);
        this.countNotes = countNotes;
        setUri();
    }

    private void setUri(){
        try {

            this.uri= URLEncoder.encode(ID.toString(), StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
