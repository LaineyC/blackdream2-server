package pers.laineyc.blackdream.framework.dao.query.expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Bt
 *
 * @author LaineyC
 */
public class In extends Expression<List<? super Comparable>> {

    public In(String property, Comparable... comparableList){
        this(property, Arrays.asList(comparableList));
    }

    public In(String property, List<? super Comparable> value){
        super(property, new ArrayList<>(value));
    }

    public void addValue(Comparable... values){
        getValue().addAll(Arrays.asList(values));
    }

    public void addValues(List<Comparable> values){
        getValue().addAll(values);
    }

}