package dev.ankit.productservice.calculator;

import org.springframework.stereotype.Service;

@Service
public class AddService {
    public Integer sumFromAddService(int a, int b) {
        System.out.println("Some logic from add service");
        System.out.println("Some logic from add service");
        int result = a + b;
        return result;
    }
}
