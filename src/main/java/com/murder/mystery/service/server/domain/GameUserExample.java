package com.murder.mystery.service.server.domain;

import java.util.ArrayList;
import java.util.List;

public class GameUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GameUserExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCharacterIdIsNull() {
            addCriterion("character_id is null");
            return (Criteria) this;
        }

        public Criteria andCharacterIdIsNotNull() {
            addCriterion("character_id is not null");
            return (Criteria) this;
        }

        public Criteria andCharacterIdEqualTo(Integer value) {
            addCriterion("character_id =", value, "characterId");
            return (Criteria) this;
        }

        public Criteria andCharacterIdNotEqualTo(Integer value) {
            addCriterion("character_id <>", value, "characterId");
            return (Criteria) this;
        }

        public Criteria andCharacterIdGreaterThan(Integer value) {
            addCriterion("character_id >", value, "characterId");
            return (Criteria) this;
        }

        public Criteria andCharacterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("character_id >=", value, "characterId");
            return (Criteria) this;
        }

        public Criteria andCharacterIdLessThan(Integer value) {
            addCriterion("character_id <", value, "characterId");
            return (Criteria) this;
        }

        public Criteria andCharacterIdLessThanOrEqualTo(Integer value) {
            addCriterion("character_id <=", value, "characterId");
            return (Criteria) this;
        }

        public Criteria andCharacterIdIn(List<Integer> values) {
            addCriterion("character_id in", values, "characterId");
            return (Criteria) this;
        }

        public Criteria andCharacterIdNotIn(List<Integer> values) {
            addCriterion("character_id not in", values, "characterId");
            return (Criteria) this;
        }

        public Criteria andCharacterIdBetween(Integer value1, Integer value2) {
            addCriterion("character_id between", value1, value2, "characterId");
            return (Criteria) this;
        }

        public Criteria andCharacterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("character_id not between", value1, value2, "characterId");
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

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andActionCountIsNull() {
            addCriterion("action_count is null");
            return (Criteria) this;
        }

        public Criteria andActionCountIsNotNull() {
            addCriterion("action_count is not null");
            return (Criteria) this;
        }

        public Criteria andActionCountEqualTo(Integer value) {
            addCriterion("action_count =", value, "actionCount");
            return (Criteria) this;
        }

        public Criteria andActionCountNotEqualTo(Integer value) {
            addCriterion("action_count <>", value, "actionCount");
            return (Criteria) this;
        }

        public Criteria andActionCountGreaterThan(Integer value) {
            addCriterion("action_count >", value, "actionCount");
            return (Criteria) this;
        }

        public Criteria andActionCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("action_count >=", value, "actionCount");
            return (Criteria) this;
        }

        public Criteria andActionCountLessThan(Integer value) {
            addCriterion("action_count <", value, "actionCount");
            return (Criteria) this;
        }

        public Criteria andActionCountLessThanOrEqualTo(Integer value) {
            addCriterion("action_count <=", value, "actionCount");
            return (Criteria) this;
        }

        public Criteria andActionCountIn(List<Integer> values) {
            addCriterion("action_count in", values, "actionCount");
            return (Criteria) this;
        }

        public Criteria andActionCountNotIn(List<Integer> values) {
            addCriterion("action_count not in", values, "actionCount");
            return (Criteria) this;
        }

        public Criteria andActionCountBetween(Integer value1, Integer value2) {
            addCriterion("action_count between", value1, value2, "actionCount");
            return (Criteria) this;
        }

        public Criteria andActionCountNotBetween(Integer value1, Integer value2) {
            addCriterion("action_count not between", value1, value2, "actionCount");
            return (Criteria) this;
        }

        public Criteria andVotedIsNull() {
            addCriterion("voted is null");
            return (Criteria) this;
        }

        public Criteria andVotedIsNotNull() {
            addCriterion("voted is not null");
            return (Criteria) this;
        }

        public Criteria andVotedEqualTo(Integer value) {
            addCriterion("voted =", value, "voted");
            return (Criteria) this;
        }

        public Criteria andVotedNotEqualTo(Integer value) {
            addCriterion("voted <>", value, "voted");
            return (Criteria) this;
        }

        public Criteria andVotedGreaterThan(Integer value) {
            addCriterion("voted >", value, "voted");
            return (Criteria) this;
        }

        public Criteria andVotedGreaterThanOrEqualTo(Integer value) {
            addCriterion("voted >=", value, "voted");
            return (Criteria) this;
        }

        public Criteria andVotedLessThan(Integer value) {
            addCriterion("voted <", value, "voted");
            return (Criteria) this;
        }

        public Criteria andVotedLessThanOrEqualTo(Integer value) {
            addCriterion("voted <=", value, "voted");
            return (Criteria) this;
        }

        public Criteria andVotedIn(List<Integer> values) {
            addCriterion("voted in", values, "voted");
            return (Criteria) this;
        }

        public Criteria andVotedNotIn(List<Integer> values) {
            addCriterion("voted not in", values, "voted");
            return (Criteria) this;
        }

        public Criteria andVotedBetween(Integer value1, Integer value2) {
            addCriterion("voted between", value1, value2, "voted");
            return (Criteria) this;
        }

        public Criteria andVotedNotBetween(Integer value1, Integer value2) {
            addCriterion("voted not between", value1, value2, "voted");
            return (Criteria) this;
        }

        public Criteria andVoteGameUserIdIsNull() {
            addCriterion("vote_game_user_id is null");
            return (Criteria) this;
        }

        public Criteria andVoteGameUserIdIsNotNull() {
            addCriterion("vote_game_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andVoteGameUserIdEqualTo(Integer value) {
            addCriterion("vote_game_user_id =", value, "voteGameUserId");
            return (Criteria) this;
        }

        public Criteria andVoteGameUserIdNotEqualTo(Integer value) {
            addCriterion("vote_game_user_id <>", value, "voteGameUserId");
            return (Criteria) this;
        }

        public Criteria andVoteGameUserIdGreaterThan(Integer value) {
            addCriterion("vote_game_user_id >", value, "voteGameUserId");
            return (Criteria) this;
        }

        public Criteria andVoteGameUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("vote_game_user_id >=", value, "voteGameUserId");
            return (Criteria) this;
        }

        public Criteria andVoteGameUserIdLessThan(Integer value) {
            addCriterion("vote_game_user_id <", value, "voteGameUserId");
            return (Criteria) this;
        }

        public Criteria andVoteGameUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("vote_game_user_id <=", value, "voteGameUserId");
            return (Criteria) this;
        }

        public Criteria andVoteGameUserIdIn(List<Integer> values) {
            addCriterion("vote_game_user_id in", values, "voteGameUserId");
            return (Criteria) this;
        }

        public Criteria andVoteGameUserIdNotIn(List<Integer> values) {
            addCriterion("vote_game_user_id not in", values, "voteGameUserId");
            return (Criteria) this;
        }

        public Criteria andVoteGameUserIdBetween(Integer value1, Integer value2) {
            addCriterion("vote_game_user_id between", value1, value2, "voteGameUserId");
            return (Criteria) this;
        }

        public Criteria andVoteGameUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("vote_game_user_id not between", value1, value2, "voteGameUserId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNull() {
            addCriterion("room_id is null");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNotNull() {
            addCriterion("room_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomIdEqualTo(Integer value) {
            addCriterion("room_id =", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotEqualTo(Integer value) {
            addCriterion("room_id <>", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThan(Integer value) {
            addCriterion("room_id >", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("room_id >=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThan(Integer value) {
            addCriterion("room_id <", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThanOrEqualTo(Integer value) {
            addCriterion("room_id <=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIn(List<Integer> values) {
            addCriterion("room_id in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotIn(List<Integer> values) {
            addCriterion("room_id not in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdBetween(Integer value1, Integer value2) {
            addCriterion("room_id between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotBetween(Integer value1, Integer value2) {
            addCriterion("room_id not between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("`status` not between", value1, value2, "status");
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