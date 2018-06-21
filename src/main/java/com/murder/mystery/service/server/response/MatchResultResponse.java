package com.murder.mystery.service.server.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by yuehui on 2018/6/10
 */
@Getter
@Setter
public class MatchResultResponse implements Serializable{

    private Integer uid1;

    private Integer uid2;

}
