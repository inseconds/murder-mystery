package com.murder.mystery.service.server.domain;

import java.io.Serializable;

public class GameUser implements Serializable {
    private Integer id;

    private Integer characterId;

    private Long userId;

    private Integer actionCount;

    private Integer voted;

    private Integer voteGameUserId;

    private Integer roomId;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getActionCount() {
        return actionCount;
    }

    public void setActionCount(Integer actionCount) {
        this.actionCount = actionCount;
    }

    public Integer getVoted() {
        return voted;
    }

    public void setVoted(Integer voted) {
        this.voted = voted;
    }

    public Integer getVoteGameUserId() {
        return voteGameUserId;
    }

    public void setVoteGameUserId(Integer voteGameUserId) {
        this.voteGameUserId = voteGameUserId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}