package com.te.springloggerdemo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.sound.midi.Patch;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.te.springloggerdemo.FileUtils;
import com.te.springloggerdemo.LogibDto;
import com.te.springloggerdemo.Response;
import com.te.springloggerdemo.entity.Employee;
import com.te.springloggerdemo.entity.FileEntity;
import com.te.springloggerdemo.service.EmloyeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class LoggerController {

	@Autowired
	private EmloyeeService service;
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Employee employee) {
		log.info("request taken");
		if(service.register(employee)!=null) {
			log.info("request served");
			return new ResponseEntity<>("Registered Successfully", HttpStatus.ACCEPTED);
		}
		log.error("error occured while register");
		return new ResponseEntity<>("Something wrong", HttpStatus.BAD_REQUEST);
	}
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LogibDto dto) throws IOException {
		log.info("request for login taken");
		if(service.login(dto)!=null) {
			log.info("logged in ");
//			Path path=Paths.get("C:\\Users\\i c c\\Desktop\\Loggingfolder\\SLF4J.txt");
			File file=new File("C:\\Users\\i c c\\Desktop\\Loggingfolder\\SLF4J.txt");
//			FileInputStream inputStream=new FileInputStream(file);
		 	Path path=Paths.get("C:\\\\Users\\\\i c c\\\\Desktop\\\\Loggingfolder\\\\SLF4J.txt");
			byte[] allBytes = Files.readAllBytes(path);//			FileInputStream input = new FileInputStream (file);
			byte[] compressImage = FileUtils.compressImage(allBytes);
			FileEntity entity=new FileEntity(1, "login.log","text/plain", allBytes);
			log.info("LoggerFile created");
			service.storeFile(entity);
			log.info("file uploaded");
			return new ResponseEntity<>("welcome to TY and loggerFile stored", HttpStatus.ACCEPTED);
		}
		log.error("logIn failed");
		return new ResponseEntity<>("Invalid credentials ", HttpStatus.BAD_REQUEST);
	}
	
	public Response getLogger() {
		return null;
}
	
	@GetMapping("/getLogger/{fileName}")
	public ResponseEntity<?> getLoggerFile(@PathVariable String fileName) throws IOException {
		log.info("request for logFile taken");
		byte[] file = service.getFile(fileName);
		log.info("logFile recieved");
//	 byte[] decompressImage = FileUtils.decompressImage(file);
//		 FileInputStream input = new FileInputStream (file);
//		 Path path=Paths.get(file.getAbsolutePath());
//		 byte[] content=Files.readAllBytes(path);
//		 MultipartFile multipartFile= new MockMultipartFile();
//		 DiskFileItem fileItem = new DiskFileItem("file", "text/plain", false, file.getName(), (int) file.length() , file.getParentFile());
//		 fileItem.getOutputStream();
//		 MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
		 
		 log.info("converting into partfile");
//		 MultipartFile multipartFile=new BASE64DecodedMultipartFile(decompressImage);
		 log.info("multipartFile sent to front end");
		 return new ResponseEntity<>(file, HttpStatus.CONTINUE);
	}
//	@GetMapping("/loggerLink")
//	public String loggerLink(ModelMap map) {
//		return "/springLoggerdemo/src/main/META-INF/views/logger.jsp";
//	}
}
