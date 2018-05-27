package pers.laineyc.blackdream.framework.dao.query.expression;

import java.util.ArrayList;
import java.util.List;

/**
 * Bt
 *
 * @author LaineyC
 */
public class Between extends Expression<List<? super Comparable>> {

    public Between(String property, Comparable between, Comparable and){
        setProperty(property);
        setValue(new ArrayList<>());
        setBetween(between);
        setAnd(and);
    }

    public void setBetween(Comparable between){
        getValue().set(0, between);
    }

    public void setAnd(Comparable and){
        getValue().set(1, and);
    }

}