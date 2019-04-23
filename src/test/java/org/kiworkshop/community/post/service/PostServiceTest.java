package org.kiworkshop.community.post.service;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kiworkshop.community.User.service.UserService;
import org.kiworkshop.community.post.domain.Post;
import org.kiworkshop.community.User.domain.User;
import org.kiworkshop.community.post.dto.request.SavePostParams;
import org.kiworkshop.community.User.dto.request.SaveUserParams;
import org.kiworkshop.community.post.repository.PostRepository;
import org.kiworkshop.community.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {
	@Autowired
	private PostService postService;
	@Autowired
	private UserService userService;

	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UserRepository userRepository;

	@After
	public void tearDown() throws Exception {
		userRepository.deleteAll();
		postRepository.deleteAll();
	}

	@Test
	public void 글_작성하기() {
		//given
		SaveUserParams saveUserParams = new SaveUserParams("유저 이름", "비밀번호", "이메일 주소");
		Long userId = userService.saveUser(saveUserParams);
		User user = userService.findUserById(userId);
		SavePostParams savePostParams = new SavePostParams("제목", "내용");

		//when
		Long postId = postService.savePost(savePostParams, user);

		//then
		Post post = postRepository.findById(postId).orElseThrow(IllegalArgumentException::new);
		assertThat(post.getTitle()).isEqualTo(savePostParams.getTitle());
	}
}