package com.dxc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserId(Long userId);

}
