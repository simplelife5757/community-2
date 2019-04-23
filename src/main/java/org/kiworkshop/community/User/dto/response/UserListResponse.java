package org.kiworkshop.community.User.dto.response;

import lombok.Getter;

import java.util.List;

@Getter
public class UserListResponse {
	private List<UserDetailResponse> users;

	public UserListResponse(List<UserDetailResponse> users) {
		this.users = users;
	}
}
