package com.example.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class simpletest {
    @Test
    void testAdder(){
        assertEquals(5,simple.adder(2,3));
    }
}
