package com.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.data.model.Student;

@RestController
public class HomeController {

	@Autowired
	RestTemplate rt;
	
	@GetMapping("/getcon/{pname}/{password}")
	public List data(@PathVariable("pname")String p,@PathVariable("password")String pass) {
		
		String url="http://desktop-9loaifb:9092/log/"+p+"/"+pass;
		List l = rt.getForObject(url, List.class);
		
		return l;
	}
	
	@PostMapping("/postcon")
	public String postdata(@RequestBody Student s) {
		String url="http://desktop-9loaifb:9091/reg";
		String msg = rt.postForObject(url, s, String.class);
		return msg;
	}
	
	@DeleteMapping("/delcon/{pid}")
	public void deldata(@PathVariable("pid") int id) {
		 rt.delete("http://localhost:9091/del/"+id);
		
	}
	
	@PostMapping("/updcon/{pid}")
	public String updata(@PathVariable("pid") int pid, @RequestBody Student s) {
//		mapo ="";
		String url="http://localhost:9091/update/"+pid;
		String msg = rt.postForObject(url, s, String.class);
	
		return msg;
	}

	
	
}
