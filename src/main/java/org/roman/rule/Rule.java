/*
 * Strategy pattern
 */

package org.roman.rule;

import org.roman.Context;
import org.roman.expression.Expression;

/**
 * Strategy pattern
 * The rule to convert the Numeral
 *  @author stallman wang
 */
public interface Rule {
    /**
     * Entry method
     * @param ctx
     * @param expr
     */
   public void execute(Context ctx,Expression expr);

   /**
    * whether the rule is Romans base ( Translate Roman Numeral to Decimals)
    */
   public boolean isRomansBase();
}
