
package org.roman.expression;

import org.roman.Context;

/**
 * Representation to interpret Roman Numeral to Decimals, or Decimals to Roman Numeral
 * Use Interpret pattern and template pattern
 * @author stallman wang
 */
public abstract class Expression {
    public void interpret(Context ctx) {
        if (ctx == null) {
            throw new java.lang.IllegalArgumentException(" Context is null ");
        }
        //Get the actual strategy implementation to convert the numeral value.
        ctx.getStrategy().execute(ctx,this);
    }
     
    /**
     * Return the symbol for one
     * @return
     */
    public abstract String one();
    
    
    /**
     * Return the symbol for four
     * @return
     */
    public abstract String four();

    /**
     * Return the symbol for five
     * @return
     */
    public abstract String five();

    /**
     * Return the symbol for nine
     * @return
     */
    public abstract String nine();

    /**
     * Return the multiplier for current expression, i.e. 1,10,100,1000
     * @return 
     */
    public abstract int multiplier();
}
