package com.fomin.ftpServer.core.DTO;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.File;
import java.util.List;

@Data
@Accessors(chain = true)
public class FilePresentListDTO {
    private File currentPath;

    private List<FilePresentDTO> filePresentDTOList;
}
