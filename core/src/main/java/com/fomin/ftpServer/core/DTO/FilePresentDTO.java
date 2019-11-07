package com.fomin.ftpServer.core.DTO;

import lombok.Getter;
import org.apache.commons.io.FileUtils;
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
        this.fileType = gettingFileType(ID.getAbsolutePath());
        this.size=gettingSize();
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

    private String gettingSize(){
        long size = FileUtils.sizeOf(ID);
        if(size>1000){
            size=size/1024;//kb
            if((size/1024)>1000){
                size=size/1024;//mb
                return size/1024+" mb";
            }return size+" kb";
        }else {
            return size+" byte";
        }
    }
    private String gettingFileType(String path){
        if(new File(path).isFile()){
            return FilenameUtils.getExtension(path);
        }
        return "directory";
    }
}
