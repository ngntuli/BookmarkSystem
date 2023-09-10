package com.ngntuli.bookmark.utilities;

public enum Gender {

	MALE(0), FEMALE(1), TRANSGENDER(2);

	private int value;

	public int getValue() {
		return value;
	}

	private Gender(int value) {
		this.value = value;
	}
}
