package com.schoolTao.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNull() {
            addCriterion("user_password is null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNotNull() {
            addCriterion("user_password is not null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordEqualTo(String value) {
            addCriterion("user_password =", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotEqualTo(String value) {
            addCriterion("user_password <>", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThan(String value) {
            addCriterion("user_password >", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("user_password >=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThan(String value) {
            addCriterion("user_password <", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("user_password <=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLike(String value) {
            addCriterion("user_password like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotLike(String value) {
            addCriterion("user_password not like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIn(List<String> values) {
            addCriterion("user_password in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotIn(List<String> values) {
            addCriterion("user_password not in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordBetween(String value1, String value2) {
            addCriterion("user_password between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotBetween(String value1, String value2) {
            addCriterion("user_password not between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNull() {
            addCriterion("user_sex is null");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNotNull() {
            addCriterion("user_sex is not null");
            return (Criteria) this;
        }

        public Criteria andUserSexEqualTo(String value) {
            addCriterion("user_sex =", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotEqualTo(String value) {
            addCriterion("user_sex <>", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThan(String value) {
            addCriterion("user_sex >", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThanOrEqualTo(String value) {
            addCriterion("user_sex >=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThan(String value) {
            addCriterion("user_sex <", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThanOrEqualTo(String value) {
            addCriterion("user_sex <=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLike(String value) {
            addCriterion("user_sex like", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotLike(String value) {
            addCriterion("user_sex not like", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexIn(List<String> values) {
            addCriterion("user_sex in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotIn(List<String> values) {
            addCriterion("user_sex not in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexBetween(String value1, String value2) {
            addCriterion("user_sex between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotBetween(String value1, String value2) {
            addCriterion("user_sex not between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserIntroIsNull() {
            addCriterion("user_intro is null");
            return (Criteria) this;
        }

        public Criteria andUserIntroIsNotNull() {
            addCriterion("user_intro is not null");
            return (Criteria) this;
        }

        public Criteria andUserIntroEqualTo(String value) {
            addCriterion("user_intro =", value, "userIntro");
            return (Criteria) this;
        }

        public Criteria andUserIntroNotEqualTo(String value) {
            addCriterion("user_intro <>", value, "userIntro");
            return (Criteria) this;
        }

        public Criteria andUserIntroGreaterThan(String value) {
            addCriterion("user_intro >", value, "userIntro");
            return (Criteria) this;
        }

        public Criteria andUserIntroGreaterThanOrEqualTo(String value) {
            addCriterion("user_intro >=", value, "userIntro");
            return (Criteria) this;
        }

        public Criteria andUserIntroLessThan(String value) {
            addCriterion("user_intro <", value, "userIntro");
            return (Criteria) this;
        }

        public Criteria andUserIntroLessThanOrEqualTo(String value) {
            addCriterion("user_intro <=", value, "userIntro");
            return (Criteria) this;
        }

        public Criteria andUserIntroLike(String value) {
            addCriterion("user_intro like", value, "userIntro");
            return (Criteria) this;
        }

        public Criteria andUserIntroNotLike(String value) {
            addCriterion("user_intro not like", value, "userIntro");
            return (Criteria) this;
        }

        public Criteria andUserIntroIn(List<String> values) {
            addCriterion("user_intro in", values, "userIntro");
            return (Criteria) this;
        }

        public Criteria andUserIntroNotIn(List<String> values) {
            addCriterion("user_intro not in", values, "userIntro");
            return (Criteria) this;
        }

        public Criteria andUserIntroBetween(String value1, String value2) {
            addCriterion("user_intro between", value1, value2, "userIntro");
            return (Criteria) this;
        }

        public Criteria andUserIntroNotBetween(String value1, String value2) {
            addCriterion("user_intro not between", value1, value2, "userIntro");
            return (Criteria) this;
        }

        public Criteria andUserAvaterIsNull() {
            addCriterion("user_avater is null");
            return (Criteria) this;
        }

        public Criteria andUserAvaterIsNotNull() {
            addCriterion("user_avater is not null");
            return (Criteria) this;
        }

        public Criteria andUserAvaterEqualTo(String value) {
            addCriterion("user_avater =", value, "userAvater");
            return (Criteria) this;
        }

        public Criteria andUserAvaterNotEqualTo(String value) {
            addCriterion("user_avater <>", value, "userAvater");
            return (Criteria) this;
        }

        public Criteria andUserAvaterGreaterThan(String value) {
            addCriterion("user_avater >", value, "userAvater");
            return (Criteria) this;
        }

        public Criteria andUserAvaterGreaterThanOrEqualTo(String value) {
            addCriterion("user_avater >=", value, "userAvater");
            return (Criteria) this;
        }

        public Criteria andUserAvaterLessThan(String value) {
            addCriterion("user_avater <", value, "userAvater");
            return (Criteria) this;
        }

        public Criteria andUserAvaterLessThanOrEqualTo(String value) {
            addCriterion("user_avater <=", value, "userAvater");
            return (Criteria) this;
        }

        public Criteria andUserAvaterLike(String value) {
            addCriterion("user_avater like", value, "userAvater");
            return (Criteria) this;
        }

        public Criteria andUserAvaterNotLike(String value) {
            addCriterion("user_avater not like", value, "userAvater");
            return (Criteria) this;
        }

        public Criteria andUserAvaterIn(List<String> values) {
            addCriterion("user_avater in", values, "userAvater");
            return (Criteria) this;
        }

        public Criteria andUserAvaterNotIn(List<String> values) {
            addCriterion("user_avater not in", values, "userAvater");
            return (Criteria) this;
        }

        public Criteria andUserAvaterBetween(String value1, String value2) {
            addCriterion("user_avater between", value1, value2, "userAvater");
            return (Criteria) this;
        }

        public Criteria andUserAvaterNotBetween(String value1, String value2) {
            addCriterion("user_avater not between", value1, value2, "userAvater");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeIsNull() {
            addCriterion("user_register_time is null");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeIsNotNull() {
            addCriterion("user_register_time is not null");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeEqualTo(Date value) {
            addCriterion("user_register_time =", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeNotEqualTo(Date value) {
            addCriterion("user_register_time <>", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeGreaterThan(Date value) {
            addCriterion("user_register_time >", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("user_register_time >=", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeLessThan(Date value) {
            addCriterion("user_register_time <", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeLessThanOrEqualTo(Date value) {
            addCriterion("user_register_time <=", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeIn(List<Date> values) {
            addCriterion("user_register_time in", values, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeNotIn(List<Date> values) {
            addCriterion("user_register_time not in", values, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeBetween(Date value1, Date value2) {
            addCriterion("user_register_time between", value1, value2, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeNotBetween(Date value1, Date value2) {
            addCriterion("user_register_time not between", value1, value2, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserMibaoIsNull() {
            addCriterion("user_mibao is null");
            return (Criteria) this;
        }

        public Criteria andUserMibaoIsNotNull() {
            addCriterion("user_mibao is not null");
            return (Criteria) this;
        }

        public Criteria andUserMibaoEqualTo(String value) {
            addCriterion("user_mibao =", value, "userMibao");
            return (Criteria) this;
        }

        public Criteria andUserMibaoNotEqualTo(String value) {
            addCriterion("user_mibao <>", value, "userMibao");
            return (Criteria) this;
        }

        public Criteria andUserMibaoGreaterThan(String value) {
            addCriterion("user_mibao >", value, "userMibao");
            return (Criteria) this;
        }

        public Criteria andUserMibaoGreaterThanOrEqualTo(String value) {
            addCriterion("user_mibao >=", value, "userMibao");
            return (Criteria) this;
        }

        public Criteria andUserMibaoLessThan(String value) {
            addCriterion("user_mibao <", value, "userMibao");
            return (Criteria) this;
        }

        public Criteria andUserMibaoLessThanOrEqualTo(String value) {
            addCriterion("user_mibao <=", value, "userMibao");
            return (Criteria) this;
        }

        public Criteria andUserMibaoLike(String value) {
            addCriterion("user_mibao like", value, "userMibao");
            return (Criteria) this;
        }

        public Criteria andUserMibaoNotLike(String value) {
            addCriterion("user_mibao not like", value, "userMibao");
            return (Criteria) this;
        }

        public Criteria andUserMibaoIn(List<String> values) {
            addCriterion("user_mibao in", values, "userMibao");
            return (Criteria) this;
        }

        public Criteria andUserMibaoNotIn(List<String> values) {
            addCriterion("user_mibao not in", values, "userMibao");
            return (Criteria) this;
        }

        public Criteria andUserMibaoBetween(String value1, String value2) {
            addCriterion("user_mibao between", value1, value2, "userMibao");
            return (Criteria) this;
        }

        public Criteria andUserMibaoNotBetween(String value1, String value2) {
            addCriterion("user_mibao not between", value1, value2, "userMibao");
            return (Criteria) this;
        }

        public Criteria andUserAnswerIsNull() {
            addCriterion("user_answer is null");
            return (Criteria) this;
        }

        public Criteria andUserAnswerIsNotNull() {
            addCriterion("user_answer is not null");
            return (Criteria) this;
        }

        public Criteria andUserAnswerEqualTo(String value) {
            addCriterion("user_answer =", value, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerNotEqualTo(String value) {
            addCriterion("user_answer <>", value, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerGreaterThan(String value) {
            addCriterion("user_answer >", value, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("user_answer >=", value, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerLessThan(String value) {
            addCriterion("user_answer <", value, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerLessThanOrEqualTo(String value) {
            addCriterion("user_answer <=", value, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerLike(String value) {
            addCriterion("user_answer like", value, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerNotLike(String value) {
            addCriterion("user_answer not like", value, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerIn(List<String> values) {
            addCriterion("user_answer in", values, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerNotIn(List<String> values) {
            addCriterion("user_answer not in", values, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerBetween(String value1, String value2) {
            addCriterion("user_answer between", value1, value2, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerNotBetween(String value1, String value2) {
            addCriterion("user_answer not between", value1, value2, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserRemainNumIsNull() {
            addCriterion("user_remain_num is null");
            return (Criteria) this;
        }

        public Criteria andUserRemainNumIsNotNull() {
            addCriterion("user_remain_num is not null");
            return (Criteria) this;
        }

        public Criteria andUserRemainNumEqualTo(Integer value) {
            addCriterion("user_remain_num =", value, "userRemainNum");
            return (Criteria) this;
        }

        public Criteria andUserRemainNumNotEqualTo(Integer value) {
            addCriterion("user_remain_num <>", value, "userRemainNum");
            return (Criteria) this;
        }

        public Criteria andUserRemainNumGreaterThan(Integer value) {
            addCriterion("user_remain_num >", value, "userRemainNum");
            return (Criteria) this;
        }

        public Criteria andUserRemainNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_remain_num >=", value, "userRemainNum");
            return (Criteria) this;
        }

        public Criteria andUserRemainNumLessThan(Integer value) {
            addCriterion("user_remain_num <", value, "userRemainNum");
            return (Criteria) this;
        }

        public Criteria andUserRemainNumLessThanOrEqualTo(Integer value) {
            addCriterion("user_remain_num <=", value, "userRemainNum");
            return (Criteria) this;
        }

        public Criteria andUserRemainNumIn(List<Integer> values) {
            addCriterion("user_remain_num in", values, "userRemainNum");
            return (Criteria) this;
        }

        public Criteria andUserRemainNumNotIn(List<Integer> values) {
            addCriterion("user_remain_num not in", values, "userRemainNum");
            return (Criteria) this;
        }

        public Criteria andUserRemainNumBetween(Integer value1, Integer value2) {
            addCriterion("user_remain_num between", value1, value2, "userRemainNum");
            return (Criteria) this;
        }

        public Criteria andUserRemainNumNotBetween(Integer value1, Integer value2) {
            addCriterion("user_remain_num not between", value1, value2, "userRemainNum");
            return (Criteria) this;
        }

        public Criteria andUserPurchaseNumIsNull() {
            addCriterion("user_purchase_num is null");
            return (Criteria) this;
        }

        public Criteria andUserPurchaseNumIsNotNull() {
            addCriterion("user_purchase_num is not null");
            return (Criteria) this;
        }

        public Criteria andUserPurchaseNumEqualTo(Integer value) {
            addCriterion("user_purchase_num =", value, "userPurchaseNum");
            return (Criteria) this;
        }

        public Criteria andUserPurchaseNumNotEqualTo(Integer value) {
            addCriterion("user_purchase_num <>", value, "userPurchaseNum");
            return (Criteria) this;
        }

        public Criteria andUserPurchaseNumGreaterThan(Integer value) {
            addCriterion("user_purchase_num >", value, "userPurchaseNum");
            return (Criteria) this;
        }

        public Criteria andUserPurchaseNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_purchase_num >=", value, "userPurchaseNum");
            return (Criteria) this;
        }

        public Criteria andUserPurchaseNumLessThan(Integer value) {
            addCriterion("user_purchase_num <", value, "userPurchaseNum");
            return (Criteria) this;
        }

        public Criteria andUserPurchaseNumLessThanOrEqualTo(Integer value) {
            addCriterion("user_purchase_num <=", value, "userPurchaseNum");
            return (Criteria) this;
        }

        public Criteria andUserPurchaseNumIn(List<Integer> values) {
            addCriterion("user_purchase_num in", values, "userPurchaseNum");
            return (Criteria) this;
        }

        public Criteria andUserPurchaseNumNotIn(List<Integer> values) {
            addCriterion("user_purchase_num not in", values, "userPurchaseNum");
            return (Criteria) this;
        }

        public Criteria andUserPurchaseNumBetween(Integer value1, Integer value2) {
            addCriterion("user_purchase_num between", value1, value2, "userPurchaseNum");
            return (Criteria) this;
        }

        public Criteria andUserPurchaseNumNotBetween(Integer value1, Integer value2) {
            addCriterion("user_purchase_num not between", value1, value2, "userPurchaseNum");
            return (Criteria) this;
        }

        public Criteria andUserVipIsNull() {
            addCriterion("user_vip is null");
            return (Criteria) this;
        }

        public Criteria andUserVipIsNotNull() {
            addCriterion("user_vip is not null");
            return (Criteria) this;
        }

        public Criteria andUserVipEqualTo(String value) {
            addCriterion("user_vip =", value, "userVip");
            return (Criteria) this;
        }

        public Criteria andUserVipNotEqualTo(String value) {
            addCriterion("user_vip <>", value, "userVip");
            return (Criteria) this;
        }

        public Criteria andUserVipGreaterThan(String value) {
            addCriterion("user_vip >", value, "userVip");
            return (Criteria) this;
        }

        public Criteria andUserVipGreaterThanOrEqualTo(String value) {
            addCriterion("user_vip >=", value, "userVip");
            return (Criteria) this;
        }

        public Criteria andUserVipLessThan(String value) {
            addCriterion("user_vip <", value, "userVip");
            return (Criteria) this;
        }

        public Criteria andUserVipLessThanOrEqualTo(String value) {
            addCriterion("user_vip <=", value, "userVip");
            return (Criteria) this;
        }

        public Criteria andUserVipLike(String value) {
            addCriterion("user_vip like", value, "userVip");
            return (Criteria) this;
        }

        public Criteria andUserVipNotLike(String value) {
            addCriterion("user_vip not like", value, "userVip");
            return (Criteria) this;
        }

        public Criteria andUserVipIn(List<String> values) {
            addCriterion("user_vip in", values, "userVip");
            return (Criteria) this;
        }

        public Criteria andUserVipNotIn(List<String> values) {
            addCriterion("user_vip not in", values, "userVip");
            return (Criteria) this;
        }

        public Criteria andUserVipBetween(String value1, String value2) {
            addCriterion("user_vip between", value1, value2, "userVip");
            return (Criteria) this;
        }

        public Criteria andUserVipNotBetween(String value1, String value2) {
            addCriterion("user_vip not between", value1, value2, "userVip");
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