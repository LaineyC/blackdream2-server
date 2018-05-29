package pers.laineyc.blackdream.framework.dao.support.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import pers.laineyc.blackdream.framework.dao.Dao;
import pers.laineyc.blackdream.framework.dao.po.Po;
import pers.laineyc.blackdream.framework.dao.query.Limit;
import pers.laineyc.blackdream.framework.dao.query.Order;
import pers.laineyc.blackdream.framework.dao.query.Query;
import pers.laineyc.blackdream.framework.dao.query.expression.*;
import pers.laineyc.blackdream.framework.dao.support.EntityInformation;
import pers.laineyc.blackdream.framework.util.ReflectionUtil;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LaineyC
 *
 */
public class MongoBaseDao<E extends Po, K extends Comparable<? super K>> implements Dao<E, K> {

    @Resource
    private MongoTemplate mongoTemplate;

    private Class<E> entityClass;

    private EntityInformation<E, K> entityInformation;

    public MongoBaseDao(){
        this.entityClass = ReflectionUtil.getSuperClassGenericsType(getClass(), 0);
        this.entityInformation = MongoEntityInformationSupport.getEntityInformation(entityClass);
    }

    protected MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    protected Class<E> getEntityClass() {
        return entityClass;
    }

    @Override
    public int insert(E po) {
        mongoTemplate.insert(po);
        return 1;
    }

    @Override
    public int delete(E po) {
        mongoTemplate.remove(po);
        return 1;
    }

    @Override
    public int deleteList(Query<E> query) {
        WriteResult writeResult = mongoTemplate.remove(createQuery(query), entityClass);
        return writeResult.getN();
    }

    @Override
    public int update(E po) {
        org.springframework.data.mongodb.core.query.Query mongodbQuery = new org.springframework.data.mongodb.core.query.Query();
        Object idValue = ReflectionUtil.getFieldValue(entityInformation.getIdPropertyInformation().getPropertyField(), po);
        mongodbQuery.addCriteria(Criteria.where(entityInformation.getIdPropertyInformation().getPropertyAlias()).is(idValue));
        Update update = new Update();
        entityInformation.getPropertyInformationList().forEach(propertyInformation -> {
            if(propertyInformation.getIsPrimaryKey()){
                return;
            }
            Object value = ReflectionUtil.getFieldValue(propertyInformation.getPropertyField(), po);
            String propertyAlias = propertyInformation.getPropertyAlias();
            update.set(propertyAlias, value);
        });
        WriteResult writeResult = mongoTemplate.updateMulti(mongodbQuery, update, entityClass);
        return writeResult.getN();
    }

    @Override
    public int updateSelective(E po) {
        org.springframework.data.mongodb.core.query.Query mongodbQuery = new org.springframework.data.mongodb.core.query.Query();
        Object idValue = ReflectionUtil.getFieldValue(entityInformation.getIdPropertyInformation().getPropertyField(), po);
        mongodbQuery.addCriteria(Criteria.where(entityInformation.getIdPropertyInformation().getPropertyAlias()).is(idValue));
        Update update = new Update();
        entityInformation.getPropertyInformationList().forEach(propertyInformation -> {
            if(propertyInformation.getIsPrimaryKey()){
                return;
            }
            Object value = ReflectionUtil.getFieldValue(propertyInformation.getPropertyField(), po);
            if(value == null){
                return;
            }
            String propertyAlias = propertyInformation.getPropertyAlias();
            update.set(propertyAlias, value);
        });
        WriteResult writeResult = mongoTemplate.updateMulti(mongodbQuery, update, entityClass);
        return writeResult.getN();
    }

    @Override
    public int updateList(Query<E> query, E po) {
        org.springframework.data.mongodb.core.query.Query mongodbQuery = createQuery(query);
        Update update = new Update();
        entityInformation.getPropertyInformationList().forEach(propertyInformation -> {
            if(propertyInformation.getIsPrimaryKey()){
                return;
            }
            Object value = ReflectionUtil.getFieldValue(propertyInformation.getPropertyField(), po);
            if(value == null){
                return;
            }
            String propertyAlias = propertyInformation.getPropertyAlias();
            update.set(propertyAlias, value);
        });

        WriteResult writeResult = mongoTemplate.updateMulti(mongodbQuery, update, entityClass);
        return writeResult.getN();
    }

    @Override
    public E selectById(K id) {
        return mongoTemplate.findById(id, entityClass);
    }
/*
    @Override
    public List<E> selectByIds(Iterable<K> ids) {
        org.springframework.data.mongodb.core.query.Query mongodbQuery = new org.springframework.data.mongodb.core.query.Query();
        mongodbQuery.addCriteria(Criteria.where(entityInformation.getIdPropertyInformation().getPropertyAlias()).in(ids));
        return mongoTemplate.find(mongodbQuery, entityClass);
    }
*/
    @Override
    public E selectOne(Query<E> query) {
        return mongoTemplate.findOne(createQuery(query), entityClass);
    }

    @Override
    public List<E> selectList(Query<E> query) {
        return mongoTemplate.find(createQuery(query), entityClass);
    }
/*
    @Override
    public List<E> selectLimit(Query<E> query) {
        Limit limit = query.getLimit();
        Integer firstResult = limit.getFirstResult();
        Integer maxResults = limit.getMaxResults();

        BasicQuery mongodbQuery = createQuery(query);
        mongodbQuery.skip(firstResult).limit(maxResults);

        return mongoTemplate.find(mongodbQuery, entityClass);
    }
*/
    @Override
    public int selectCount(Query<E> query) {
        return (int)mongoTemplate.count(createQuery(query), entityClass);
    }

    private BasicQuery createQuery(Query<E> query){
        org.springframework.data.mongodb.core.query.Query mongodbQuery = new org.springframework.data.mongodb.core.query.Query();
        Condition where = query.getWhere();

        if(where != null){
            Criteria whereCriteria = handleCondition(where);
            mongodbQuery.addCriteria(whereCriteria);
        }
/*
        pers.laineyc.blackdream.framework.dao.query.Group group = query.getGroup();
        if(group != null){
            List<javax.persistence.criteria.Expression<?>> groupList = handleGroup(group, root);
            criteriaQuery.groupBy(groupList);
        }

        Condition having = query.getHaving();
        if(having != null) {
            Predicate havingPredicate = handleCondition(having);
            criteriaQuery.having(havingPredicate);
        }
*/
        pers.laineyc.blackdream.framework.dao.query.Order order = query.getOrder();
        if(order != null) {
            Sort sort = handleOrder(order);
            mongodbQuery.with(sort);
        }

        DBObject fieldsObject = new BasicDBObject();
        if(query.getIsFetchLazy()) {
            entityInformation.getPropertyInformationList().forEach(propertyInformation -> {
                if (propertyInformation.getIsFetchLazy()) {
                    fieldsObject.put(propertyInformation.getPropertyAlias(), false);
                }
            });
        }

        BasicQuery basicQuery = new BasicQuery(mongodbQuery.getQueryObject(), fieldsObject);
        basicQuery.setSortObject(mongodbQuery.getSortObject());

        Limit limit = query.getLimit();
        if(limit != null){
            Integer firstResult = limit.getFirstResult();
            Integer maxResults = limit.getMaxResults();
            basicQuery.skip(firstResult).limit(maxResults);
        }

        return basicQuery;
    }

    private Criteria handleCondition(Condition condition){
        List<Expression> expressionList = condition.getValue();
        List<Criteria> criteriaList = new ArrayList<>();
        Criteria criteria = null;

        for(Expression expression : expressionList){
            String property = expression.getProperty();
            if(expression instanceof Condition){
                criteria = handleCondition((Condition) expression);
            }
            else if(expression instanceof Equal){
                criteria = Criteria.where(property).is(expression.getValue());
            }
            else if(expression instanceof Between){
                Between between = (Between)expression;
                List<? super Comparable> valueList = between.getValue();
                criteria = Criteria.where(property).gte(valueList.get(0)).lte(valueList.get(1));
            }
            else if(expression instanceof GreaterThan){
                GreaterThan greaterThan = (GreaterThan)expression;
                criteria = Criteria.where(property).gt(greaterThan.getValue());
            }
            else if(expression instanceof GreaterThanOrEqualTo){
                GreaterThanOrEqualTo greaterThanOrEqualTo = (GreaterThanOrEqualTo)expression;
                criteria = Criteria.where(property).gte(greaterThanOrEqualTo.getValue());
            }
            else if(expression instanceof In){
                In in = (In)expression;
                criteria = Criteria.where(property).in(in.getValue());
            }
            else if(expression instanceof LessThan){
                LessThan lessThan = (LessThan)expression;
                criteria = Criteria.where(property).lt(lessThan.getValue());
            }
            else if(expression instanceof LessThanOrEqualTo){
                LessThanOrEqualTo lessThanOrEqualTo = (LessThanOrEqualTo)expression;
                criteria = Criteria.where(property).lte(lessThanOrEqualTo.getValue());
            }
            else if(expression instanceof Like){
                Like like = (Like)expression;
                criteria = Criteria.where(property).regex(like.getValue());
            }

            if(criteria != null){
                criteriaList.add(criteria);
            }
        }

        if(!criteriaList.isEmpty()){
            Criteria[] criteriaArray = new Criteria[criteriaList.size()];
            if(condition instanceof And){
                criteria = new Criteria().andOperator(criteriaList.toArray(criteriaArray));
            }
            else{
                criteria = new Criteria().orOperator(criteriaList.toArray(criteriaArray));
            }
        }

        return criteria;
    }

    private Sort handleOrder(Order order){
        List<Sort.Order> jpaOrderList = new ArrayList<>();
        List<Order.OrderItem> orderItemList = order.getOrderItemList();

        orderItemList.forEach(orderItem -> {
            String property = orderItem.getProperty();
            Order.Direction direction = orderItem.getDirection();

            if(direction == Order.Direction.ASC ){
                Sort.Order jpaOrder = new Sort.Order(Sort.Direction.ASC, property);
                jpaOrderList.add(jpaOrder);
            }
            else{
                Sort.Order jpaOrder = new Sort.Order(Sort.Direction.DESC, property);
                jpaOrderList.add(jpaOrder);
            }
        });

        return  new Sort(jpaOrderList);
    }
/*
    private List<javax.persistence.criteria.Expression<?>> handleGroup(pers.laineyc.blackdream.framework.dao.query.Group group, Root<E> root){
        List<javax.persistence.criteria.Expression<?>> groupList = new ArrayList<>();

        if(group == null){
            return groupList;
        }

        List<pers.laineyc.blackdream.framework.dao.query.Group.GroupItem> groupItemList = group.getGroupItemList();
        if(groupItemList.isEmpty()){
            return groupList;
        }

        groupItemList.forEach(groupItem -> {
            String property = groupItem.getProperty();
            Path path = root.get(property);
            groupList.add(path);
        });

        return groupList;
    }
*/
}