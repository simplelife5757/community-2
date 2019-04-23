package org.kiworkshop.community.User.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class SaveUserParams {
	private String name;
	private String password;
	private String email;

	public SaveUserParams(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}
}
