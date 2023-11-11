package com.programacionIV.proyectoFinal.api;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.UrlResource;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

	private String getContentTypeByExtension(String extension) {
		switch (extension.toLowerCase()) {
		case "jpg":
		case "jpeg":
			return MediaType.IMAGE_JPEG_VALUE;
		case "png":
			return MediaType.IMAGE_PNG_VALUE;
		case "gif":
			return MediaType.IMAGE_GIF_VALUE;
		default:
			return MediaType.APPLICATION_OCTET_STREAM_VALUE; // Tipo de contenido default
																
		}
	}

	String basePath = "src/main/resources/static/Imagenes/";

	@GetMapping("/img")
	public ResponseEntity<Resource> printImage(@RequestParam(name = "imageRootName",required = true) String imageName) {
		String extension = FilenameUtils.getExtension(imageName);

		try {
			Path imagePath = Paths.get(basePath).resolve(imageName);
			Resource resource = new UrlResource(imagePath.toUri());

			if (resource.exists() && resource.isReadable()) {
				return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, getContentTypeByExtension(extension))
						.body(resource);
			} else {
				return ResponseEntity.notFound().build();
			}

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

}
