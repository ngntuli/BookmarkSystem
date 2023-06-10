package com.ngntuli.bookmark.daos;

import com.ngntuli.bookmark.databases.DataStore;
import com.ngntuli.bookmark.models.User;

public class UserDao {
	public User[] getUsers() {
		return DataStore.getUsers();
	}
}
