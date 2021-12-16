import java.time.*;

public class TimeProblems {

    public static int countFridayThirteens(LocalDate start, LocalDate end) {
        int fridayTheThirteenthCounter = 0;

        while (start.isAfter(end) == false) { // while loop will keep running until start is after end date
            // if Friday the 13th...
            if (start.getDayOfMonth() == 13 && start.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                fridayTheThirteenthCounter += 1; // add 1 to counter
            }
            start = start.plusDays(1);  // add 1 to the start day
        }

        return fridayTheThirteenthCounter;
    }

    public static String dayAfterSeconds(LocalDateTime timeHere, long seconds) {
        return timeHere.plusSeconds(seconds).getDayOfWeek().toString();
    }

    public static int whatHourIsItThere(LocalDateTime timeHere, String here, String there) {
        ZonedDateTime timeHere2 = ZonedDateTime.of(timeHere, ZoneId.of(here));
        // ZonedDateTime - Returns a copy of this date-time with a different time-zone, retaining the local date-time if possible.
        return timeHere2.withZoneSameInstant(ZoneId.of(there)).getHour();

    }
}