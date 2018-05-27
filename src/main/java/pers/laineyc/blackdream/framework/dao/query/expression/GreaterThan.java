package pers.laineyc.blackdream.framework.dao.query.expression;

/**
 * Bt
 *
 * @author LaineyC
 */
public class GreaterThan extends Expression<Comparable> {

    public GreaterThan(String property, Comparable value){
        super(property, value);
    }

}