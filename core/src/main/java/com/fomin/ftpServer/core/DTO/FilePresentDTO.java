package com.fomin.ftpServer.core.DTO;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.File;

@Data
@Accessors(chain = true)
public class FilePresentDTO {

    private File ID ;
    private String fileName;
    private String fileType;
    private String size;
    private String uri;
    private int countNotes;

//    public FilePresentDTO(File ID, int countNotes) {
//        this.ID = ID;
//        this.fileName = FilenameUtils.getBaseName(ID.getAbsolutePath());
//        this.fileType = FileUtil.getFileType(ID);
//        this.size= FileUtil.sizeConvert(ID);
//        this.countNotes = countNotes;
//        setUri();
//    }

//    private void setUri(){
//        try {
//            this.uri= URLEncoder.encode(ID.toString(), StandardCharsets.UTF_8.toString());
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }
}
