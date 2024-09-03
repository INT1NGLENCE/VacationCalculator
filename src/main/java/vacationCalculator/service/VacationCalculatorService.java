package vacationCalculator.service;

import org.springframework.stereotype.Service;
import vacationCalculator.dto.VacationRequest;
import vacationCalculator.filter.HolidayAndWeekendFilter;

import java.time.LocalDate;
import java.util.List;

@Service
public class VacationCalculatorService {

    public double calculateVacationPay(VacationRequest request) {
        double averageDailySalary = request.getAverageSalary() / 12 / 29.3;
        int actualVacationDays = calculateActualVacationDays(request);
        return actualVacationDays * averageDailySalary;
    }

    public boolean validateRequest(VacationRequest request) {
        if (request.getVacationDays() == 0
                && (request.getPeriodVacation() == null || request.getPeriodVacation().isEmpty())) {
            return true;
        }
        return false;
    }

    private int calculateActualVacationDays(VacationRequest request) {
        List<LocalDate> vacationDays = request.getPeriodVacation();
        if (vacationDays == null || vacationDays.isEmpty() || vacationDays.size() > 2) {
            return request.getVacationDays();
        }

        LocalDate startDate = vacationDays.get(0);
        LocalDate endDate = vacationDays.get(1);
        int count = 0;

        while (!startDate.isAfter(endDate)) {
            boolean isWeekend = HolidayAndWeekendFilter.isHolidayOrWeekend(startDate);
            if (!isWeekend) {
                count++;
            }
            startDate = startDate.plusDays(1);
        }
        return count;
    }
}
