package vacationCalculator.filter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class HolidayAndWeekendFilterTest {

    @Test
    @DisplayName("Check true for a Saturday")
    public void testIsHolidayOrWeekend_OnSaturday() {
        LocalDate saturday = LocalDate.of(2024, 10, 5);
        assertTrue(HolidayAndWeekendFilter.isHolidayOrWeekend(saturday));
    }

    @Test
    @DisplayName("Check true for a Sunday")
    public void testIsHolidayOrWeekend_OnSunday() {
        LocalDate sunday = LocalDate.of(2024, 10, 6);
        assertTrue(HolidayAndWeekendFilter.isHolidayOrWeekend(sunday));
    }

    @Test
    @DisplayName("Check true for a Holiday")
    public void testIsHolidayOrWeekend_OnHoliday() {
        LocalDate holiday = LocalDate.of(2024, 12, 31);
        assertTrue(HolidayAndWeekendFilter.isHolidayOrWeekend(holiday));
    }

    @Test
    @DisplayName("Check false for a non-Holiday day")
    public void testIsHolidayOrWeekend_OnNonHolidayWeekday() {
        LocalDate weekday = LocalDate.of(2024, 10, 7);
        assertFalse(HolidayAndWeekendFilter.isHolidayOrWeekend(weekday));
    }
}