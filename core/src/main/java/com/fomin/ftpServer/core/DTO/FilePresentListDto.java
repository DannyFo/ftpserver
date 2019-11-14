package com.fomin.ftpServer.core.DTO;

import lombok.Getter;

import java.util.List;

@Getter
public class FilePresentListDto {

    private String currentPath;

    private List<FilePresentDTO> filePresentDTOList;

    public FilePresentListDto(String currentPath){

    }

}
