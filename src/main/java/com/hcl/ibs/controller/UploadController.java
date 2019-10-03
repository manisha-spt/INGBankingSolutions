package com.hcl.ibs.controller;



import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.ibs.dto.UploadFileResponseDto;
import com.hcl.ibs.service.UploadService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class UploadController {

	public static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@Autowired
	private UploadService uploadService;

	@PostMapping("/upload") 
	public ResponseEntity<UploadFileResponseDto> singleFileUpload(@RequestParam("file") MultipartFile file) {

		UploadFileResponseDto message=uploadService.uploadFile(file);
		
				return new ResponseEntity<>(message,HttpStatus.OK);

	}

}
