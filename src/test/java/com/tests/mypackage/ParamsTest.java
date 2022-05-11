package com.tests.mypackage;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParamsTest {

//    private final static int[] INTLIST = {1, 2, 3, 4, 5};
//    private final static String[] STRLIST = {"Peter King", "Arthur King", "Martin King"};

    @ParameterizedTest(name = "#{index} - Test with Argument={0}")
    @ValueSource(ints = {2, 4, 6, 8, 10})
    @Owner("Tihomir Vekonj")
    @DisplayName("Random test 1")
    @Disabled
    void test_int_arrays(int arg) {
        System.out.println("arg => " + arg);
        Assertions.assertEquals(0, arg % 2);
    }

    @ParameterizedTest(name = "#{index} - Test with Argument={0}")
    @ValueSource(strings =  {"Peter King", "Arthur King", "Martin King"})
    @Owner("Tihomir Vekonj")
    @DisplayName("Random test 2")
    @Disabled
    void test_string_arrays(String arg) {
        String searchKey = "King";

        System.out.println("arg => " + arg);
        Assertions.assertTrue(arg.contains(searchKey));
    }
}
