package com.schoolTao.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NeedExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NeedExample() {
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

        public Criteria andNeedIdIsNull() {
            addCriterion("need_id is null");
            return (Criteria) this;
        }

        public Criteria andNeedIdIsNotNull() {
            addCriterion("need_id is not null");
            return (Criteria) this;
        }

        public Criteria andNeedIdEqualTo(Integer value) {
            addCriterion("need_id =", value, "needId");
            return (Criteria) this;
        }

        public Criteria andNeedIdNotEqualTo(Integer value) {
            addCriterion("need_id <>", value, "needId");
            return (Criteria) this;
        }

        public Criteria andNeedIdGreaterThan(Integer value) {
            addCriterion("need_id >", value, "needId");
            return (Criteria) this;
        }

        public Criteria andNeedIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("need_id >=", value, "needId");
            return (Criteria) this;
        }

        public Criteria andNeedIdLessThan(Integer value) {
            addCriterion("need_id <", value, "needId");
            return (Criteria) this;
        }

        public Criteria andNeedIdLessThanOrEqualTo(Integer value) {
            addCriterion("need_id <=", value, "needId");
            return (Criteria) this;
        }

        public Criteria andNeedIdIn(List<Integer> values) {
            addCriterion("need_id in", values, "needId");
            return (Criteria) this;
        }

        public Criteria andNeedIdNotIn(List<Integer> values) {
            addCriterion("need_id not in", values, "needId");
            return (Criteria) this;
        }

        public Criteria andNeedIdBetween(Integer value1, Integer value2) {
            addCriterion("need_id between", value1, value2, "needId");
            return (Criteria) this;
        }

        public Criteria andNeedIdNotBetween(Integer value1, Integer value2) {
            addCriterion("need_id not between", value1, value2, "needId");
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

        public Criteria andNeedContentIsNull() {
            addCriterion("need_content is null");
            return (Criteria) this;
        }

        public Criteria andNeedContentIsNotNull() {
            addCriterion("need_content is not null");
            return (Criteria) this;
        }

        public Criteria andNeedContentEqualTo(String value) {
            addCriterion("need_content =", value, "needContent");
            return (Criteria) this;
        }

        public Criteria andNeedContentNotEqualTo(String value) {
            addCriterion("need_content <>", value, "needContent");
            return (Criteria) this;
        }

        public Criteria andNeedContentGreaterThan(String value) {
            addCriterion("need_content >", value, "needContent");
            return (Criteria) this;
        }

        public Criteria andNeedContentGreaterThanOrEqualTo(String value) {
            addCriterion("need_content >=", value, "needContent");
            return (Criteria) this;
        }

        public Criteria andNeedContentLessThan(String value) {
            addCriterion("need_content <", value, "needContent");
            return (Criteria) this;
        }

        public Criteria andNeedContentLessThanOrEqualTo(String value) {
            addCriterion("need_content <=", value, "needContent");
            return (Criteria) this;
        }

        public Criteria andNeedContentLike(String value) {
            addCriterion("need_content like", value, "needContent");
            return (Criteria) this;
        }

        public Criteria andNeedContentNotLike(String value) {
            addCriterion("need_content not like", value, "needContent");
            return (Criteria) this;
        }

        public Criteria andNeedContentIn(List<String> values) {
            addCriterion("need_content in", values, "needContent");
            return (Criteria) this;
        }

        public Criteria andNeedContentNotIn(List<String> values) {
            addCriterion("need_content not in", values, "needContent");
            return (Criteria) this;
        }

        public Criteria andNeedContentBetween(String value1, String value2) {
            addCriterion("need_content between", value1, value2, "needContent");
            return (Criteria) this;
        }

        public Criteria andNeedContentNotBetween(String value1, String value2) {
            addCriterion("need_content not between", value1, value2, "needContent");
            return (Criteria) this;
        }

        public Criteria andNeedPicsIsNull() {
            addCriterion("need_pics is null");
            return (Criteria) this;
        }

        public Criteria andNeedPicsIsNotNull() {
            addCriterion("need_pics is not null");
            return (Criteria) this;
        }

        public Criteria andNeedPicsEqualTo(String value) {
            addCriterion("need_pics =", value, "needPics");
            return (Criteria) this;
        }

        public Criteria andNeedPicsNotEqualTo(String value) {
            addCriterion("need_pics <>", value, "needPics");
            return (Criteria) this;
        }

        public Criteria andNeedPicsGreaterThan(String value) {
            addCriterion("need_pics >", value, "needPics");
            return (Criteria) this;
        }

        public Criteria andNeedPicsGreaterThanOrEqualTo(String value) {
            addCriterion("need_pics >=", value, "needPics");
            return (Criteria) this;
        }

        public Criteria andNeedPicsLessThan(String value) {
            addCriterion("need_pics <", value, "needPics");
            return (Criteria) this;
        }

        public Criteria andNeedPicsLessThanOrEqualTo(String value) {
            addCriterion("need_pics <=", value, "needPics");
            return (Criteria) this;
        }

        public Criteria andNeedPicsLike(String value) {
            addCriterion("need_pics like", value, "needPics");
            return (Criteria) this;
        }

        public Criteria andNeedPicsNotLike(String value) {
            addCriterion("need_pics not like", value, "needPics");
            return (Criteria) this;
        }

        public Criteria andNeedPicsIn(List<String> values) {
            addCriterion("need_pics in", values, "needPics");
            return (Criteria) this;
        }

        public Criteria andNeedPicsNotIn(List<String> values) {
            addCriterion("need_pics not in", values, "needPics");
            return (Criteria) this;
        }

        public Criteria andNeedPicsBetween(String value1, String value2) {
            addCriterion("need_pics between", value1, value2, "needPics");
            return (Criteria) this;
        }

        public Criteria andNeedPicsNotBetween(String value1, String value2) {
            addCriterion("need_pics not between", value1, value2, "needPics");
            return (Criteria) this;
        }

        public Criteria andNeedViewNumIsNull() {
            addCriterion("need_view_num is null");
            return (Criteria) this;
        }

        public Criteria andNeedViewNumIsNotNull() {
            addCriterion("need_view_num is not null");
            return (Criteria) this;
        }

        public Criteria andNeedViewNumEqualTo(Integer value) {
            addCriterion("need_view_num =", value, "needViewNum");
            return (Criteria) this;
        }

        public Criteria andNeedViewNumNotEqualTo(Integer value) {
            addCriterion("need_view_num <>", value, "needViewNum");
            return (Criteria) this;
        }

        public Criteria andNeedViewNumGreaterThan(Integer value) {
            addCriterion("need_view_num >", value, "needViewNum");
            return (Criteria) this;
        }

        public Criteria andNeedViewNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("need_view_num >=", value, "needViewNum");
            return (Criteria) this;
        }

        public Criteria andNeedViewNumLessThan(Integer value) {
            addCriterion("need_view_num <", value, "needViewNum");
            return (Criteria) this;
        }

        public Criteria andNeedViewNumLessThanOrEqualTo(Integer value) {
            addCriterion("need_view_num <=", value, "needViewNum");
            return (Criteria) this;
        }

        public Criteria andNeedViewNumIn(List<Integer> values) {
            addCriterion("need_view_num in", values, "needViewNum");
            return (Criteria) this;
        }

        public Criteria andNeedViewNumNotIn(List<Integer> values) {
            addCriterion("need_view_num not in", values, "needViewNum");
            return (Criteria) this;
        }

        public Criteria andNeedViewNumBetween(Integer value1, Integer value2) {
            addCriterion("need_view_num between", value1, value2, "needViewNum");
            return (Criteria) this;
        }

        public Criteria andNeedViewNumNotBetween(Integer value1, Integer value2) {
            addCriterion("need_view_num not between", value1, value2, "needViewNum");
            return (Criteria) this;
        }

        public Criteria andNeedTimeIsNull() {
            addCriterion("need_time is null");
            return (Criteria) this;
        }

        public Criteria andNeedTimeIsNotNull() {
            addCriterion("need_time is not null");
            return (Criteria) this;
        }

        public Criteria andNeedTimeEqualTo(Date value) {
            addCriterion("need_time =", value, "needTime");
            return (Criteria) this;
        }

        public Criteria andNeedTimeNotEqualTo(Date value) {
            addCriterion("need_time <>", value, "needTime");
            return (Criteria) this;
        }

        public Criteria andNeedTimeGreaterThan(Date value) {
            addCriterion("need_time >", value, "needTime");
            return (Criteria) this;
        }

        public Criteria andNeedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("need_time >=", value, "needTime");
            return (Criteria) this;
        }

        public Criteria andNeedTimeLessThan(Date value) {
            addCriterion("need_time <", value, "needTime");
            return (Criteria) this;
        }

        public Criteria andNeedTimeLessThanOrEqualTo(Date value) {
            addCriterion("need_time <=", value, "needTime");
            return (Criteria) this;
        }

        public Criteria andNeedTimeIn(List<Date> values) {
            addCriterion("need_time in", values, "needTime");
            return (Criteria) this;
        }

        public Criteria andNeedTimeNotIn(List<Date> values) {
            addCriterion("need_time not in", values, "needTime");
            return (Criteria) this;
        }

        public Criteria andNeedTimeBetween(Date value1, Date value2) {
            addCriterion("need_time between", value1, value2, "needTime");
            return (Criteria) this;
        }

        public Criteria andNeedTimeNotBetween(Date value1, Date value2) {
            addCriterion("need_time not between", value1, value2, "needTime");
            return (Criteria) this;
        }

        public Criteria andNeedCommentNumIsNull() {
            addCriterion("need_comment_num is null");
            return (Criteria) this;
        }

        public Criteria andNeedCommentNumIsNotNull() {
            addCriterion("need_comment_num is not null");
            return (Criteria) this;
        }

        public Criteria andNeedCommentNumEqualTo(Integer value) {
            addCriterion("need_comment_num =", value, "needCommentNum");
            return (Criteria) this;
        }

        public Criteria andNeedCommentNumNotEqualTo(Integer value) {
            addCriterion("need_comment_num <>", value, "needCommentNum");
            return (Criteria) this;
        }

        public Criteria andNeedCommentNumGreaterThan(Integer value) {
            addCriterion("need_comment_num >", value, "needCommentNum");
            return (Criteria) this;
        }

        public Criteria andNeedCommentNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("need_comment_num >=", value, "needCommentNum");
            return (Criteria) this;
        }

        public Criteria andNeedCommentNumLessThan(Integer value) {
            addCriterion("need_comment_num <", value, "needCommentNum");
            return (Criteria) this;
        }

        public Criteria andNeedCommentNumLessThanOrEqualTo(Integer value) {
            addCriterion("need_comment_num <=", value, "needCommentNum");
            return (Criteria) this;
        }

        public Criteria andNeedCommentNumIn(List<Integer> values) {
            addCriterion("need_comment_num in", values, "needCommentNum");
            return (Criteria) this;
        }

        public Criteria andNeedCommentNumNotIn(List<Integer> values) {
            addCriterion("need_comment_num not in", values, "needCommentNum");
            return (Criteria) this;
        }

        public Criteria andNeedCommentNumBetween(Integer value1, Integer value2) {
            addCriterion("need_comment_num between", value1, value2, "needCommentNum");
            return (Criteria) this;
        }

        public Criteria andNeedCommentNumNotBetween(Integer value1, Integer value2) {
            addCriterion("need_comment_num not between", value1, value2, "needCommentNum");
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