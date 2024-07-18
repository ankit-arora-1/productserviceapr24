package dev.ankit.productservice.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CalculatorController {

    private AddService addService;

    public CalculatorController(AddService addService) {
        this.addService = addService;
    }

    public int add(int a, int b) {
        // some random login
        System.out.println("Some logic");
        Integer result = addService.sumFromAddService(a, b);
        System.out.println("Some other logic");

        return result;
    }
}
