package com.rsets.stark01.repo;

import com.rsets.stark01.models.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {
}
