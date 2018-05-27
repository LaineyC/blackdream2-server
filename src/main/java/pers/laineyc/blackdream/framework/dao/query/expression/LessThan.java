package pers.laineyc.blackdream.framework.dao.query.expression;

/**
 * Bt
 *
 * @author LaineyC
 */
public class LessThan extends Expression<Comparable> {

    public LessThan(String property, Comparable value){
        super(property, value);
    }

}