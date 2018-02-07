package com.waynik.analyzer;
public class Checkin {
    private int id;
    private int userId;
    private int timestamp;

    public Checkin(int checkinId, int checkinUserId, int checkinTimestamp) {
      id = checkinId;
      userId = checkinUserId;
      timestamp = checkinTimestamp;
    }

    private Checkin() {
      // make it impossible to use default constructor?
    }

    public int getTimestamp() {
      return timestamp;
    }

    // public boolean isAfter(Checkin otherCheckin) {
    //   if (otherCheckin == null) {
    //     throw new Exception("must provide Checkin to compare against.");
    //   }
    //   return getTimestamp() > otherCheckin.getTimestamp();
    // }
}
