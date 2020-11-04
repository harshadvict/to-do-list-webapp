package dao;

import model.user;

interface userDaoInterface {
	int signup(user user);
	boolean loginUser(user user);
}
