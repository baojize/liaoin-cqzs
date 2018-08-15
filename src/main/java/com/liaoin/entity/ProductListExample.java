package com.liaoin.entity;

import java.util.ArrayList;
import java.util.List;

public class ProductListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductListExample() {
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

        public Criteria andProductlistIdIsNull() {
            addCriterion("productlist_id is null");
            return (Criteria) this;
        }

        public Criteria andProductlistIdIsNotNull() {
            addCriterion("productlist_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductlistIdEqualTo(Integer value) {
            addCriterion("productlist_id =", value, "productlistId");
            return (Criteria) this;
        }

        public Criteria andProductlistIdNotEqualTo(Integer value) {
            addCriterion("productlist_id <>", value, "productlistId");
            return (Criteria) this;
        }

        public Criteria andProductlistIdGreaterThan(Integer value) {
            addCriterion("productlist_id >", value, "productlistId");
            return (Criteria) this;
        }

        public Criteria andProductlistIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("productlist_id >=", value, "productlistId");
            return (Criteria) this;
        }

        public Criteria andProductlistIdLessThan(Integer value) {
            addCriterion("productlist_id <", value, "productlistId");
            return (Criteria) this;
        }

        public Criteria andProductlistIdLessThanOrEqualTo(Integer value) {
            addCriterion("productlist_id <=", value, "productlistId");
            return (Criteria) this;
        }

        public Criteria andProductlistIdIn(List<Integer> values) {
            addCriterion("productlist_id in", values, "productlistId");
            return (Criteria) this;
        }

        public Criteria andProductlistIdNotIn(List<Integer> values) {
            addCriterion("productlist_id not in", values, "productlistId");
            return (Criteria) this;
        }

        public Criteria andProductlistIdBetween(Integer value1, Integer value2) {
            addCriterion("productlist_id between", value1, value2, "productlistId");
            return (Criteria) this;
        }

        public Criteria andProductlistIdNotBetween(Integer value1, Integer value2) {
            addCriterion("productlist_id not between", value1, value2, "productlistId");
            return (Criteria) this;
        }

        public Criteria andProductlistNameIsNull() {
            addCriterion("productlist_name is null");
            return (Criteria) this;
        }

        public Criteria andProductlistNameIsNotNull() {
            addCriterion("productlist_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductlistNameEqualTo(String value) {
            addCriterion("productlist_name =", value, "productlistName");
            return (Criteria) this;
        }

        public Criteria andProductlistNameNotEqualTo(String value) {
            addCriterion("productlist_name <>", value, "productlistName");
            return (Criteria) this;
        }

        public Criteria andProductlistNameGreaterThan(String value) {
            addCriterion("productlist_name >", value, "productlistName");
            return (Criteria) this;
        }

        public Criteria andProductlistNameGreaterThanOrEqualTo(String value) {
            addCriterion("productlist_name >=", value, "productlistName");
            return (Criteria) this;
        }

        public Criteria andProductlistNameLessThan(String value) {
            addCriterion("productlist_name <", value, "productlistName");
            return (Criteria) this;
        }

        public Criteria andProductlistNameLessThanOrEqualTo(String value) {
            addCriterion("productlist_name <=", value, "productlistName");
            return (Criteria) this;
        }

        public Criteria andProductlistNameLike(String value) {
            addCriterion("productlist_name like", value, "productlistName");
            return (Criteria) this;
        }

        public Criteria andProductlistNameNotLike(String value) {
            addCriterion("productlist_name not like", value, "productlistName");
            return (Criteria) this;
        }

        public Criteria andProductlistNameIn(List<String> values) {
            addCriterion("productlist_name in", values, "productlistName");
            return (Criteria) this;
        }

        public Criteria andProductlistNameNotIn(List<String> values) {
            addCriterion("productlist_name not in", values, "productlistName");
            return (Criteria) this;
        }

        public Criteria andProductlistNameBetween(String value1, String value2) {
            addCriterion("productlist_name between", value1, value2, "productlistName");
            return (Criteria) this;
        }

        public Criteria andProductlistNameNotBetween(String value1, String value2) {
            addCriterion("productlist_name not between", value1, value2, "productlistName");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductlistPriceIsNull() {
            addCriterion("productlist_price is null");
            return (Criteria) this;
        }

        public Criteria andProductlistPriceIsNotNull() {
            addCriterion("productlist_price is not null");
            return (Criteria) this;
        }

        public Criteria andProductlistPriceEqualTo(Double value) {
            addCriterion("productlist_price =", value, "productlistPrice");
            return (Criteria) this;
        }

        public Criteria andProductlistPriceNotEqualTo(Double value) {
            addCriterion("productlist_price <>", value, "productlistPrice");
            return (Criteria) this;
        }

        public Criteria andProductlistPriceGreaterThan(Double value) {
            addCriterion("productlist_price >", value, "productlistPrice");
            return (Criteria) this;
        }

        public Criteria andProductlistPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("productlist_price >=", value, "productlistPrice");
            return (Criteria) this;
        }

        public Criteria andProductlistPriceLessThan(Double value) {
            addCriterion("productlist_price <", value, "productlistPrice");
            return (Criteria) this;
        }

        public Criteria andProductlistPriceLessThanOrEqualTo(Double value) {
            addCriterion("productlist_price <=", value, "productlistPrice");
            return (Criteria) this;
        }

        public Criteria andProductlistPriceIn(List<Double> values) {
            addCriterion("productlist_price in", values, "productlistPrice");
            return (Criteria) this;
        }

        public Criteria andProductlistPriceNotIn(List<Double> values) {
            addCriterion("productlist_price not in", values, "productlistPrice");
            return (Criteria) this;
        }

        public Criteria andProductlistPriceBetween(Double value1, Double value2) {
            addCriterion("productlist_price between", value1, value2, "productlistPrice");
            return (Criteria) this;
        }

        public Criteria andProductlistPriceNotBetween(Double value1, Double value2) {
            addCriterion("productlist_price not between", value1, value2, "productlistPrice");
            return (Criteria) this;
        }

        public Criteria andProductlistDetailsIsNull() {
            addCriterion("productlist_details is null");
            return (Criteria) this;
        }

        public Criteria andProductlistDetailsIsNotNull() {
            addCriterion("productlist_details is not null");
            return (Criteria) this;
        }

        public Criteria andProductlistDetailsEqualTo(String value) {
            addCriterion("productlist_details =", value, "productlistDetails");
            return (Criteria) this;
        }

        public Criteria andProductlistDetailsNotEqualTo(String value) {
            addCriterion("productlist_details <>", value, "productlistDetails");
            return (Criteria) this;
        }

        public Criteria andProductlistDetailsGreaterThan(String value) {
            addCriterion("productlist_details >", value, "productlistDetails");
            return (Criteria) this;
        }

        public Criteria andProductlistDetailsGreaterThanOrEqualTo(String value) {
            addCriterion("productlist_details >=", value, "productlistDetails");
            return (Criteria) this;
        }

        public Criteria andProductlistDetailsLessThan(String value) {
            addCriterion("productlist_details <", value, "productlistDetails");
            return (Criteria) this;
        }

        public Criteria andProductlistDetailsLessThanOrEqualTo(String value) {
            addCriterion("productlist_details <=", value, "productlistDetails");
            return (Criteria) this;
        }

        public Criteria andProductlistDetailsLike(String value) {
            addCriterion("productlist_details like", value, "productlistDetails");
            return (Criteria) this;
        }

        public Criteria andProductlistDetailsNotLike(String value) {
            addCriterion("productlist_details not like", value, "productlistDetails");
            return (Criteria) this;
        }

        public Criteria andProductlistDetailsIn(List<String> values) {
            addCriterion("productlist_details in", values, "productlistDetails");
            return (Criteria) this;
        }

        public Criteria andProductlistDetailsNotIn(List<String> values) {
            addCriterion("productlist_details not in", values, "productlistDetails");
            return (Criteria) this;
        }

        public Criteria andProductlistDetailsBetween(String value1, String value2) {
            addCriterion("productlist_details between", value1, value2, "productlistDetails");
            return (Criteria) this;
        }

        public Criteria andProductlistDetailsNotBetween(String value1, String value2) {
            addCriterion("productlist_details not between", value1, value2, "productlistDetails");
            return (Criteria) this;
        }

        public Criteria andProductlistRepIsNull() {
            addCriterion("productlist_rep is null");
            return (Criteria) this;
        }

        public Criteria andProductlistRepIsNotNull() {
            addCriterion("productlist_rep is not null");
            return (Criteria) this;
        }

        public Criteria andProductlistRepEqualTo(String value) {
            addCriterion("productlist_rep =", value, "productlistRep");
            return (Criteria) this;
        }

        public Criteria andProductlistRepNotEqualTo(String value) {
            addCriterion("productlist_rep <>", value, "productlistRep");
            return (Criteria) this;
        }

        public Criteria andProductlistRepGreaterThan(String value) {
            addCriterion("productlist_rep >", value, "productlistRep");
            return (Criteria) this;
        }

        public Criteria andProductlistRepGreaterThanOrEqualTo(String value) {
            addCriterion("productlist_rep >=", value, "productlistRep");
            return (Criteria) this;
        }

        public Criteria andProductlistRepLessThan(String value) {
            addCriterion("productlist_rep <", value, "productlistRep");
            return (Criteria) this;
        }

        public Criteria andProductlistRepLessThanOrEqualTo(String value) {
            addCriterion("productlist_rep <=", value, "productlistRep");
            return (Criteria) this;
        }

        public Criteria andProductlistRepLike(String value) {
            addCriterion("productlist_rep like", value, "productlistRep");
            return (Criteria) this;
        }

        public Criteria andProductlistRepNotLike(String value) {
            addCriterion("productlist_rep not like", value, "productlistRep");
            return (Criteria) this;
        }

        public Criteria andProductlistRepIn(List<String> values) {
            addCriterion("productlist_rep in", values, "productlistRep");
            return (Criteria) this;
        }

        public Criteria andProductlistRepNotIn(List<String> values) {
            addCriterion("productlist_rep not in", values, "productlistRep");
            return (Criteria) this;
        }

        public Criteria andProductlistRepBetween(String value1, String value2) {
            addCriterion("productlist_rep between", value1, value2, "productlistRep");
            return (Criteria) this;
        }

        public Criteria andProductlistRepNotBetween(String value1, String value2) {
            addCriterion("productlist_rep not between", value1, value2, "productlistRep");
            return (Criteria) this;
        }

        public Criteria andProductlistHotIsNull() {
            addCriterion("productlist_hot is null");
            return (Criteria) this;
        }

        public Criteria andProductlistHotIsNotNull() {
            addCriterion("productlist_hot is not null");
            return (Criteria) this;
        }

        public Criteria andProductlistHotEqualTo(String value) {
            addCriterion("productlist_hot =", value, "productlistHot");
            return (Criteria) this;
        }

        public Criteria andProductlistHotNotEqualTo(String value) {
            addCriterion("productlist_hot <>", value, "productlistHot");
            return (Criteria) this;
        }

        public Criteria andProductlistHotGreaterThan(String value) {
            addCriterion("productlist_hot >", value, "productlistHot");
            return (Criteria) this;
        }

        public Criteria andProductlistHotGreaterThanOrEqualTo(String value) {
            addCriterion("productlist_hot >=", value, "productlistHot");
            return (Criteria) this;
        }

        public Criteria andProductlistHotLessThan(String value) {
            addCriterion("productlist_hot <", value, "productlistHot");
            return (Criteria) this;
        }

        public Criteria andProductlistHotLessThanOrEqualTo(String value) {
            addCriterion("productlist_hot <=", value, "productlistHot");
            return (Criteria) this;
        }

        public Criteria andProductlistHotLike(String value) {
            addCriterion("productlist_hot like", value, "productlistHot");
            return (Criteria) this;
        }

        public Criteria andProductlistHotNotLike(String value) {
            addCriterion("productlist_hot not like", value, "productlistHot");
            return (Criteria) this;
        }

        public Criteria andProductlistHotIn(List<String> values) {
            addCriterion("productlist_hot in", values, "productlistHot");
            return (Criteria) this;
        }

        public Criteria andProductlistHotNotIn(List<String> values) {
            addCriterion("productlist_hot not in", values, "productlistHot");
            return (Criteria) this;
        }

        public Criteria andProductlistHotBetween(String value1, String value2) {
            addCriterion("productlist_hot between", value1, value2, "productlistHot");
            return (Criteria) this;
        }

        public Criteria andProductlistHotNotBetween(String value1, String value2) {
            addCriterion("productlist_hot not between", value1, value2, "productlistHot");
            return (Criteria) this;
        }

        public Criteria andProductlistPictureIsNull() {
            addCriterion("productlist_picture is null");
            return (Criteria) this;
        }

        public Criteria andProductlistPictureIsNotNull() {
            addCriterion("productlist_picture is not null");
            return (Criteria) this;
        }

        public Criteria andProductlistPictureEqualTo(String value) {
            addCriterion("productlist_picture =", value, "productlistPicture");
            return (Criteria) this;
        }

        public Criteria andProductlistPictureNotEqualTo(String value) {
            addCriterion("productlist_picture <>", value, "productlistPicture");
            return (Criteria) this;
        }

        public Criteria andProductlistPictureGreaterThan(String value) {
            addCriterion("productlist_picture >", value, "productlistPicture");
            return (Criteria) this;
        }

        public Criteria andProductlistPictureGreaterThanOrEqualTo(String value) {
            addCriterion("productlist_picture >=", value, "productlistPicture");
            return (Criteria) this;
        }

        public Criteria andProductlistPictureLessThan(String value) {
            addCriterion("productlist_picture <", value, "productlistPicture");
            return (Criteria) this;
        }

        public Criteria andProductlistPictureLessThanOrEqualTo(String value) {
            addCriterion("productlist_picture <=", value, "productlistPicture");
            return (Criteria) this;
        }

        public Criteria andProductlistPictureLike(String value) {
            addCriterion("productlist_picture like", value, "productlistPicture");
            return (Criteria) this;
        }

        public Criteria andProductlistPictureNotLike(String value) {
            addCriterion("productlist_picture not like", value, "productlistPicture");
            return (Criteria) this;
        }

        public Criteria andProductlistPictureIn(List<String> values) {
            addCriterion("productlist_picture in", values, "productlistPicture");
            return (Criteria) this;
        }

        public Criteria andProductlistPictureNotIn(List<String> values) {
            addCriterion("productlist_picture not in", values, "productlistPicture");
            return (Criteria) this;
        }

        public Criteria andProductlistPictureBetween(String value1, String value2) {
            addCriterion("productlist_picture between", value1, value2, "productlistPicture");
            return (Criteria) this;
        }

        public Criteria andProductlistPictureNotBetween(String value1, String value2) {
            addCriterion("productlist_picture not between", value1, value2, "productlistPicture");
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