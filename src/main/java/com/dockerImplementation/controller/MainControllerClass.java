package com.dockerImplementation.controller;

import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1")
public class MainControllerClass {

	@PostMapping("/fileoperation/readwrite")
	public String mapFunction(@RequestParam("file") MultipartFile file) {
		try {
		byte[] byteValue = file.getBytes();
		String str = new String(byteValue, StandardCharsets.UTF_8);
		System.out.println(str);
		File newFile = new File("Naveen.txt");
		if(newFile.createNewFile()) {
			System.out.println("New File Created");
		}
		else {
			System.out.println("File Exists");
		}
		FileWriter writeFile = new FileWriter("Naveen.txt");
		
		writeFile.write(str);
		
		writeFile.close();
		}
		catch(Exception err) {
			System.out.println(err);
		}
		return "Welcome";
	}
	
	@GetMapping("/getdata")
	public String getData() {
		return "Data Returned";
	}
	
}
