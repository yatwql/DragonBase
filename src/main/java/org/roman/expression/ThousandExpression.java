package org.roman.expression;

import org.roman.Const;

/**
 * TerminatedExpression to interpret the Roman Numerals which's decimal value is from 1000 to 3999 
 * @author stallman wang
 */
public class ThousandExpression extends Expression {

    @Override
    public String one() {
        return "M";
    }

    @Override
    public String four() {
        return Const.SPACES+Const.SPACES;
    }

    @Override
    public String five() {
        return Const.SPACES;
    }

    @Override
    public String nine() {
        return Const.SPACES+Const.SPACES;
    }

    @Override
    public int multiplier() {
        return Const.THOUSAND;
    }
}
