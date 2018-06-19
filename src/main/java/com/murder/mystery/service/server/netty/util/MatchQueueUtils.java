package com.murder.mystery.service.server.netty.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by yuehui on 2018/6/10
 */
public class MatchQueueUtils {

    private static final Set<Integer> matchSet = Sets.newConcurrentHashSet();

    public static boolean joinMatch(Integer uid){
        if (matchSet.contains(uid)){
            return false;
        } else {
            matchSet.add(uid);
            return true;
        }
    }

    public static List<Integer> getMatchResult(){
        synchronized (matchSet){
            if (matchSet.size() > 1) {
                Iterator<Integer> iterator = matchSet.iterator();
                List<Integer> result = Lists.newArrayList();
                do {
                    result.add(iterator.next());
                } while (result.size() == 2);
                return result;
            } else {
                return null;
            }
        }
    }
}
