package org.kiworkshop.community.User.Exercise;

import org.kiworkshop.community.User.domain.User;
import org.kiworkshop.community.User.dto.request.SaveUserParams;
import org.kiworkshop.community.User.dto.response.UserDetailResponse;
import org.kiworkshop.community.User.dto.response.UserListResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceexercise {
	private final UserInMemoryRepositoryexercise userInMemoryRepository;

	public UserServiceexercise(UserInMemoryRepositoryexercise userInMemoryRepository) {
		this.userInMemoryRepository = userInMemoryRepository;
	}

	//void 처리하는 이유 : CQS 조작과 조회는 분리한다.
	public void saveUser(SaveUserParams userParams) {
		userInMemoryRepository.save(userParams.getName(), userParams.getPassword(), userParams.getEmail());
	}

	public User getUserByName(String name) {
		return userInMemoryRepository.getUserByName(name);
	}

	public Long getUserCount() {
		return userInMemoryRepository.getUserCount();
	}

	public UserListResponse getUsers() {
		List<User> users = userInMemoryRepository.getUsers();
		List<UserDetailResponse> userDetails = users.stream().map(user -> new UserDetailResponse(user.getName(), user.getEmail())).collect(Collectors.toList());
		return new UserListResponse(userDetails);
	}
}
