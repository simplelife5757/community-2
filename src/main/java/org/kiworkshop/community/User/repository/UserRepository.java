package org.kiworkshop.community.User.repository;

import org.kiworkshop.community.User.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
