package com.murder.mystery.service.server.domain;

import java.io.Serializable;

public class Drama implements Serializable {
    private Integer id;

    private String name;

    private Integer type;

    private String description;

    private Integer score;

    private Integer playerNumber;

    private String headImg;

    private Integer palyCount;

    private Integer difficultyDegree;

    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(Integer playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    public Integer getPalyCount() {
        return palyCount;
    }

    public void setPalyCount(Integer palyCount) {
        this.palyCount = palyCount;
    }

    public Integer getDifficultyDegree() {
        return difficultyDegree;
    }

    public void setDifficultyDegree(Integer difficultyDegree) {
        this.difficultyDegree = difficultyDegree;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}