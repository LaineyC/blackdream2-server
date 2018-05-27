package pers.laineyc.blackdream.framework.dao.query.expression;

/**
 * Bt
 *
 * @author LaineyC
 */
public class GreaterThanOrEqualTo extends Expression<Comparable> {

    public GreaterThanOrEqualTo(String property, Comparable value){
        super(property, value);
    }

}