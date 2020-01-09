package com.fomin.ftpServer.core.DTO;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class FilePresentListDTO {
    private String currentPath;

    private List<FilePresentDTO> filePresentDTOList;
}
