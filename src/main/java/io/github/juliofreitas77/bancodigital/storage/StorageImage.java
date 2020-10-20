package io.github.juliofreitas77.bancodigital.storage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class StorageImage {

    @Value("${storage.img.root}")
    private String root;

    @Value("S{storage.img.directory}")
    private String directory;

    public void saveImg(MultipartFile img) throws IOException {
        this.save(this.directory, img);
    }

    private void save(String directory, MultipartFile img) throws IOException {
        Path dirPath = Paths.get(this.root, directory);
        Path arqPath = dirPath.resolve(img.getOriginalFilename());

        Files.createDirectories(dirPath);
        img.transferTo(arqPath.toFile());

    }
}

