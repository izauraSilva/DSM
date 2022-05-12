package br.com.claro.dsm.s3BucketStorage.service;

import br.com.claro.dsm.s3BucketStorage.domain.File;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface S3BucketStorageService {

    String uploadFile(String keyName, MultipartFile file);

    File saveTodo(String title, String description, MultipartFile file);

    byte[] downloadTodoImage(Long id);

    List<File> getAllTodos();
}
