package com.fomin.ftpServer.core.DTO;

import java.io.File;

public class FilePresent {
    private File ID ;//тут наверное лучше иметь абсолютный путь, чтобы привязаться к заметке
    private String fileName;
    private String fileType;
    private boolean isWithNote;
    private String size;
    private String uri;
    private int countNotes;
}
