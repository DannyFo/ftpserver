package com.fomin.ftpServer.core.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;

public class FileUtil {

    public static String isExistName(String filename) {
        int counter = 0;
        while (new File(filename).exists()) {
            if (!FilenameUtils.getExtension(filename).equals("")) {
                if (counter > 0) {
                    int lenght = String.valueOf(counter).length();
                    filename = filename.substring(0, filename.lastIndexOf(".") - lenght) + counter + filename.substring(filename.lastIndexOf("."));
                } else {
                    filename = filename.substring(0, filename.lastIndexOf(".")) + counter + filename.substring(filename.lastIndexOf("."));
                }

            } else {
                if (counter > 0) {
                    int lenght = String.valueOf(counter).length();
                    filename = filename.substring(0, filename.length() - lenght) + counter;
                } else {
                    filename = filename + counter;
                }
            }
            counter++;
        }
        return filename;
    }

    public static String sizeConvert(File file) {
        long size = FileUtils.sizeOf(file);
        if (size > 1000) {
            size = size / 1024;//kb
            if ((size / 1024) > 1000) {
                size = size / 1024;//mb
                return size / 1024 + " mb";
            }
            return size + " kb";
        } else {
            return size + " byte";
        }
    }

    public static String getFileType(File file){
        if(file.isFile()){
            return FilenameUtils.getExtension(file.getAbsolutePath());
        }
        return "directory";
    }
}
