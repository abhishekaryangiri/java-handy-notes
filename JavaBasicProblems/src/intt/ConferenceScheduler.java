package intt;

import java.util.*;

public class ConferenceScheduler {

    private static final int MORNING_START = 9 * 60; // 9:00 AM in minutes
    private static final int LUNCH_TIME = 12 * 60; // 12:00 PM (noon) in minutes
    private static final int AFTERNOON_START = 13 * 60; // 1:00 PM in minutes
    private static final int NETWORKING_EVENT_START = 16 * 60; // 4:00 PM in minutes
    private static final int NETWORKING_EVENT_END = 17 * 60; // 5:00 PM in minutes

    static class Talk {
        String title;
        int duration; // in minutes

        public Talk(String title, int duration) {
            this.title = title;
            this.duration = duration;
        }

        @Override
        public String toString() {
            return title + " " + (duration == 5 ? "lightning" : duration + "min");
        }
    }

    private static String formatTime(int minutes) {
        int hour = minutes / 60;
        int minute = minutes % 60;
        String period = (hour < 12) ? "AM" : "PM";
        if (hour > 12) hour -= 12;
        if (hour == 0) hour = 12;
        return String.format("%02d:%02d%s", hour, minute, period);
    }

    private static List<List<Talk>> scheduleConference(List<Talk> talks) {
        talks.sort((t1, t2) -> Integer.compare(t2.duration, t1.duration)); // Sort talks by duration (longest first)

        List<List<Talk>> tracks = new ArrayList<>();
        Set<Talk> usedTalks = new HashSet<>();
        
        // Create Track 1 and Track 2
        List<Talk> track1 = new ArrayList<>();
        List<Talk> track2 = new ArrayList<>();
        
        // Track 1: Morning and Afternoon sessions
        int currentTime = MORNING_START;
        for (Talk talk : talks) {
            if (!usedTalks.contains(talk) && currentTime + talk.duration <= LUNCH_TIME) {
                track1.add(talk);
                usedTalks.add(talk);
                currentTime += talk.duration;
            }
        }

        // Track 1: Afternoon session (before networking event)
        currentTime = AFTERNOON_START;
        for (Talk talk : talks) {
            if (!usedTalks.contains(talk) && currentTime + talk.duration <= NETWORKING_EVENT_START) {
                track1.add(talk);
                usedTalks.add(talk);
                currentTime += talk.duration;
            }
        }
        
        // Add Networking Event at 5:00 PM
        track1.add(new Talk("Networking Event", 60));
        tracks.add(track1);

        // Track 2: Morning and Afternoon sessions
        currentTime = MORNING_START;
        for (Talk talk : talks) {
            if (!usedTalks.contains(talk) && currentTime + talk.duration <= LUNCH_TIME) {
                track2.add(talk);
                usedTalks.add(talk);
                currentTime += talk.duration;
            }
        }

        // Track 2: Afternoon session (before networking event)
        currentTime = AFTERNOON_START;
        for (Talk talk : talks) {
            if (!usedTalks.contains(talk) && currentTime + talk.duration <= NETWORKING_EVENT_START) {
                track2.add(talk);
                usedTalks.add(talk);
                currentTime += talk.duration;
            }
        }

        // Add Networking Event at 5:00 PM
        track2.add(new Talk("Networking Event", 60));
        tracks.add(track2);

        return tracks;
    }

    private static void printSchedule(List<List<Talk>> tracks) {
        int trackNumber = 1;
        for (List<Talk> track : tracks) {
            System.out.println("Track " + trackNumber + ":");
            int currentTime = MORNING_START;

            // Print morning session
            for (Talk talk : track) {
                System.out.println(formatTime(currentTime) + " " + talk);
                currentTime += talk.duration;
                if (currentTime >= LUNCH_TIME) break;
            }

            System.out.println(formatTime(LUNCH_TIME) + " Lunch");

            // Print afternoon session
            currentTime = AFTERNOON_START;
            for (Talk talk : track) {
                if (currentTime >= NETWORKING_EVENT_START) break;
                System.out.println(formatTime(currentTime) + " " + talk);
                currentTime += talk.duration;
            }

            // Print Networking Event
            System.out.println(formatTime(NETWORKING_EVENT_START) + " Networking Event");
            trackNumber++;
        }
    }

    public static void main(String[] args) {
        List<Talk> talks = new ArrayList<>();
        talks.add(new Talk("Writing Fast Tests Against Enterprise Rails", 60));
        talks.add(new Talk("Overdoing it in Python", 45));
        talks.add(new Talk("Lua for the Masses", 30));
        talks.add(new Talk("Ruby Errors from Mismatched Gem Versions", 45));
        talks.add(new Talk("Common Ruby Errors", 45));
        talks.add(new Talk("Rails for Python Developers", 5)); // lightning talk
        talks.add(new Talk("Communicating Over Distance", 60));
        talks.add(new Talk("Accounting-Driven Development", 45));
        talks.add(new Talk("Woah", 30));
        talks.add(new Talk("Sit Down and Write", 30));
        talks.add(new Talk("Pair Programming vs Noise", 45));
        talks.add(new Talk("Rails Magic", 60));
        talks.add(new Talk("Ruby on Rails: Why We Should Move On", 60));
        talks.add(new Talk("Clojure Ate Scala (on my project)", 45));
        talks.add(new Talk("Programming in the Boondocks of Seattle", 30));
        talks.add(new Talk("Ruby vs. Clojure for Back-End Development", 30));
        talks.add(new Talk("Ruby on Rails Legacy App Maintenance", 60));
        talks.add(new Talk("A World Without HackerNews", 30));
        talks.add(new Talk("User Interface CSS in Rails Apps", 30));

        List<List<Talk>> tracks = scheduleConference(talks);
        printSchedule(tracks);
    }
}
