package org.kiworkshop.community.User.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kiworkshop.community.User.domain.User;
import org.kiworkshop.community.User.dto.request.SaveUserParams;
import org.kiworkshop.community.User.dto.response.UserListResponse;
import org.kiworkshop.community.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@After
	public void tearDown() throws Exception {
		userRepository.deleteAll();
	}

	@Test
	public void 유저_생성하기() {
		/*Given */
		String name = "김지우";
		String password = "김지우짱";
		String email = "jiwoo627@naver.com";
		SaveUserParams saveUserParams = new SaveUserParams(name, password, email);

		//When : UserService.saveUser를 호출하여 저장한다.
		Long userId = userService.saveUser(saveUserParams);

		//Then: 저장하려고 했던 saveUserParams 데이터와 같아야한다.
		User resultUser = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
		assertThat(resultUser.getName()).isEqualTo(name);
		log.info(userRepository.toString());
	}

	@Test
	public void 유저_목록_조회하기() {
		// 3명의 유저에 대한 saveUserParams 생성
		SaveUserParams saveUserParams1 = new SaveUserParams("조광일", "비밀번호", "kwangilcho@naver.com" );
		SaveUserParams saveUserParams2 = new SaveUserParams("김지우", "486", "jiwoo627@naver.com" );

		userService.saveUser(saveUserParams1);
		userService.saveUser(saveUserParams2);

		// when : userService.getUsers를 호출한다.
		UserListResponse users = userService.getUsers();

		// then : 조회된 유저 전체 목록의 크기가 2인지 검증
		assertThat(users.getUsers().size()).isEqualTo(2);
	}
}
