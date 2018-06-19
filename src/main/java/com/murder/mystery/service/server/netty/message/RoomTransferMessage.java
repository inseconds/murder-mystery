package com.murder.mystery.service.server.netty.message;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by yuehui on 2018/6/8
 */
@Getter
@Setter
public class RoomTransferMessage implements Serializable {

    private Integer roomId;

    private Integer charactorId;

    private Integer dramaId;

    private Integer uid;

    private String commond;
}
