package dev.ankit.productservice.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;


@SpringBootTest
public class CalculatorControllerTest {

    // private AddService addService = Mockito.mock(AddService.class);

    @Autowired
    private CalculatorController calculatorController;

    @MockBean
    private AddService addService;

    @Test
    public void testAdd() {
        when(addService.sumFromAddService(10, 5))
                .thenReturn(15);

        int a = 10;
        int b = 6;
        int expectedResult = 16;

        int result = calculatorController.add(a, b);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void anotherTest() {

    }

    public void someCommonMethod() {

    }
}
