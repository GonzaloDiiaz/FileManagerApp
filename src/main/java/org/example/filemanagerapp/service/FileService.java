package org.example.filemanagerapp.service;

import java.util.Arrays;
import java.util.List;

public class FileService {

    public List<String> getFileList() {
        return Arrays.asList("archivo1.txt", "documento.pdf", "imagen.png");
    }
}
