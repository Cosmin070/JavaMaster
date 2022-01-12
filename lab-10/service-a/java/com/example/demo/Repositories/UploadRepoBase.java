package com.example.demo.Repositories;

import com.example.demo.Models.Upload;

import java.util.List;

public interface UploadRepoBase {
    void insertUpload(Upload upload);

    List<Upload> getUploads(String author);

    void delete(Long id);

    Upload update(Upload upload);
}
