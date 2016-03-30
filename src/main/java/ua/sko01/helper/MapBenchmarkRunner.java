package ua.sko01.helper;

import ua.sko01.tests.Position;
import ua.sko01.tests.map.MapTest;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapBenchmarkRunner {
    private MapTest mapTest;
    private Map<String, Map<String, Long>> testOperationsResults = new HashMap<String, Map<String, Long>>();

    public void setMapTest(MapTest mapTest) {
        this.mapTest = mapTest;
    }

    public Map<String, Long> performTests(Map<Integer, Integer> map, int elemCount){
        Map<String, Long> results = new LinkedHashMap<String, Long>();
        Long start = System.nanoTime();
        mapTest.executeAddElements(map);
        Long stop = System.nanoTime();
        results.put("Add", (stop - start));

        start = System.nanoTime();
        mapTest.executeGetElementsConsequently(map, Position.HEAD, elemCount);
        stop = System.nanoTime();
        results.put("Get Cons " + Position.HEAD, (stop - start));

        start = System.nanoTime();
        mapTest.executeGetElementsConsequently(map, Position.MID, elemCount);
        stop = System.nanoTime();
        results.put("Get Cons " + Position.MID, (stop - start));

        start = System.nanoTime();
        mapTest.executeGetElementsConsequently(map, Position.END, elemCount);
        stop = System.nanoTime();
        results.put("Get Cons " + Position.END, (stop - start));

        start = System.nanoTime();
        mapTest.executeGetElementsConsequently(map, Position.END, elemCount);
        stop = System.nanoTime();
        results.put("Get Cons " + Position.END, (stop - start));

        start = System.nanoTime();
        mapTest.executeGetElementsRandomly(map, elemCount);
        stop = System.nanoTime();
        results.put("Get Randomly", (stop - start));

        start = System.nanoTime();
        mapTest.executeRemoveElements(map, Position.HEAD, elemCount);
        stop = System.nanoTime();
        results.put("Remove " + Position.HEAD, (stop - start));
        map = restoreList(map);

        start = System.nanoTime();
        mapTest.executeRemoveElements(map, Position.MID, elemCount);
        stop = System.nanoTime();
        results.put("Remove " + Position.MID, (stop - start));
        map = restoreList(map);

        start = System.nanoTime();
        mapTest.executeRemoveElements(map, Position.END, elemCount);
        stop = System.nanoTime();
        results.put("Remove " + Position.END, (stop - start));
        map = restoreList(map);

        results.put("Memory consumption", mapMemoryConsumption(map));

        return results;
    }

    private Map<Integer, Integer> restoreList(Map<Integer, Integer> map){
        map.clear();
        mapTest.executeAddElements(map);
        return map;
    }

    private Long mapMemoryConsumption(Map<Integer, Integer> map){
        map.clear();
        long memoryBeforeInit = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        mapTest.executeAddElements(map);
        long memoryAfterInit = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        return memoryAfterInit - memoryBeforeInit;
    }
}
