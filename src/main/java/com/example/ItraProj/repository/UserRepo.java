package com.example.ItraProj.repository;

import com.example.ItraProj.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {

}
