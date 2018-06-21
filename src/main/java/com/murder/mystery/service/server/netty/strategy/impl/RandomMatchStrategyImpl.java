package com.murder.mystery.service.server.netty.strategy.impl;

import com.murder.mystery.service.server.netty.session.Session;
import com.murder.mystery.service.server.netty.strategy.MatchStrategy;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by yuehui on 2018/6/10
 */
@Component
public class RandomMatchStrategyImpl implements MatchStrategy {

    private static Random random;

    public static Random getRandom() {
        if(random==null){
            synchronized (RandomUtils.class) {
                if(random==null){
                    random =new Random();
                }
            }
        }

        return random;
    }

    public static int getRandomInteger(int max){
        return Math.abs(getRandom().nextInt(max)) % max ;
    }

    @Override
    public Session getAvailableUser() {
        return null;
    }
}
