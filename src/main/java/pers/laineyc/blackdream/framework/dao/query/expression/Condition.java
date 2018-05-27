package pers.laineyc.blackdream.framework.dao.query.expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Predicate
 *
 * @author LaineyC
 */
public class Condition extends Expression<List<Expression>> {

    public Condition(Expression... expressionList){
        this(Arrays.asList(expressionList));
    }

    public Condition(List<Expression> expressionList){
        if(expressionList != null && !expressionList.isEmpty()) {
            setValue(new ArrayList<>(expressionList));
        }
        else {
            throw new IllegalArgumentException("参数不能为空");
        }
    }

    public void addExpressions(Expression... expressions){
        getValue().addAll(Arrays.asList(expressions));
    }

    public void addExpression(Expression expressions){
        getValue().addAll(Arrays.asList(expressions));
    }

}
