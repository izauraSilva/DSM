package br.com.claro.dsm.s3BucketStorage.repositories;

import br.com.claro.dsm.s3BucketStorage.domain.File;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface S3BucketStorageRepository extends CrudRepository<File, Long> {

    File findByTitle(String title);
}
