package com.waynik.analyzer;
public class User implements UserInterface {
    private int id;
    private String email;
    private Checkin[] checkins;

    public User(int id, String email, Checkin[] checkins) {
      this.id = id;
      this.email = email;
      this.checkins = checkins;
    }

    private User() {
      // make it impossible to use default constructor?
    }

    public String getEmail() {
      return email;
    }

    public Checkin[] getCheckins() {
      return checkins;
    }
}
