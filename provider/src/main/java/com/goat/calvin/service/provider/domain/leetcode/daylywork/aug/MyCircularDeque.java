package com.goat.calvin.service.provider.domain.leetcode.daylywork.aug;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：xiefeiyf
 * @date：2022/8/15 : 9:16
 */
public class MyCircularDeque {

    int maxSize;
    List<Integer> list;

    public MyCircularDeque(int k) {
        maxSize = k;
        list = new ArrayList<>(k);
    }

    public boolean insertFront(int value) {
        if (list.size() == maxSize) return false;
        list.add(0, value);
        return true;
    }

    public boolean insertLast(int value) {
        if (list.size() == maxSize) return false;
        list.add(value);
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        list.remove(0);
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        list.remove(list.size() - 1);
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return list.get(0);
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        if (list == null || list.size() == 0) return true;
        return false;
    }

    public boolean isFull() {
        if (isEmpty()) return false;
        if (list.size() == maxSize) return true;
        else return false;
    }

}
