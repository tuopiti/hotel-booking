package com.piti.java.hotelbooking.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.piti.java.hotelbooking.model.Image;
import com.piti.java.hotelbooking.repository.ImageRepository;

@RestController
@RequestMapping("/api/images")
public class ImageController {
	@Autowired
    private ImageRepository imageRepository;

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) {
    	try {
             // Get the file name
             String fileName = file.getOriginalFilename();

             // Path to store the file in src/main/resources/images
             String filePath = "src/main/resources/images/" + fileName;

             // Create new file in src/main/resources/images
             File newFile = new File(filePath);

             // If the directory does not exist, create it
             if (!newFile.getParentFile().exists()) {
                 newFile.getParentFile().mkdirs();
             }

             // Save file to src/main/resources/images
             FileOutputStream fos = new FileOutputStream(newFile);
             fos.write(file.getBytes());
             fos.close();

             // Save the file path to the database
             Image image = new Image();
             image.setName(fileName);
             image.setPath(filePath);
             imageRepository.save(image);

             return "File uploaded successfully!";
         } catch (IOException e) {
             e.printStackTrace();
             return "Failed to upload file!";
         }
     
    }
}
