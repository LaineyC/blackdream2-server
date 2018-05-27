package pers.laineyc.blackdream.framework.dao.query.expression;

/**
 * ExpressionBuilder
 *
 * @author LaineyC
 */
public final class ExpressionBuilder {

    public static And and(Expression... expressionList){
        return new And(expressionList);
    }

    public static Between between(String property, Comparable between, Comparable and){
        return new Between(property, between, and);
    }

    public static Equal equal(String property, Object value){
        return new Equal(property, value);
    }

    public static GreaterThan greaterThan(String property, Comparable value){
        return new GreaterThan(property, value);
    }

    public static GreaterThanOrEqualTo greaterThanOrEqualTo(String property, Comparable value){
        return new GreaterThanOrEqualTo(property, value);
    }

    public static In in(String property, Comparable... value){
        return new In(property, value);
    }

    public static LessThan lessThan(String property, Comparable value){
        return new LessThan(property, value);
    }

    public static LessThanOrEqualTo lessThanOrEqualTo(String property, Comparable value){
        return new LessThanOrEqualTo(property, value);
    }

    public static Like like(String property, String value){
        return new Like(property, value);
    }

    public static Or or(Expression... expressionList){
        return new Or(expressionList);
    }

}