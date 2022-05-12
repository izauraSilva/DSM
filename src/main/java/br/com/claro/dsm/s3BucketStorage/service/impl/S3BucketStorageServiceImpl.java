package br.com.claro.dsm.s3BucketStorage.service.impl;

import br.com.claro.dsm.s3BucketStorage.domain.File;
import br.com.claro.dsm.s3BucketStorage.repositories.S3BucketStorageRepository;
import br.com.claro.dsm.s3BucketStorage.service.S3BucketStorageService;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class S3BucketStorageServiceImpl implements S3BucketStorageService {

    @Autowired
    private AmazonS3 amazonS3Client;

    private final FileStore fileStore;
    private final S3BucketStorageRepository repository;

    public S3BucketStorageServiceImpl(FileStore fileStore, S3BucketStorageRepository repository) {
        this.fileStore = fileStore;
        this.repository = repository;
    }

    @Value("${aws.bucketName}")
    private String bucketName;

    /**
     * Upload file into AWS S3
     *
     * @param keyName
     * @param file
     * @return String
     */
    @Override
    public String uploadFile(String keyName, MultipartFile file) {
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            amazonS3Client.putObject(bucketName, keyName, file.getInputStream(), metadata);
            return "File uploaded: " + keyName;
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe.getMessage());
        } catch (AmazonServiceException serviceException) {
            System.out.println("AmazonServiceException: "+ serviceException.getMessage());
            throw serviceException;
        } catch (AmazonClientException clientException) {
            System.out.println("AmazonClientException Message: " + clientException.getMessage());
            throw clientException;
        }
        return "File not uploaded: " + keyName;
    }

    @Override
    public File saveTodo(String title, String description, MultipartFile file) {

        //check if the file is empty
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file");
        }

        //Check if the file is an image
        /*if (!Arrays.asList(IMAGE_PNG.getMimeType(),
                IMAGE_BMP.getMimeType(),
                IMAGE_GIF.getMimeType(),
                IMAGE_JPEG.getMimeType()).contains(file.getContentType())) {
            throw new IllegalStateException("FIle uploaded is not an image");
        }*/

        //get file metadata
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));

        //Save Image in S3 and then save Todo in the database
        String path = String.format("%s/%s", bucketName, UUID.randomUUID());
        String fileName = String.format("%s", file.getOriginalFilename());
        try {
            fileStore.upload(path, fileName, Optional.of(metadata), file.getInputStream());
        } catch (IOException e) {
            throw new IllegalStateException("Failed to upload file", e);
        }

        File strFile = File.builder()
                .description(description)
                .title(title)
                .imagePath(path)
                .imageFileName(fileName)
                .build();
        repository.save(strFile);
        return repository.findByTitle(strFile.getTitle());
    }

    @Override
    public byte[] downloadTodoImage(Long id) {
        File file = repository.findById(id).get();
        return fileStore.download(file.getImagePath(), file.getImageFileName());
    }

    @Override
    public List<File> getAllTodos() {
        List<File> todos = new ArrayList<>();
        repository.findAll().forEach(todos::add);
        return todos;
    }
}
