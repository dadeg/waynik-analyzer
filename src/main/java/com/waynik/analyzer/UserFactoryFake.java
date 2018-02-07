package com.waynik.analyzer;
public class UserFactoryFake implements UserFactoryInterface {
    private int userIdCounter;
    private int checkinIdCounter;

    public UserFactoryFake() {
        userIdCounter = 0;
        checkinIdCounter = 0;
    }

    public User create() {
      Checkin[] checkins = getCheckinsForUser(123);

      return new User(++userIdCounter, "user" + userIdCounter + "@email.com", checkins);
    }
    
    private Checkin[] getCheckinsForUser(int userId) {
    	// TODO: replace with database call?
    	Checkin[] checkins = {
            new Checkin(++checkinIdCounter, userIdCounter, checkinIdCounter),
            new Checkin(++checkinIdCounter, userIdCounter, checkinIdCounter),
            new Checkin(++checkinIdCounter, userIdCounter, checkinIdCounter)
        };
    	
    	return checkins;
    }
}
