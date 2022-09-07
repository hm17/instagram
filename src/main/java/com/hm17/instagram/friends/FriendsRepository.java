package com.hm17.instagram.friends;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FriendsRepository extends CrudRepository<Friends, Integer>{

	List<Friends> findByOwner(String owner);
}
