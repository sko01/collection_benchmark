package ua.sko01.tests.queue;

import java.util.Queue;

/**
 * Created by Serhiy_Kovalenko on 3/30/2016.
 */
public interface QueueTest {
    void executeAddElements(Queue<Integer> queue);
    void executeGetElements(Queue<Integer> queue, int elemCount);
    void executeRemoveElements(Queue<Integer> queue, int elemCount);
}
