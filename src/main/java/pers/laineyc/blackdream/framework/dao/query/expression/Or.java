package pers.laineyc.blackdream.framework.dao.query.expression;

import java.util.Arrays;
import java.util.List;

/**
 * Predicate
 *
 * @author LaineyC
 */
public class Or extends Condition {

    public Or(Expression... expressionList){
        this(Arrays.asList(expressionList));
    }

    public Or(List<Expression> value){
        super(value);
    }

}
