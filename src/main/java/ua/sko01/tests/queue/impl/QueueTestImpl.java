package ua.sko01.tests.queue.impl;

import ua.sko01.tests.queue.QueueTest;

import java.util.Queue;

/**
 * Created by Serhiy_Kovalenko on 3/30/2016.
 */
public class QueueTestImpl implements QueueTest {
    private Integer SIZE;

    public void setSIZE(Integer SIZE) {
        this.SIZE = SIZE;
    }

    public void executeAddElements(Queue<Integer> queue) {
        for(int i = 0; i < SIZE; i++) {
            queue.add(i);
        }
    }

    public void executeGetElements(Queue<Integer> queue, int elemCount) {
        for(int i = 0; i < elemCount; i++){
            queue.peek();
        }
    }

    public void executeRemoveElements(Queue<Integer> queue, int elemCount) {
        for(int i = 0; i < elemCount; i++){
            queue.poll();
        }
    }
}
