package ua.sko01.helper;

import ua.sko01.tests.queue.QueueTest;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;

public class QueueBenchmarkRunner {
    private QueueTest queueTest;

    public void setQueueTest(QueueTest queueTest) {
        this.queueTest = queueTest;
    }

    public Map<String, Long> performTests(Queue<Integer> queue, int elemCount){
        Map<String, Long> results = new LinkedHashMap<String, Long>();

        Long start = System.nanoTime();
        queueTest.executeAddElements(queue);
        Long stop = System.nanoTime();
        results.put("Add", (stop - start));

        start = System.nanoTime();
        queueTest.executeGetElements(queue, elemCount);
        stop = System.nanoTime();
        results.put("Get Cons", (stop - start));

        start = System.nanoTime();
        queueTest.executeRemoveElements(queue, elemCount);
        stop = System.nanoTime();
        results.put("Remove", (stop - start));

        results.put("Memory consumption", queueMemoryConsumption(queue));

        return results;
    }

    private Long queueMemoryConsumption(Queue<Integer> queue){
        queue.clear();
        long memoryBeforeInit = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        queueTest.executeAddElements(queue);
        long memoryAfterInit = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        return memoryAfterInit - memoryBeforeInit;
    }
}
