package org.cart.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class MathUtilTest {

    @Test
    public void round() {
        assertEquals(312.46, MathUtil.round(312.455,2), 0.0001);
        assertEquals(312.45, MathUtil.round(312.454,2), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void roundIllegalArgument() {
        assertEquals(312.46, MathUtil.round(312.455,-2), 0.0001);
    }
}