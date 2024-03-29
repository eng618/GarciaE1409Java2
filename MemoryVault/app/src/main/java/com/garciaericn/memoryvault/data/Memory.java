package com.garciaericn.memoryvault.data;

import android.os.Bundle;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Full Sail University
 * Mobile Development BS
 * Created by ENG618-Mac on 9/16/14.
 */
public class Memory implements Serializable {
    public static final long serialVersionUID = 2357817694738294783L;

    // Constants for field references
    public static final String EVENT_NAME = "com.garciaericn.memoryvault.EVENTNAME";
    public static final String NUM_GUESTS = "com.garciaericn.memoryvault.NUMGUESTS";
    public static final String EVENT_LOCATION = "com.garciaericn.memoryvault.EVENTLOCATION";
    public static final String EVENT_NOTES = "com.garciaericn.memoryvault.NOTES";
    public static final String EVENT_KEY = "com.garciaericn.memoryvault.KEY";

    // Privet fields
    private String eventName;
    private int numGuests;
    private String eventLocation;
    private String eventNotes;
    private String memoryKey;

    // Construct memory object
    public Memory(String name, int guests, String location, String notes) {
        this.eventName = name;
        this.numGuests = guests;
        this.eventLocation = location;
        this.eventNotes = notes;

//        long longKey = System.currentTimeMillis();
        this.memoryKey = generateKey();
    }

    // Random key generator
    private String generateKey() {
        SecureRandom random = new SecureRandom();

        return new BigInteger(130, random).toString(32);
    }

    // Getter and Setter methods

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getNumGuests() {
        return numGuests;
    }

    public void setNumGuests(int numGuests) {
        this.numGuests = numGuests;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventNotes() {
        return eventNotes;
    }

    public void setEventNotes(String eventNotes) {
        this.eventNotes = eventNotes;
    }

    public String getMemoryKey() {
        return memoryKey;
    }

    public void setMemoryKey(String memoryKey) {
        this.memoryKey = memoryKey;
    }

    // Bundle memory object
    public Bundle toBundle() {
        Bundle b = new Bundle();
        b.putString(EVENT_NAME, this.eventName);
        b.putInt(NUM_GUESTS, this.numGuests);
        b.putString(EVENT_LOCATION, this.eventLocation);
        b.putString(EVENT_NOTES, this.eventNotes);
        b.putString(EVENT_KEY, this.memoryKey);
        return b;
    }

    // Create memory object from bundle
    public Memory(Bundle b) {
        if (b != null) {
            this.eventName = b.getString(EVENT_NAME);
            this.numGuests = b.getInt(NUM_GUESTS);
            this.eventLocation= b.getString(EVENT_LOCATION);
            this.eventNotes = b.getString(EVENT_NOTES);
            this.memoryKey = b.getString(EVENT_KEY);
        }
    }
}
