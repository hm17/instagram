package com.hm17.instagram.friends;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendsService {

	@Autowired
	private FriendsRepository friendsRepository;
	
	public Iterable<Friends> getAllFriends() {
		return friendsRepository.findAll();
	}

	public void add(String owner, String friend) throws Exception{
		// Data validation
		if(owner.equals("") || friend.equals(""))
			throw new Exception("Owner or Friend cannot be empty.");
		
		// Check if friends list already exists
		List<Friends> existingFriends = friendsRepository.findByOwner(owner);
		
		Friends updatedFriends = new Friends();
		if(!existingFriends.isEmpty()) {
			updatedFriends = existingFriends.get(0);	
		} else {
			// Create new friends list
			updatedFriends.setOwner(owner);
		}
		
		// add one friend and save
		updatedFriends.addFriend(friend);
		friendsRepository.save(updatedFriends);
	}
}
