package org.kiworkshop.community.User.Controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kiworkshop.community.User.dto.request.SaveUserParams;
import org.kiworkshop.community.User.dto.response.UserListResponse;
import org.kiworkshop.community.User.service.UserService;
import org.springframework.web.bind.annotation.*;


//@RequestMapping("/api/v2/user") 이런식으로 버전도 명시해주기도 한다.
@Slf4j
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserRestController {
	private final UserService userService;

//	public UserRestController(UserService userService) {
//		this.userService = userService;
//	}

	@GetMapping
	public UserListResponse getUsers(){
		return userService.getUsers();
	}

	@PostMapping
	public void saveUser(@RequestBody SaveUserParams userParams){
		log.info("save user request userParams={}", userParams);
		userService.saveUser(userParams);
	}
}
