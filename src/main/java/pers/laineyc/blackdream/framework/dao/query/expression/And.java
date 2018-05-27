package pers.laineyc.blackdream.framework.dao.query.expression;

import java.util.Arrays;
import java.util.List;

/**
 * Predicate
 *
 * @author LaineyC
 */
public class And extends Condition{

    public And(Expression... expressionList){
        this(Arrays.asList(expressionList));
    }

    public And(List<Expression> value){
        super(value);
    }

}
