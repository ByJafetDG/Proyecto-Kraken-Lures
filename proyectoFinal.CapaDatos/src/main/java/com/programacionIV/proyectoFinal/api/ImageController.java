package com.programacionIV.proyectoFinal.api;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

	/**
	 * Ruta base luego de la carpeta principal del proyecto
	 */
	String basePath = "src/main/resources/static/Imagenes/";

	/**
	 * Metodo que se utiliza para clasificar el tipo de extension de la imagen que
	 * se devolverá en la respuesta del api
	 *
	 * @param extension recibe la extensión de la imagen que se desea identificar
	 * @return tipo de imagen correspondiente
	 */
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

	@GetMapping("/img")
	public ResponseEntity<Resource> printImage(
			@RequestParam(name = "imageRootName", required = true) String imageName) {
		/**
		 * Recibe el nombre de la imagen y mediante el metodo de la libreria
		 * FilenameUtils obtiene la extensión de esa imagen (tipo de imagen)
		 */
		String extension = FilenameUtils.getExtension(imageName);

		try {
			/**
			 * Se utiliza el objeto path para crear una ruta en base al basePath y la ruta o
			 * nombre de la imagen recibida. El método resolve() agrega la ruta de la imagen
			 * a la ruta base y crea un objeto Path
			 */
			Path imagePath = Paths.get(basePath).resolve(imageName);
			/**
			 * Se crea el objeto tipo resource que representa la imagen del servidor. El
			 * método toUri() convierte el objeto Path en un objeto URI. Un URI (Uniform
			 * Resource Identifier) es una secuencia de caracteres que identifica un recurso
			 * de manera única. En este contexto, se utiliza para crear la URL de la imagen
			 * en el servidor. La implementación UrlResource se utiliza para crear un objeto
			 * tipo UrlResource con la URI de la imagen que se construyó anteriormente.
			 */
			Resource resource = new UrlResource(imagePath.toUri());
			/**
			 * Verifica si el resource(ruta de la imagen creada) existe y el servidor puede
			 * leerla (a nivel de permsisos) Si existe, devuelve una respusta 200 del api
			 * con un header que representará el tipo de contenido (tipo de imagen) y el
			 * body de la respuesta que será la imagen obtenida
			 */
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
