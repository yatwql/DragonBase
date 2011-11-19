package org.roman;

import org.roman.rule.RomansToDecimalsRuleImpl;
import org.roman.rule.DecimalsToRomansRuleImpl;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 *
 * @author stallman wang
 */
public class RomansNumeralsTest {

    @Test
    public void should_convert_I_to_decimal() {
        assertThat(RomanNumerals.asDecimals("I"), equalTo(1));
    }

    @Test
    public void should_convert_V_to_decimal() {
        assertThat(RomanNumerals.asDecimals("V"), equalTo(5));
    }

    @Test
    public void should_convert_X_to_decimal() {
        assertThat(RomanNumerals.asDecimals("X"), equalTo(10));
    }

    @Test
    public void should_convert_L_to_decimal() {
        assertThat(RomanNumerals.asDecimals("L"), equalTo(50));
    }

    @Test
    public void should_convert_C_to_decimal() {
        assertThat(RomanNumerals.asDecimals("C"), equalTo(100));
    }

    @Test
    public void should_convert_D_to_decimal() {
        assertThat(RomanNumerals.asDecimals("D"), equalTo(500));
    }

    @Test
    public void should_convert_M_to_decimal() {
        assertThat(RomanNumerals.asDecimals("M"), equalTo(1000));
    }

    @Test
    public void should_convert_to_decimal_448() {
        assertThat(RomanNumerals.asDecimals("CDXLVIII"), equalTo(448));
    }

    @Test
    public void should_convert_to_decimal_1944() {
        assertThat(RomanNumerals.asDecimals("MCMXLIV"), equalTo(1944));
    }

    @Test
    public void should_convert_to_decimal_2008() {
        assertThat(RomanNumerals.asDecimals("MMVIII"), equalTo(2008));

    }

    @Test
    public void should_convert_lower_char_to_decimal_2012() {
        assertThat(RomanNumerals.asDecimals("mmxii"), equalTo(2012));
    }

    @Test
    public void should_convert_to_decimal_2751() {
        assertThat(RomanNumerals.asDecimals("MMDCCLI"), equalTo(2751));
    }

    @Test(expected = NumberFormatException.class)
    public void should_throw_exception_to_convert_larger_than_limit() {
        RomanNumerals.asDecimals("MMMM");
    }

    @Test(expected = NumberFormatException.class)
    public void should_throw_exception_to_convert_invalid_char_AB() {
        RomanNumerals.asDecimals("CAB");
    }

    @Test(expected = NumberFormatException.class)
    public void should_throw_exception_to_convert_invalid_char_QG() {
        RomanNumerals.asDecimals("QGCE");
    }

    @Test(expected = NumberFormatException.class)
    public void should_throw_exception_to_convert_spaces() {
        RomanNumerals.asDecimals(" ");
    }

    @Test(expected = NumberFormatException.class)
    public void should_throw_exception_to_convert_empty() {
        RomanNumerals.asDecimals("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_pass_inconrrect_strategy() {
        
        assertThat(RomanNumerals.asDecimals("MMDCCLI",new DecimalsToRomansRuleImpl()), equalTo(2751));
    }

    @Test
    public void should_convert_with_correct_strategy(){
        assertThat(RomanNumerals.asDecimals("MCMXLIV",new RomansToDecimalsRuleImpl()), equalTo(1944));
    }
}
