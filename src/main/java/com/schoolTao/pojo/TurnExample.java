package com.schoolTao.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TurnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TurnExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTurnIdIsNull() {
            addCriterion("turn_id is null");
            return (Criteria) this;
        }

        public Criteria andTurnIdIsNotNull() {
            addCriterion("turn_id is not null");
            return (Criteria) this;
        }

        public Criteria andTurnIdEqualTo(Integer value) {
            addCriterion("turn_id =", value, "turnId");
            return (Criteria) this;
        }

        public Criteria andTurnIdNotEqualTo(Integer value) {
            addCriterion("turn_id <>", value, "turnId");
            return (Criteria) this;
        }

        public Criteria andTurnIdGreaterThan(Integer value) {
            addCriterion("turn_id >", value, "turnId");
            return (Criteria) this;
        }

        public Criteria andTurnIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("turn_id >=", value, "turnId");
            return (Criteria) this;
        }

        public Criteria andTurnIdLessThan(Integer value) {
            addCriterion("turn_id <", value, "turnId");
            return (Criteria) this;
        }

        public Criteria andTurnIdLessThanOrEqualTo(Integer value) {
            addCriterion("turn_id <=", value, "turnId");
            return (Criteria) this;
        }

        public Criteria andTurnIdIn(List<Integer> values) {
            addCriterion("turn_id in", values, "turnId");
            return (Criteria) this;
        }

        public Criteria andTurnIdNotIn(List<Integer> values) {
            addCriterion("turn_id not in", values, "turnId");
            return (Criteria) this;
        }

        public Criteria andTurnIdBetween(Integer value1, Integer value2) {
            addCriterion("turn_id between", value1, value2, "turnId");
            return (Criteria) this;
        }

        public Criteria andTurnIdNotBetween(Integer value1, Integer value2) {
            addCriterion("turn_id not between", value1, value2, "turnId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Integer value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Integer value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Integer value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Integer value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Integer> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Integer> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andTurnPicIsNull() {
            addCriterion("turn_pic is null");
            return (Criteria) this;
        }

        public Criteria andTurnPicIsNotNull() {
            addCriterion("turn_pic is not null");
            return (Criteria) this;
        }

        public Criteria andTurnPicEqualTo(String value) {
            addCriterion("turn_pic =", value, "turnPic");
            return (Criteria) this;
        }

        public Criteria andTurnPicNotEqualTo(String value) {
            addCriterion("turn_pic <>", value, "turnPic");
            return (Criteria) this;
        }

        public Criteria andTurnPicGreaterThan(String value) {
            addCriterion("turn_pic >", value, "turnPic");
            return (Criteria) this;
        }

        public Criteria andTurnPicGreaterThanOrEqualTo(String value) {
            addCriterion("turn_pic >=", value, "turnPic");
            return (Criteria) this;
        }

        public Criteria andTurnPicLessThan(String value) {
            addCriterion("turn_pic <", value, "turnPic");
            return (Criteria) this;
        }

        public Criteria andTurnPicLessThanOrEqualTo(String value) {
            addCriterion("turn_pic <=", value, "turnPic");
            return (Criteria) this;
        }

        public Criteria andTurnPicLike(String value) {
            addCriterion("turn_pic like", value, "turnPic");
            return (Criteria) this;
        }

        public Criteria andTurnPicNotLike(String value) {
            addCriterion("turn_pic not like", value, "turnPic");
            return (Criteria) this;
        }

        public Criteria andTurnPicIn(List<String> values) {
            addCriterion("turn_pic in", values, "turnPic");
            return (Criteria) this;
        }

        public Criteria andTurnPicNotIn(List<String> values) {
            addCriterion("turn_pic not in", values, "turnPic");
            return (Criteria) this;
        }

        public Criteria andTurnPicBetween(String value1, String value2) {
            addCriterion("turn_pic between", value1, value2, "turnPic");
            return (Criteria) this;
        }

        public Criteria andTurnPicNotBetween(String value1, String value2) {
            addCriterion("turn_pic not between", value1, value2, "turnPic");
            return (Criteria) this;
        }

        public Criteria andTurnContentIsNull() {
            addCriterion("turn_content is null");
            return (Criteria) this;
        }

        public Criteria andTurnContentIsNotNull() {
            addCriterion("turn_content is not null");
            return (Criteria) this;
        }

        public Criteria andTurnContentEqualTo(String value) {
            addCriterion("turn_content =", value, "turnContent");
            return (Criteria) this;
        }

        public Criteria andTurnContentNotEqualTo(String value) {
            addCriterion("turn_content <>", value, "turnContent");
            return (Criteria) this;
        }

        public Criteria andTurnContentGreaterThan(String value) {
            addCriterion("turn_content >", value, "turnContent");
            return (Criteria) this;
        }

        public Criteria andTurnContentGreaterThanOrEqualTo(String value) {
            addCriterion("turn_content >=", value, "turnContent");
            return (Criteria) this;
        }

        public Criteria andTurnContentLessThan(String value) {
            addCriterion("turn_content <", value, "turnContent");
            return (Criteria) this;
        }

        public Criteria andTurnContentLessThanOrEqualTo(String value) {
            addCriterion("turn_content <=", value, "turnContent");
            return (Criteria) this;
        }

        public Criteria andTurnContentLike(String value) {
            addCriterion("turn_content like", value, "turnContent");
            return (Criteria) this;
        }

        public Criteria andTurnContentNotLike(String value) {
            addCriterion("turn_content not like", value, "turnContent");
            return (Criteria) this;
        }

        public Criteria andTurnContentIn(List<String> values) {
            addCriterion("turn_content in", values, "turnContent");
            return (Criteria) this;
        }

        public Criteria andTurnContentNotIn(List<String> values) {
            addCriterion("turn_content not in", values, "turnContent");
            return (Criteria) this;
        }

        public Criteria andTurnContentBetween(String value1, String value2) {
            addCriterion("turn_content between", value1, value2, "turnContent");
            return (Criteria) this;
        }

        public Criteria andTurnContentNotBetween(String value1, String value2) {
            addCriterion("turn_content not between", value1, value2, "turnContent");
            return (Criteria) this;
        }

        public Criteria andTurnTimeIsNull() {
            addCriterion("turn_time is null");
            return (Criteria) this;
        }

        public Criteria andTurnTimeIsNotNull() {
            addCriterion("turn_time is not null");
            return (Criteria) this;
        }

        public Criteria andTurnTimeEqualTo(Date value) {
            addCriterion("turn_time =", value, "turnTime");
            return (Criteria) this;
        }

        public Criteria andTurnTimeNotEqualTo(Date value) {
            addCriterion("turn_time <>", value, "turnTime");
            return (Criteria) this;
        }

        public Criteria andTurnTimeGreaterThan(Date value) {
            addCriterion("turn_time >", value, "turnTime");
            return (Criteria) this;
        }

        public Criteria andTurnTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("turn_time >=", value, "turnTime");
            return (Criteria) this;
        }

        public Criteria andTurnTimeLessThan(Date value) {
            addCriterion("turn_time <", value, "turnTime");
            return (Criteria) this;
        }

        public Criteria andTurnTimeLessThanOrEqualTo(Date value) {
            addCriterion("turn_time <=", value, "turnTime");
            return (Criteria) this;
        }

        public Criteria andTurnTimeIn(List<Date> values) {
            addCriterion("turn_time in", values, "turnTime");
            return (Criteria) this;
        }

        public Criteria andTurnTimeNotIn(List<Date> values) {
            addCriterion("turn_time not in", values, "turnTime");
            return (Criteria) this;
        }

        public Criteria andTurnTimeBetween(Date value1, Date value2) {
            addCriterion("turn_time between", value1, value2, "turnTime");
            return (Criteria) this;
        }

        public Criteria andTurnTimeNotBetween(Date value1, Date value2) {
            addCriterion("turn_time not between", value1, value2, "turnTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}