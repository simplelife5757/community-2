package org.kiworkshop.community.post.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kiworkshop.community.post.dto.request.SavePostParams;
import org.kiworkshop.community.post.service.PostService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/posts")
public class PostRestController {
	private final PostService postService;

	@PostMapping
	public void savePost(@RequestBody SavePostParams postParams){
		log.info("save post request postParams={}", postParams);
		postService.savePost(postParams, null);
	}
}
