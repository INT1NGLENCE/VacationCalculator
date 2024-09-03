package vacationCalculator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import vacationCalculator.dto.VacationRequest;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class VacationCalculatorServiceTest {
    @InjectMocks
    private VacationCalculatorService vacationCalculatorService;

    private VacationRequest request;

    @BeforeEach
    public void setUp() {
        request = new VacationRequest();
        request.setAverageSalary(120000.0);
    }

    @Test
    @DisplayName("Test weekends and holidays")
    public void testCalculateVacationPay_WithWeekendsAndHolidays() {
        request.setVacationDays(7);
        request.setPeriodVacation(Arrays.asList(
                LocalDate.of(2024, 12, 25),
                LocalDate.of(2025, 1, 5)
        ));

        double expectedPay = 120000 / 12 / 29.3 * 7;
        double actualPay = vacationCalculatorService.calculateVacationPay(request);

        assertEquals(expectedPay, actualPay, 0.01);
    }

    @Test
    @DisplayName("Test without weekends and holidays")
    public void testCalculateVacationPay_WithoutWeekendsAndHolidays() {
        request.setVacationDays(5);
        request.setPeriodVacation(Arrays.asList(
                LocalDate.of(2024, 10, 7),
                LocalDate.of(2024, 10, 11)
        ));

        double expectedPay = 120000 / 12 / 29.3 * 5;
        double actualPay = vacationCalculatorService.calculateVacationPay(request);

        assertEquals(expectedPay, actualPay, 0.01);
    }

    @Test
    @DisplayName("Test with only weekends")
    public void testCalculateVacationPay_WithOnlyWeekends() {
        request.setVacationDays(2);
        request.setPeriodVacation(Arrays.asList(
                LocalDate.of(2024, 10, 5),
                LocalDate.of(2024, 10, 6)
        ));

        double expectedPay = 0;
        double actualPay = vacationCalculatorService.calculateVacationPay(request);

        assertEquals(expectedPay, actualPay, 0.01);
    }
}