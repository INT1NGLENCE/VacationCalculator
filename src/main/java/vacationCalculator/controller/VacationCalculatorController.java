package vacationCalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vacationCalculator.dto.VacationRequest;
import vacationCalculator.dto.VacationResponce;
import vacationCalculator.service.VacationCalculatorService;

@RestController
public class VacationCalculatorController {

    private final VacationCalculatorService vacationCalculatorService;

    @Autowired
    public VacationCalculatorController(VacationCalculatorService vacationCalculatorService) {
        this.vacationCalculatorService = vacationCalculatorService;
    }

    @GetMapping("/calculate")
    public ResponseEntity<VacationResponce> calculateVacationPay(@RequestBody VacationRequest request){
        if(vacationCalculatorService.validateRequest(request)){
            return new ResponseEntity<>(new VacationResponce(0.0), HttpStatus.BAD_REQUEST);
        }
        double vacationPay = vacationCalculatorService.calculateVacationPay(request);
        return new ResponseEntity<>(new VacationResponce(vacationPay), HttpStatus.OK);
    }
}
