package com.tbh.real.time.notifications.repository;

import com.tbh.real.time.notifications.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
    Users getUserByUsername(String username);
}
