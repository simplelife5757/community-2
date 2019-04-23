package org.kiworkshop.community.User.Exercise;

import org.kiworkshop.community.User.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserInMemoryRepositoryexercise {
	private List<User> users = new ArrayList<>();

	public void save(String name, String password, String email){
		if (!existsUserByEmail(email)){
			users.add(new User(name, password, email));
		}
	}

	//존재유무 코드가 조회성 코드보다 낫다.
	private  Boolean existsUserByEmail(String email){
		for (User user : users){
			if (user.getEmail().equals(email)){
				return true;
			}
		}
		return false;
	}

//없을 때 유저가 없다는 에러가 뜨는게 제일 좋다.
	public User getUserByName(String name) {
		for (User user : users){
			if (user.getName().equals(name)){
				return user;
			}
		}
		return null;
	}

	public Long getUserCount() {
		return (long) users.size();
	}

	public List<User> getUsers() {
		return users;
	}
}





//	public void save2(String name, String password, String email){
//		User user = new User(name, password, email);
//		if (!users.contains(user)){
//		users.add(user);
//		}
//	}
