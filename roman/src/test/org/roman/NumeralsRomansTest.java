package org.roman;

import org.roman.rule.DecimalsToRomansRuleImpl;
import org.roman.rule.RomansToDecimalsRuleImpl;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 *
 * @author stallman wang
 */
public class NumeralsRomansTest {

    @Test
    public void should_convert_1_to_roman() {
        assertThat(RomanNumerals.fromDecimals(1), equalTo("I"));
    }

    @Test
    public void should_convert_5_to_roman() {
        assertThat(RomanNumerals.fromDecimals(5), equalTo("V"));
    }

    @Test
    public void should_convert_9_to_roman() {
        assertThat(RomanNumerals.fromDecimals(9), equalTo("IX"));
    }

    @Test
    public void should_convert_10_to_roman() {
        assertThat(RomanNumerals.fromDecimals(10), equalTo("X"));
    }

    @Test
    public void should_convert_50_to_roman() {
        assertThat(RomanNumerals.fromDecimals(50), equalTo("L"));
    }

    @Test
    public void should_convert_63_to_roman() {
        assertThat(RomanNumerals.fromDecimals(63), equalTo("LXIII"));
    }

    @Test
    public void should_convert_100_to_roman() {
        assertThat(RomanNumerals.fromDecimals(100), equalTo("C"));
    }

    @Test
    public void should_convert_448_to_roman() {
        assertThat(RomanNumerals.fromDecimals(448), equalTo("CDXLVIII"));
    }

    @Test
    public void should_convert_500_to_roman() {
        assertThat(RomanNumerals.fromDecimals(500), equalTo("D"));
    }

    @Test
    public void should_convert_1000_to_roman() {
        assertThat(RomanNumerals.fromDecimals(1000), equalTo("M"));
    }

    @Test
    public void should_convert_1944_to_roman() {
        assertThat(RomanNumerals.fromDecimals(1944), equalTo("MCMXLIV"));
    }

    @Test
    public void should_convert_2008_to_roman() {
        assertThat(RomanNumerals.fromDecimals(2008), equalTo("MMVIII"));
    }

    @Test
    public void should_convert_2751_to_roman() {
        assertThat(RomanNumerals.fromDecimals(2751), equalTo("MMDCCLI"));
    }

    @Test(expected = NumberFormatException.class)
    public void should_throw_exception_convert_negative() {
        RomanNumerals.fromDecimals(-11);
    }

    @Test(expected = NumberFormatException.class)
    public void should_throw_exception_convert_zero() {
        RomanNumerals.fromDecimals(0);
    }

    @Test(expected = NumberFormatException.class)
    public void should_throw_exception_convert_larger_than_4000() {
        RomanNumerals.fromDecimals(4000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_pass_inconrrect_strategy() {
        RomanNumerals.fromDecimals(2008,new RomansToDecimalsRuleImpl() );
    }

    @Test
    public void should_convert_with_correct_strategy(){
        assertThat(RomanNumerals.fromDecimals(2751,new DecimalsToRomansRuleImpl()), equalTo("MMDCCLI"));
    }
}
