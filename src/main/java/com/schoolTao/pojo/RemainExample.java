package com.schoolTao.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RemainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RemainExample() {
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

        public Criteria andRemainIdIsNull() {
            addCriterion("remain_id is null");
            return (Criteria) this;
        }

        public Criteria andRemainIdIsNotNull() {
            addCriterion("remain_id is not null");
            return (Criteria) this;
        }

        public Criteria andRemainIdEqualTo(Integer value) {
            addCriterion("remain_id =", value, "remainId");
            return (Criteria) this;
        }

        public Criteria andRemainIdNotEqualTo(Integer value) {
            addCriterion("remain_id <>", value, "remainId");
            return (Criteria) this;
        }

        public Criteria andRemainIdGreaterThan(Integer value) {
            addCriterion("remain_id >", value, "remainId");
            return (Criteria) this;
        }

        public Criteria andRemainIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("remain_id >=", value, "remainId");
            return (Criteria) this;
        }

        public Criteria andRemainIdLessThan(Integer value) {
            addCriterion("remain_id <", value, "remainId");
            return (Criteria) this;
        }

        public Criteria andRemainIdLessThanOrEqualTo(Integer value) {
            addCriterion("remain_id <=", value, "remainId");
            return (Criteria) this;
        }

        public Criteria andRemainIdIn(List<Integer> values) {
            addCriterion("remain_id in", values, "remainId");
            return (Criteria) this;
        }

        public Criteria andRemainIdNotIn(List<Integer> values) {
            addCriterion("remain_id not in", values, "remainId");
            return (Criteria) this;
        }

        public Criteria andRemainIdBetween(Integer value1, Integer value2) {
            addCriterion("remain_id between", value1, value2, "remainId");
            return (Criteria) this;
        }

        public Criteria andRemainIdNotBetween(Integer value1, Integer value2) {
            addCriterion("remain_id not between", value1, value2, "remainId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andRemainContentIsNull() {
            addCriterion("remain_content is null");
            return (Criteria) this;
        }

        public Criteria andRemainContentIsNotNull() {
            addCriterion("remain_content is not null");
            return (Criteria) this;
        }

        public Criteria andRemainContentEqualTo(String value) {
            addCriterion("remain_content =", value, "remainContent");
            return (Criteria) this;
        }

        public Criteria andRemainContentNotEqualTo(String value) {
            addCriterion("remain_content <>", value, "remainContent");
            return (Criteria) this;
        }

        public Criteria andRemainContentGreaterThan(String value) {
            addCriterion("remain_content >", value, "remainContent");
            return (Criteria) this;
        }

        public Criteria andRemainContentGreaterThanOrEqualTo(String value) {
            addCriterion("remain_content >=", value, "remainContent");
            return (Criteria) this;
        }

        public Criteria andRemainContentLessThan(String value) {
            addCriterion("remain_content <", value, "remainContent");
            return (Criteria) this;
        }

        public Criteria andRemainContentLessThanOrEqualTo(String value) {
            addCriterion("remain_content <=", value, "remainContent");
            return (Criteria) this;
        }

        public Criteria andRemainContentLike(String value) {
            addCriterion("remain_content like", value, "remainContent");
            return (Criteria) this;
        }

        public Criteria andRemainContentNotLike(String value) {
            addCriterion("remain_content not like", value, "remainContent");
            return (Criteria) this;
        }

        public Criteria andRemainContentIn(List<String> values) {
            addCriterion("remain_content in", values, "remainContent");
            return (Criteria) this;
        }

        public Criteria andRemainContentNotIn(List<String> values) {
            addCriterion("remain_content not in", values, "remainContent");
            return (Criteria) this;
        }

        public Criteria andRemainContentBetween(String value1, String value2) {
            addCriterion("remain_content between", value1, value2, "remainContent");
            return (Criteria) this;
        }

        public Criteria andRemainContentNotBetween(String value1, String value2) {
            addCriterion("remain_content not between", value1, value2, "remainContent");
            return (Criteria) this;
        }

        public Criteria andRemainTimeIsNull() {
            addCriterion("remain_time is null");
            return (Criteria) this;
        }

        public Criteria andRemainTimeIsNotNull() {
            addCriterion("remain_time is not null");
            return (Criteria) this;
        }

        public Criteria andRemainTimeEqualTo(Date value) {
            addCriterion("remain_time =", value, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeNotEqualTo(Date value) {
            addCriterion("remain_time <>", value, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeGreaterThan(Date value) {
            addCriterion("remain_time >", value, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("remain_time >=", value, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeLessThan(Date value) {
            addCriterion("remain_time <", value, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeLessThanOrEqualTo(Date value) {
            addCriterion("remain_time <=", value, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeIn(List<Date> values) {
            addCriterion("remain_time in", values, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeNotIn(List<Date> values) {
            addCriterion("remain_time not in", values, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeBetween(Date value1, Date value2) {
            addCriterion("remain_time between", value1, value2, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeNotBetween(Date value1, Date value2) {
            addCriterion("remain_time not between", value1, value2, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainToIdIsNull() {
            addCriterion("remain_to_id is null");
            return (Criteria) this;
        }

        public Criteria andRemainToIdIsNotNull() {
            addCriterion("remain_to_id is not null");
            return (Criteria) this;
        }

        public Criteria andRemainToIdEqualTo(Integer value) {
            addCriterion("remain_to_id =", value, "remainToId");
            return (Criteria) this;
        }

        public Criteria andRemainToIdNotEqualTo(Integer value) {
            addCriterion("remain_to_id <>", value, "remainToId");
            return (Criteria) this;
        }

        public Criteria andRemainToIdGreaterThan(Integer value) {
            addCriterion("remain_to_id >", value, "remainToId");
            return (Criteria) this;
        }

        public Criteria andRemainToIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("remain_to_id >=", value, "remainToId");
            return (Criteria) this;
        }

        public Criteria andRemainToIdLessThan(Integer value) {
            addCriterion("remain_to_id <", value, "remainToId");
            return (Criteria) this;
        }

        public Criteria andRemainToIdLessThanOrEqualTo(Integer value) {
            addCriterion("remain_to_id <=", value, "remainToId");
            return (Criteria) this;
        }

        public Criteria andRemainToIdIn(List<Integer> values) {
            addCriterion("remain_to_id in", values, "remainToId");
            return (Criteria) this;
        }

        public Criteria andRemainToIdNotIn(List<Integer> values) {
            addCriterion("remain_to_id not in", values, "remainToId");
            return (Criteria) this;
        }

        public Criteria andRemainToIdBetween(Integer value1, Integer value2) {
            addCriterion("remain_to_id between", value1, value2, "remainToId");
            return (Criteria) this;
        }

        public Criteria andRemainToIdNotBetween(Integer value1, Integer value2) {
            addCriterion("remain_to_id not between", value1, value2, "remainToId");
            return (Criteria) this;
        }

        public Criteria andRemianLastIdIsNull() {
            addCriterion("remian_last_id is null");
            return (Criteria) this;
        }

        public Criteria andRemianLastIdIsNotNull() {
            addCriterion("remian_last_id is not null");
            return (Criteria) this;
        }

        public Criteria andRemianLastIdEqualTo(Integer value) {
            addCriterion("remian_last_id =", value, "remianLastId");
            return (Criteria) this;
        }

        public Criteria andRemianLastIdNotEqualTo(Integer value) {
            addCriterion("remian_last_id <>", value, "remianLastId");
            return (Criteria) this;
        }

        public Criteria andRemianLastIdGreaterThan(Integer value) {
            addCriterion("remian_last_id >", value, "remianLastId");
            return (Criteria) this;
        }

        public Criteria andRemianLastIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("remian_last_id >=", value, "remianLastId");
            return (Criteria) this;
        }

        public Criteria andRemianLastIdLessThan(Integer value) {
            addCriterion("remian_last_id <", value, "remianLastId");
            return (Criteria) this;
        }

        public Criteria andRemianLastIdLessThanOrEqualTo(Integer value) {
            addCriterion("remian_last_id <=", value, "remianLastId");
            return (Criteria) this;
        }

        public Criteria andRemianLastIdIn(List<Integer> values) {
            addCriterion("remian_last_id in", values, "remianLastId");
            return (Criteria) this;
        }

        public Criteria andRemianLastIdNotIn(List<Integer> values) {
            addCriterion("remian_last_id not in", values, "remianLastId");
            return (Criteria) this;
        }

        public Criteria andRemianLastIdBetween(Integer value1, Integer value2) {
            addCriterion("remian_last_id between", value1, value2, "remianLastId");
            return (Criteria) this;
        }

        public Criteria andRemianLastIdNotBetween(Integer value1, Integer value2) {
            addCriterion("remian_last_id not between", value1, value2, "remianLastId");
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