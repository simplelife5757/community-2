package org.kiworkshop.community.post.repository;

import org.kiworkshop.community.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
