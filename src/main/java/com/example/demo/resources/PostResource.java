package com.example.demo.resources;

import java.net.URI;
import java.net.URLDecoder;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.resources.util.URL;
import com.example.demo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	
	@RequestMapping(value = "/titlesearch", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) {
		
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
			
		return ResponseEntity.ok().body(list);
	}	
	

}
