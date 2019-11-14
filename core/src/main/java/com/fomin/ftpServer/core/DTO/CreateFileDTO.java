package com.fomin.ftpServer.core.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreateFileDTO {
    private  FilePresentation filePresentation;
    public String getFileName(){
        return filePresentation.getFileName();
    }
    public String getFileType(){
        return filePresentation.getFileType();
    }
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter

    class FilePresentation{
        private String fileName;
        private String fileType;
    }
}
