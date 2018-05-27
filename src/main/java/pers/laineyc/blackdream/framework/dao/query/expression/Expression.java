package pers.laineyc.blackdream.framework.dao.query.expression;

/**
 * Expression
 *
 * @author LaineyC
 */
public class Expression<V> {

    private String property;

    private V value;

    public Expression(){

    }

    public Expression(String property, V value){
        this.property = property;
        this.value = value;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

}
