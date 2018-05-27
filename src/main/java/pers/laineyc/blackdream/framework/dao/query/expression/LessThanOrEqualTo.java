package pers.laineyc.blackdream.framework.dao.query.expression;

/**
 * Bt
 *
 * @author LaineyC
 */
public class LessThanOrEqualTo extends Expression<Comparable> {

    public LessThanOrEqualTo(String property, Comparable value){
        super(property, value);
    }

}