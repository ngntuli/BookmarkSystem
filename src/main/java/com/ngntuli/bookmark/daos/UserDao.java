package com.ngntuli.bookmark.daos;

import com.ngntuli.bookmark.config.DataStore;
import com.ngntuli.bookmark.models.User;

public class UserDao {
	public User[] getUsers() {
		return DataStore.getUsers();
	}
}
