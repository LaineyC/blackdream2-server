package pers.laineyc.blackdream.framework.dao.query;

import pers.laineyc.blackdream.framework.dao.po.Po;
import pers.laineyc.blackdream.framework.dao.query.expression.Condition;
import pers.laineyc.blackdream.framework.dao.query.expression.Expression;
import pers.laineyc.blackdream.framework.dao.query.expression.ExpressionBuilder;
import java.io.Serializable;

/**
 * @author LaineyC
 */
public abstract class Query<E extends Po> implements Serializable {

    private Condition where;

    private Group group;

    private Condition having;

    private Order order;

    private Limit limit;

    public Query(){

    }

    protected void addWhereExpression(Expression... expressions) {
        if(where == null){
            where = ExpressionBuilder.and(expressions);
        }
        else{
            where.addExpressions(expressions);
        }
    }

    protected void addHavingExpression(Expression... expressions) {
        if(having == null){
            having = ExpressionBuilder.and(expressions);
        }
        else{
            having.addExpressions(expressions);
        }
    }

    protected void groupBy(String property){
        if(this.group == null){
            this.group = new Group(property);
        }
        else{
            this.group.by(property);
        }
    }

    protected void orderBy(String property, Order.Direction orderDirection){
        if(this.order == null){
            this.order = new Order(property, orderDirection);
        }
        else{
            this.order.by(property, orderDirection);
        }
    }

    public Condition getWhere() {
        return where;
    }

    public Group getGroup() {
        return group;
    }

    public Condition getHaving() {
        return having;
    }

    public Order getOrder() {
        return order;
    }

    public Limit getLimit() {
        return limit;
    }

    public void limit(Integer firstResult, Integer maxResults){
        this.limit = new Limit(firstResult, maxResults);
    }

}