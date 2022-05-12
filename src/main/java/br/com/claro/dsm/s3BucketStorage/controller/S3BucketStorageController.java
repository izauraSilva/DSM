package br.com.claro.dsm.s3BucketStorage.controller;

import br.com.claro.dsm.s3BucketStorage.domain.File;
import br.com.claro.dsm.s3BucketStorage.service.S3BucketStorageService;
import br.com.claro.dsm.s3BucketStorage.service.impl.S3BucketStorageServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/s3")
@CrossOrigin("*")
public class S3BucketStorageController {

    S3BucketStorageService s3BucketStorageService;

    public S3BucketStorageController(S3BucketStorageService s3BucketStorageService) {
        this.s3BucketStorageService = s3BucketStorageService;
    }

    @PostMapping("/file/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("fileName") String fileName,
                                             @RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(s3BucketStorageService.uploadFile(fileName, file), HttpStatus.OK);
    }

    @PostMapping(
            path = "",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<File> saveTodo(@RequestParam("title") String title,
                                         @RequestParam("description") String description,
                                         @RequestParam("file") MultipartFile file) {

        return new ResponseEntity<>(s3BucketStorageService
                .saveTodo(title, description, file), HttpStatus.OK);
    }

}
