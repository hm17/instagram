package com.hm17.instagram.friends;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Friends {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String owner;
	private String[] friends;
	
	public Friends() {}
	
	public Friends(String owner, String[] friends) {
		this.owner = owner;
		this.friends = friends;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String[] getFriends() {
		return friends;
	}
	public void setFriends(String[] friends) {
		this.friends = friends;
	}
	
	public void addFriend(String friend) {
		
		int numFriends = 0;
		if(friends != null)
			numFriends = friends.length;
		
		String[] updatedList = new String[numFriends + 1];
		
		if( numFriends > 0) {
			for(int i=0; i<numFriends; i++) {
				updatedList[i] = friends[i];
			}
		}
		updatedList[numFriends] = friend;
		friends = updatedList;
	}
	
	

}
