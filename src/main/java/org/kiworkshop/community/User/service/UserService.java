package org.kiworkshop.community.User.service;

import lombok.RequiredArgsConstructor;
import org.kiworkshop.community.User.domain.User;
import org.kiworkshop.community.User.dto.request.SaveUserParams;
import org.kiworkshop.community.User.dto.response.UserDetailResponse;
import org.kiworkshop.community.User.dto.response.UserListResponse;
import org.kiworkshop.community.User.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
//
//	public UserService(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}

	//void 처리하는 이유 : CQS 조작과 조회는 분리한다.
	//절충안 : ID 내려주기
	public Long saveUser(SaveUserParams userParams) {
		User user = userRepository.save(new User(userParams.getName(), userParams.getPassword(), userParams.getEmail()));
		return user.getId();
	}


	public Long getUserCount() {
		return userRepository.count();
	}

	public UserListResponse getUsers() {
		return new UserListResponse(userRepository.findAll().stream()
				.map(user -> new UserDetailResponse(user.getName(), user.getEmail()))
				.collect(Collectors.toList()));
	}

	public User findUserById(Long userId) {
		return userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
	}
}
