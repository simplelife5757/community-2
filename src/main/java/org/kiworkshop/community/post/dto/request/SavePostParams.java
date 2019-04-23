package org.kiworkshop.community.post.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class SavePostParams {
	private String title;
	private String content;

	public SavePostParams(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
