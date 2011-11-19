package org.roman.steps;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.roman.RomanNumerals;



public class RomansSteps {
    
    private RomanNumerals romanNumerals;
    private String romans;
    private int decimalValue;

    @Given("a new converter")    
    public void init() {
        romanNumerals = new RomanNumerals();        
    }
    
    @When("set the romans as ($romans)")
    public void setRomans(String romans) {
        this.romans=romans;        
    }
    
    @When("set the decimal value as ($decimalValue)")
    public void setDecimal(int decimalValue) {
        this.decimalValue=decimalValue;        
    }    
    
    @Then("the decimal value should look like ($decimalValue)")
    @Aliases(values={"the decimal value should be ($decimalValue)"})
    public void theDecimalsShouldLookLike(int decimalValue) {
        assertThat(romanNumerals.asDecimals(romans), equalTo(decimalValue));
    }
    
    @Then("the romans value should look like ($romans)")
    @Aliases(values={"the romans value should be ($romans)"})
    public void theRomansShouldLookLike(String romans) {
        assertThat(romanNumerals.fromDecimals(decimalValue), equalTo(romans));
    }
    

}
