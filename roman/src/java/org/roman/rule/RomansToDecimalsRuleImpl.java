/*
 * The rule to convert Roman Numerial to Decimals 
 */
package org.roman.rule;

import org.roman.Const;
import org.roman.Context;
import org.roman.expression.Expression;

/**
 *
 * @author stallman wang
 */
public class RomansToDecimalsRuleImpl implements Rule {

    public void execute(Context ctx, Expression expr) {
        if (ctx.getDecimals() <= Const.ZERO && (ctx.isRomansEmpty())) {
            throw new NumberFormatException(" An empty string can't define a Roman Numeral.");
        }

        if (ctx.isRomansEmpty()) {
            return;
        }
        if (ctx.getRomans().startsWith(expr.nine())) {
            ctx.setDecimals(ctx.getDecimals() + (Const.NINE * expr.multiplier()));
            ctx.setRomans(ctx.getRomans().substring(Const.INDEX_2ND));
        } else if (ctx.getRomans().startsWith(expr.five())) {
            ctx.setDecimals(ctx.getDecimals() + (Const.FIVE * expr.multiplier()));
            ctx.setRomans(ctx.getRomans().substring(Const.INDEX_1ST));
        } else if (ctx.getRomans().startsWith(expr.four())) {
            ctx.setDecimals(ctx.getDecimals() + (Const.FOUR * expr.multiplier()));
            ctx.setRomans(ctx.getRomans().substring(Const.INDEX_2ND));
        }

        while (ctx.getRomans().startsWith(expr.one())) {
            ctx.setDecimals(ctx.getDecimals() + (Const.ONE * expr.multiplier()));
            ctx.setRomans(ctx.getRomans().substring(Const.INDEX_1ST));
        }

        if (ctx.getDecimals() > Const.ROMANS_UPPER_LIMIT) {
            throw new NumberFormatException(" The value of Roman Numeral must be " + Const.ROMANS_UPPER_LIMIT + " or less.");
        }
    }

    public boolean isRomansBase(){
        return true;
    }
}
