package org.roman;

import org.roman.rule.*;

/**
 * Context class
 * @author stallman wang
 */
public class Context {

    private String romans = "";
    private int decimalValue = 0;
    private static final Rule DECIMALS_TO_ROMANS_RULE = new DecimalsToRomansRuleImpl();
    private static final Rule ROMANS_TO_DECIMALS_RULE = new RomansToDecimalsRuleImpl();
    private Rule strategy;
    private boolean isRomansBase;

    public Rule getStrategy() {
        return strategy;
    }

    public Context(String romanValue) {
        //The strategy is convert Romans Numerial to Decimals
        this(romanValue, null);
    }

    public Context(String romanValue, Rule strategy) {
        //The strategy is convert Romans Numerial to Decimals

        if (strategy == null) {
            //use default strategy
            this.strategy = ROMANS_TO_DECIMALS_RULE;
        } else {
            this.strategy = strategy;
        }

        if (!this.strategy.isRomansBase()) {
            throw new IllegalArgumentException("The strategy parameter is incorrect, "
                    + "expect a strategy implementation which is Romans base");
        }
        this.isRomansBase = true;
        this.setRomans(romanValue);
    }

    public Context(int decimalValue) {

        //The strategy is convert Decimals to Romans Numerial
        this(decimalValue, null);
    }

    public Context(int decimalValue, Rule strategy) {

        //The strategy is convert Decimals to Romans Numerial

        if (strategy == null) {
            //use default strategy
            this.strategy = DECIMALS_TO_ROMANS_RULE;
        } else {
            this.strategy = strategy;
        }

        if (this.strategy.isRomansBase()) {
            throw new IllegalArgumentException("The strategy parameter is incorrect, "
                    + "expect a strategy implementation which is NOT Romans base");
        }
        this.isRomansBase = false;
        this.setDecimals(decimalValue);
    }

    public int getDecimals() {
        return decimalValue;
    }

    public void setDecimals(int decimalValue) {
        this.decimalValue = decimalValue;
    }

    public String getRomans() {
        return romans;
    }

    public void setRomans(String romanValue) {
        this.romans = romanValue;
    }

    public boolean isRomansEmpty() {
        return (this.romans == null | this.romans.isEmpty());
    }

    public boolean isRomansBase() {
        return isRomansBase;
    }
}
