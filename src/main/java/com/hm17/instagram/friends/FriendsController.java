package com.hm17.instagram.friends;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/instagram/api/friends")
public class FriendsController {
	
	@Autowired
	private FriendsService friendsService;
	
	@GetMapping
	public @ResponseBody Iterable<Friends> getAllFriends() {
		return friendsService.getAllFriends();
	}
	
	@PostMapping(path="/add")
	public @ResponseBody String addFriend(@RequestParam String owner,
			@RequestParam String friend) throws Exception {
		friendsService.add(owner, friend);
		return "Added new friend.";
	}

}
