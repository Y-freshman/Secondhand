package com.schoolTao.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
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

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceIsNull() {
            addCriterion("goods_old_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceIsNotNull() {
            addCriterion("goods_old_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceEqualTo(Integer value) {
            addCriterion("goods_old_price =", value, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceNotEqualTo(Integer value) {
            addCriterion("goods_old_price <>", value, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceGreaterThan(Integer value) {
            addCriterion("goods_old_price >", value, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_old_price >=", value, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceLessThan(Integer value) {
            addCriterion("goods_old_price <", value, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceLessThanOrEqualTo(Integer value) {
            addCriterion("goods_old_price <=", value, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceIn(List<Integer> values) {
            addCriterion("goods_old_price in", values, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceNotIn(List<Integer> values) {
            addCriterion("goods_old_price not in", values, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceBetween(Integer value1, Integer value2) {
            addCriterion("goods_old_price between", value1, value2, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_old_price not between", value1, value2, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsNewPriceIsNull() {
            addCriterion("goods_new_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNewPriceIsNotNull() {
            addCriterion("goods_new_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNewPriceEqualTo(Integer value) {
            addCriterion("goods_new_price =", value, "goodsNewPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsNewPriceNotEqualTo(Integer value) {
            addCriterion("goods_new_price <>", value, "goodsNewPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsNewPriceGreaterThan(Integer value) {
            addCriterion("goods_new_price >", value, "goodsNewPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsNewPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_new_price >=", value, "goodsNewPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsNewPriceLessThan(Integer value) {
            addCriterion("goods_new_price <", value, "goodsNewPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsNewPriceLessThanOrEqualTo(Integer value) {
            addCriterion("goods_new_price <=", value, "goodsNewPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsNewPriceIn(List<Integer> values) {
            addCriterion("goods_new_price in", values, "goodsNewPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsNewPriceNotIn(List<Integer> values) {
            addCriterion("goods_new_price not in", values, "goodsNewPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsNewPriceBetween(Integer value1, Integer value2) {
            addCriterion("goods_new_price between", value1, value2, "goodsNewPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsNewPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_new_price not between", value1, value2, "goodsNewPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsFreshIsNull() {
            addCriterion("goods_fresh is null");
            return (Criteria) this;
        }

        public Criteria andGoodsFreshIsNotNull() {
            addCriterion("goods_fresh is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsFreshEqualTo(Byte value) {
            addCriterion("goods_fresh =", value, "goodsFresh");
            return (Criteria) this;
        }

        public Criteria andGoodsFreshNotEqualTo(Byte value) {
            addCriterion("goods_fresh <>", value, "goodsFresh");
            return (Criteria) this;
        }

        public Criteria andGoodsFreshGreaterThan(Byte value) {
            addCriterion("goods_fresh >", value, "goodsFresh");
            return (Criteria) this;
        }

        public Criteria andGoodsFreshGreaterThanOrEqualTo(Byte value) {
            addCriterion("goods_fresh >=", value, "goodsFresh");
            return (Criteria) this;
        }

        public Criteria andGoodsFreshLessThan(Byte value) {
            addCriterion("goods_fresh <", value, "goodsFresh");
            return (Criteria) this;
        }

        public Criteria andGoodsFreshLessThanOrEqualTo(Byte value) {
            addCriterion("goods_fresh <=", value, "goodsFresh");
            return (Criteria) this;
        }

        public Criteria andGoodsFreshIn(List<Byte> values) {
            addCriterion("goods_fresh in", values, "goodsFresh");
            return (Criteria) this;
        }

        public Criteria andGoodsFreshNotIn(List<Byte> values) {
            addCriterion("goods_fresh not in", values, "goodsFresh");
            return (Criteria) this;
        }

        public Criteria andGoodsFreshBetween(Byte value1, Byte value2) {
            addCriterion("goods_fresh between", value1, value2, "goodsFresh");
            return (Criteria) this;
        }

        public Criteria andGoodsFreshNotBetween(Byte value1, Byte value2) {
            addCriterion("goods_fresh not between", value1, value2, "goodsFresh");
            return (Criteria) this;
        }

        public Criteria andGoodsNumIsNull() {
            addCriterion("goods_num is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumIsNotNull() {
            addCriterion("goods_num is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumEqualTo(Integer value) {
            addCriterion("goods_num =", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumNotEqualTo(Integer value) {
            addCriterion("goods_num <>", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumGreaterThan(Integer value) {
            addCriterion("goods_num >", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_num >=", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumLessThan(Integer value) {
            addCriterion("goods_num <", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumLessThanOrEqualTo(Integer value) {
            addCriterion("goods_num <=", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumIn(List<Integer> values) {
            addCriterion("goods_num in", values, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumNotIn(List<Integer> values) {
            addCriterion("goods_num not in", values, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumBetween(Integer value1, Integer value2) {
            addCriterion("goods_num between", value1, value2, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_num not between", value1, value2, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsUserPhoneIsNull() {
            addCriterion("goods_user_phone is null");
            return (Criteria) this;
        }

        public Criteria andGoodsUserPhoneIsNotNull() {
            addCriterion("goods_user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsUserPhoneEqualTo(String value) {
            addCriterion("goods_user_phone =", value, "goodsUserPhone");
            return (Criteria) this;
        }

        public Criteria andGoodsUserPhoneNotEqualTo(String value) {
            addCriterion("goods_user_phone <>", value, "goodsUserPhone");
            return (Criteria) this;
        }

        public Criteria andGoodsUserPhoneGreaterThan(String value) {
            addCriterion("goods_user_phone >", value, "goodsUserPhone");
            return (Criteria) this;
        }

        public Criteria andGoodsUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("goods_user_phone >=", value, "goodsUserPhone");
            return (Criteria) this;
        }

        public Criteria andGoodsUserPhoneLessThan(String value) {
            addCriterion("goods_user_phone <", value, "goodsUserPhone");
            return (Criteria) this;
        }

        public Criteria andGoodsUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("goods_user_phone <=", value, "goodsUserPhone");
            return (Criteria) this;
        }

        public Criteria andGoodsUserPhoneLike(String value) {
            addCriterion("goods_user_phone like", value, "goodsUserPhone");
            return (Criteria) this;
        }

        public Criteria andGoodsUserPhoneNotLike(String value) {
            addCriterion("goods_user_phone not like", value, "goodsUserPhone");
            return (Criteria) this;
        }

        public Criteria andGoodsUserPhoneIn(List<String> values) {
            addCriterion("goods_user_phone in", values, "goodsUserPhone");
            return (Criteria) this;
        }

        public Criteria andGoodsUserPhoneNotIn(List<String> values) {
            addCriterion("goods_user_phone not in", values, "goodsUserPhone");
            return (Criteria) this;
        }

        public Criteria andGoodsUserPhoneBetween(String value1, String value2) {
            addCriterion("goods_user_phone between", value1, value2, "goodsUserPhone");
            return (Criteria) this;
        }

        public Criteria andGoodsUserPhoneNotBetween(String value1, String value2) {
            addCriterion("goods_user_phone not between", value1, value2, "goodsUserPhone");
            return (Criteria) this;
        }

        public Criteria andGoodsUserNameIsNull() {
            addCriterion("goods_user_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsUserNameIsNotNull() {
            addCriterion("goods_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsUserNameEqualTo(String value) {
            addCriterion("goods_user_name =", value, "goodsUserName");
            return (Criteria) this;
        }

        public Criteria andGoodsUserNameNotEqualTo(String value) {
            addCriterion("goods_user_name <>", value, "goodsUserName");
            return (Criteria) this;
        }

        public Criteria andGoodsUserNameGreaterThan(String value) {
            addCriterion("goods_user_name >", value, "goodsUserName");
            return (Criteria) this;
        }

        public Criteria andGoodsUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_user_name >=", value, "goodsUserName");
            return (Criteria) this;
        }

        public Criteria andGoodsUserNameLessThan(String value) {
            addCriterion("goods_user_name <", value, "goodsUserName");
            return (Criteria) this;
        }

        public Criteria andGoodsUserNameLessThanOrEqualTo(String value) {
            addCriterion("goods_user_name <=", value, "goodsUserName");
            return (Criteria) this;
        }

        public Criteria andGoodsUserNameLike(String value) {
            addCriterion("goods_user_name like", value, "goodsUserName");
            return (Criteria) this;
        }

        public Criteria andGoodsUserNameNotLike(String value) {
            addCriterion("goods_user_name not like", value, "goodsUserName");
            return (Criteria) this;
        }

        public Criteria andGoodsUserNameIn(List<String> values) {
            addCriterion("goods_user_name in", values, "goodsUserName");
            return (Criteria) this;
        }

        public Criteria andGoodsUserNameNotIn(List<String> values) {
            addCriterion("goods_user_name not in", values, "goodsUserName");
            return (Criteria) this;
        }

        public Criteria andGoodsUserNameBetween(String value1, String value2) {
            addCriterion("goods_user_name between", value1, value2, "goodsUserName");
            return (Criteria) this;
        }

        public Criteria andGoodsUserNameNotBetween(String value1, String value2) {
            addCriterion("goods_user_name not between", value1, value2, "goodsUserName");
            return (Criteria) this;
        }

        public Criteria andGoodsPicsIsNull() {
            addCriterion("goods_pics is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPicsIsNotNull() {
            addCriterion("goods_pics is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPicsEqualTo(String value) {
            addCriterion("goods_pics =", value, "goodsPics");
            return (Criteria) this;
        }

        public Criteria andGoodsPicsNotEqualTo(String value) {
            addCriterion("goods_pics <>", value, "goodsPics");
            return (Criteria) this;
        }

        public Criteria andGoodsPicsGreaterThan(String value) {
            addCriterion("goods_pics >", value, "goodsPics");
            return (Criteria) this;
        }

        public Criteria andGoodsPicsGreaterThanOrEqualTo(String value) {
            addCriterion("goods_pics >=", value, "goodsPics");
            return (Criteria) this;
        }

        public Criteria andGoodsPicsLessThan(String value) {
            addCriterion("goods_pics <", value, "goodsPics");
            return (Criteria) this;
        }

        public Criteria andGoodsPicsLessThanOrEqualTo(String value) {
            addCriterion("goods_pics <=", value, "goodsPics");
            return (Criteria) this;
        }

        public Criteria andGoodsPicsLike(String value) {
            addCriterion("goods_pics like", value, "goodsPics");
            return (Criteria) this;
        }

        public Criteria andGoodsPicsNotLike(String value) {
            addCriterion("goods_pics not like", value, "goodsPics");
            return (Criteria) this;
        }

        public Criteria andGoodsPicsIn(List<String> values) {
            addCriterion("goods_pics in", values, "goodsPics");
            return (Criteria) this;
        }

        public Criteria andGoodsPicsNotIn(List<String> values) {
            addCriterion("goods_pics not in", values, "goodsPics");
            return (Criteria) this;
        }

        public Criteria andGoodsPicsBetween(String value1, String value2) {
            addCriterion("goods_pics between", value1, value2, "goodsPics");
            return (Criteria) this;
        }

        public Criteria andGoodsPicsNotBetween(String value1, String value2) {
            addCriterion("goods_pics not between", value1, value2, "goodsPics");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNull() {
            addCriterion("goods_type is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNotNull() {
            addCriterion("goods_type is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeEqualTo(String value) {
            addCriterion("goods_type =", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotEqualTo(String value) {
            addCriterion("goods_type <>", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThan(String value) {
            addCriterion("goods_type >", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("goods_type >=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThan(String value) {
            addCriterion("goods_type <", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThanOrEqualTo(String value) {
            addCriterion("goods_type <=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLike(String value) {
            addCriterion("goods_type like", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotLike(String value) {
            addCriterion("goods_type not like", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIn(List<String> values) {
            addCriterion("goods_type in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotIn(List<String> values) {
            addCriterion("goods_type not in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeBetween(String value1, String value2) {
            addCriterion("goods_type between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotBetween(String value1, String value2) {
            addCriterion("goods_type not between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTimeIsNull() {
            addCriterion("goods_time is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTimeIsNotNull() {
            addCriterion("goods_time is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTimeEqualTo(Date value) {
            addCriterion("goods_time =", value, "goodsTime");
            return (Criteria) this;
        }

        public Criteria andGoodsTimeNotEqualTo(Date value) {
            addCriterion("goods_time <>", value, "goodsTime");
            return (Criteria) this;
        }

        public Criteria andGoodsTimeGreaterThan(Date value) {
            addCriterion("goods_time >", value, "goodsTime");
            return (Criteria) this;
        }

        public Criteria andGoodsTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("goods_time >=", value, "goodsTime");
            return (Criteria) this;
        }

        public Criteria andGoodsTimeLessThan(Date value) {
            addCriterion("goods_time <", value, "goodsTime");
            return (Criteria) this;
        }

        public Criteria andGoodsTimeLessThanOrEqualTo(Date value) {
            addCriterion("goods_time <=", value, "goodsTime");
            return (Criteria) this;
        }

        public Criteria andGoodsTimeIn(List<Date> values) {
            addCriterion("goods_time in", values, "goodsTime");
            return (Criteria) this;
        }

        public Criteria andGoodsTimeNotIn(List<Date> values) {
            addCriterion("goods_time not in", values, "goodsTime");
            return (Criteria) this;
        }

        public Criteria andGoodsTimeBetween(Date value1, Date value2) {
            addCriterion("goods_time between", value1, value2, "goodsTime");
            return (Criteria) this;
        }

        public Criteria andGoodsTimeNotBetween(Date value1, Date value2) {
            addCriterion("goods_time not between", value1, value2, "goodsTime");
            return (Criteria) this;
        }

        public Criteria andGoodsStateIsNull() {
            addCriterion("goods_state is null");
            return (Criteria) this;
        }

        public Criteria andGoodsStateIsNotNull() {
            addCriterion("goods_state is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsStateEqualTo(String value) {
            addCriterion("goods_state =", value, "goodsState");
            return (Criteria) this;
        }

        public Criteria andGoodsStateNotEqualTo(String value) {
            addCriterion("goods_state <>", value, "goodsState");
            return (Criteria) this;
        }

        public Criteria andGoodsStateGreaterThan(String value) {
            addCriterion("goods_state >", value, "goodsState");
            return (Criteria) this;
        }

        public Criteria andGoodsStateGreaterThanOrEqualTo(String value) {
            addCriterion("goods_state >=", value, "goodsState");
            return (Criteria) this;
        }

        public Criteria andGoodsStateLessThan(String value) {
            addCriterion("goods_state <", value, "goodsState");
            return (Criteria) this;
        }

        public Criteria andGoodsStateLessThanOrEqualTo(String value) {
            addCriterion("goods_state <=", value, "goodsState");
            return (Criteria) this;
        }

        public Criteria andGoodsStateLike(String value) {
            addCriterion("goods_state like", value, "goodsState");
            return (Criteria) this;
        }

        public Criteria andGoodsStateNotLike(String value) {
            addCriterion("goods_state not like", value, "goodsState");
            return (Criteria) this;
        }

        public Criteria andGoodsStateIn(List<String> values) {
            addCriterion("goods_state in", values, "goodsState");
            return (Criteria) this;
        }

        public Criteria andGoodsStateNotIn(List<String> values) {
            addCriterion("goods_state not in", values, "goodsState");
            return (Criteria) this;
        }

        public Criteria andGoodsStateBetween(String value1, String value2) {
            addCriterion("goods_state between", value1, value2, "goodsState");
            return (Criteria) this;
        }

        public Criteria andGoodsStateNotBetween(String value1, String value2) {
            addCriterion("goods_state not between", value1, value2, "goodsState");
            return (Criteria) this;
        }

        public Criteria andGoodsViewNumIsNull() {
            addCriterion("goods_view_num is null");
            return (Criteria) this;
        }

        public Criteria andGoodsViewNumIsNotNull() {
            addCriterion("goods_view_num is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsViewNumEqualTo(Integer value) {
            addCriterion("goods_view_num =", value, "goodsViewNum");
            return (Criteria) this;
        }

        public Criteria andGoodsViewNumNotEqualTo(Integer value) {
            addCriterion("goods_view_num <>", value, "goodsViewNum");
            return (Criteria) this;
        }

        public Criteria andGoodsViewNumGreaterThan(Integer value) {
            addCriterion("goods_view_num >", value, "goodsViewNum");
            return (Criteria) this;
        }

        public Criteria andGoodsViewNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_view_num >=", value, "goodsViewNum");
            return (Criteria) this;
        }

        public Criteria andGoodsViewNumLessThan(Integer value) {
            addCriterion("goods_view_num <", value, "goodsViewNum");
            return (Criteria) this;
        }

        public Criteria andGoodsViewNumLessThanOrEqualTo(Integer value) {
            addCriterion("goods_view_num <=", value, "goodsViewNum");
            return (Criteria) this;
        }

        public Criteria andGoodsViewNumIn(List<Integer> values) {
            addCriterion("goods_view_num in", values, "goodsViewNum");
            return (Criteria) this;
        }

        public Criteria andGoodsViewNumNotIn(List<Integer> values) {
            addCriterion("goods_view_num not in", values, "goodsViewNum");
            return (Criteria) this;
        }

        public Criteria andGoodsViewNumBetween(Integer value1, Integer value2) {
            addCriterion("goods_view_num between", value1, value2, "goodsViewNum");
            return (Criteria) this;
        }

        public Criteria andGoodsViewNumNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_view_num not between", value1, value2, "goodsViewNum");
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