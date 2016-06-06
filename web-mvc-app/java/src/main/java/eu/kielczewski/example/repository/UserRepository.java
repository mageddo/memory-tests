package eu.kielczewski.example.repository;

import eu.kielczewski.example.domain.User;

import java.util.List;

public interface UserRepository  {

	User findOne(String id);

	User save(User user);

	List<User> findAll();
}
