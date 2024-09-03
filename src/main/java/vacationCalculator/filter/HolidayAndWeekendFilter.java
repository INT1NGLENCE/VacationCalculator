package vacationCalculator.filter;

import vacationCalculator.model.Holiday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class HolidayAndWeekendFilter{

    private static final List<Holiday> holidays = Arrays.asList(
            new Holiday(LocalDate.of(2024, 12 , 31), "New Year's Day"),
            new Holiday(LocalDate.of(2024, 11, 3), "Independence Day")
    );

    public static boolean isHolidayOrWeekend(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY
                || date.getDayOfWeek() == DayOfWeek.SUNDAY
                || holidays.stream().anyMatch(holiday -> holiday.getHolidayDate().equals(date));
    }
}
