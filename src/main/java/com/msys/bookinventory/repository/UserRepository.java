package com.msys.bookinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msys.bookinventory.model.User;

@Repository
public interface UserRepository  extends JpaRepository<User,Long>{

	User getUserByUsername(String username); 

}
