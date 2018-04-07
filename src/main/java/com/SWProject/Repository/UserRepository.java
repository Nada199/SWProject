package com.SWProject.Repository;

import org.springframework.data.repository.CrudRepository;

import com.SWProject.Entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
