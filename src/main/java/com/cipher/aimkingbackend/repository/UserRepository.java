package com.cipher.aimkingbackend.repository;

import com.cipher.aimkingbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * (C) [YEAR] Cloud Eagle. All rights reserved.
 *
 * This file is the property of Cloud Eagle and may not be copied or distributed without permission.
 * Unauthorised access to this file is prohibited.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByUserNameAndPassword(String userName, String password);
}
