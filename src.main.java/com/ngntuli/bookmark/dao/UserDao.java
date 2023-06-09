package com.ngntuli.bookmark.dao;

import com.ngntuli.bookmark.DataStore;
import com.ngntuli.bookmark.entities.User;

public class UserDao {
	public User[] getUsers() {
		return DataStore.getUsers();
	}
}
