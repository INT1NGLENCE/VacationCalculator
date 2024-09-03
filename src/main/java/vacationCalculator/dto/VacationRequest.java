package vacationCalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacationRequest {
    private double averageSalary;
    private int vacationDays;
    private List<LocalDate> periodVacation;
}
