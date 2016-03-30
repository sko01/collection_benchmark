package ua.sko01.helper;

import java.util.*;

public class BenchmarkRunner {
    private ListBenchmarkRunner listBenchmarkRunner;
    private SetBenchmarkRunner setBenchmarkRunner;
    private MapBenchmarkRunner mapBenchmarkRunner;
    private QueueBenchmarkRunner queueBenchmarkRunner;
    private int iterations;

    public void setListBenchmarkRunner(ListBenchmarkRunner listBenchmarkRunner) {
        this.listBenchmarkRunner = listBenchmarkRunner;
    }

    public void setSetBenchmarkRunner(SetBenchmarkRunner setBenchmarkRunner) {
        this.setBenchmarkRunner = setBenchmarkRunner;
    }

    public void setMapBenchmarkRunner(MapBenchmarkRunner mapBenchmarkRunner) {
        this.mapBenchmarkRunner = mapBenchmarkRunner;
    }

    public void setQueueBenchmarkRunner(QueueBenchmarkRunner queueBenchmarkRunner) {
        this.queueBenchmarkRunner = queueBenchmarkRunner;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public Map runTests(){
        Map<String, Map<String, Long>> testOperationsResults = new LinkedHashMap<String, Map<String, Long>>();
        Vector<Integer> vector = new Vector<Integer>();
        Queue<Integer> queue = new PriorityQueue<Integer>();
        List<Integer> linkedList = new LinkedList<Integer>();
        List<Integer> arrayList = new ArrayList<Integer>();
        Set<Integer> hashSet = new HashSet<Integer>();
        Set<Integer> treeSet = new TreeSet<Integer>();
        Set<Integer> linkedHashSet = new LinkedHashSet<Integer>();
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>();
        testOperationsResults.put("Vector", listBenchmarkRunner.performTests(vector, iterations));
        testOperationsResults.put("ArrayList", listBenchmarkRunner.performTests(arrayList, iterations));
        testOperationsResults.put("LinkedList", listBenchmarkRunner.performTests(linkedList, iterations));
        testOperationsResults.put("HashSet", setBenchmarkRunner.performTests(hashSet, iterations));
        testOperationsResults.put("LinkedHashSet", setBenchmarkRunner.performTests(linkedHashSet, iterations));
        testOperationsResults.put("TreeSet", setBenchmarkRunner.performTests(treeSet, iterations));
        testOperationsResults.put("HashMap", mapBenchmarkRunner.performTests(hashMap, iterations));
        testOperationsResults.put("LinkedHashMap", mapBenchmarkRunner.performTests(linkedHashMap, iterations));
        testOperationsResults.put("Queue", queueBenchmarkRunner.performTests(queue, iterations));
        return testOperationsResults;
    }
}
