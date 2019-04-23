package org.kiworkshop.community.User.domain;

import org.junit.Test;
import org.springframework.test.web.reactive.server.JsonPathAssertions;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @Test
    public void testCreateUser() {
    /*Given 이름, 비밀번호, 이메일  */
        String name = "김지우";
        String password = "김지우짱";
        String email = "jiwoo627@naver.com";

    /* When: User domain object를 생성 */
    User user = new User(name, password, email);

    /* Then: user객체는 이름으로 조광일, 비밀번호로는 김지우짱, 이메일 주소로 ~를 가지고 있어야한다.*/
    assertThat(user.getName()).isEqualTo(name);
    assertThat(user.getName()).isEqualTo(name);
    assertThat(user.getName()).isEqualTo(name);
    }

}