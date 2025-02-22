package org.example.filemanagerapp.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileManagerController {
    public List<File> searchFiles(File directory, String searchTerm) {
        List<File> results = new ArrayList<>();
        if (directory.isDirectory()) {
            searchFilesRecursive(directory, searchTerm, results);
        }
        return results;
    }

    private void searchFilesRecursive(File directory, String searchTerm, List<File> results) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    searchFilesRecursive(file, searchTerm, results);
                } else if (file.getName().toLowerCase().contains(searchTerm.toLowerCase())) {
                    results.add(file);
                }
            }
        }
    }
}