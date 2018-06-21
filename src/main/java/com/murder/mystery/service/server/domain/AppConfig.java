package com.murder.mystery.service.server.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class AppConfig implements Serializable {

    private Long startDt;

    private Long endDt;

    private String unusableCue;

    private String unusableImgUrl;
}