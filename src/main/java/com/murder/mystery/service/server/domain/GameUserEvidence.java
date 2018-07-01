package com.murder.mystery.service.server.domain;

import java.io.Serializable;

public class GameUserEvidence implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer characterEvidenceId;

    private Integer status;

    private Integer checkedUserId;

    private Integer isOpen;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCharacterEvidenceId() {
        return characterEvidenceId;
    }

    public void setCharacterEvidenceId(Integer characterEvidenceId) {
        this.characterEvidenceId = characterEvidenceId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCheckedUserId() {
        return checkedUserId;
    }

    public void setCheckedUserId(Integer checkedUserId) {
        this.checkedUserId = checkedUserId;
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }
}