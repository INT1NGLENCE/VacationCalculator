package vacationCalculator.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import vacationCalculator.dto.VacationRequest;
import vacationCalculator.service.VacationCalculatorService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class VacationCalculatorControllerTest {
    private MockMvc mockMvc;

    @Mock
    private VacationCalculatorService vacationCalculatorService;

    @InjectMocks
    private VacationCalculatorController vacationCalculatorController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(vacationCalculatorController).build();
    }

    @Test
    public void testCalculateVacationPay() throws Exception {
        when(vacationCalculatorService.calculateVacationPay(any(VacationRequest.class))).thenReturn(10000.0);

        mockMvc.perform(get("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"averageSalary\":50000," +
                                "\"vacationDays\":10," +
                                "\"periodVacation\":[\"2023-10-01\",\"2023-10-11\"]}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"vacationPay\":10000}"));
    }
    @Test
    public void testCalculateVacationPay_InvalidData() throws Exception {
        when(vacationCalculatorService.validateRequest(any(VacationRequest.class))).thenReturn(true);

        mockMvc.perform(get("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"averageSalary\":50000," +
                                "\"vacationDays\":0," +
                                "\"periodVacation\":[]}"))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("{\"vacationPay\":0.0}"));
    }
}