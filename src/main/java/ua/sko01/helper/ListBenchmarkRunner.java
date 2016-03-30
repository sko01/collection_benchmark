package ua.sko01.helper;

import ua.sko01.tests.Position;
import ua.sko01.tests.list.ListTest;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ListBenchmarkRunner {
    private ListTest listTest;

    public void setListTest(ListTest listTest) {
        this.listTest = listTest;
    }

    public Map<String, Long> performTests(List<Integer> list, int elemCount){
        Map<String, Long> results = new LinkedHashMap<String, Long>();
        Long start = System.nanoTime();
        listTest.executeAddElements(list);
        Long stop = System.nanoTime();
        results.put("Add", (stop - start));

        start = System.nanoTime();
        listTest.executeGetElementsConsequently(list, Position.HEAD, elemCount);
        stop = System.nanoTime();
        results.put("Get Cons " + Position.HEAD, (stop - start));

        start = System.nanoTime();
        listTest.executeGetElementsConsequently(list, Position.MID, elemCount);
        stop = System.nanoTime();
        results.put("Get Cons " + Position.MID, (stop - start));

        start = System.nanoTime();
        listTest.executeGetElementsConsequently(list, Position.END, elemCount);
        stop = System.nanoTime();
        results.put("Get Cons " + Position.END, (stop - start));

        start = System.nanoTime();
        listTest.executeGetElementsConsequently(list, Position.END, elemCount);
        stop = System.nanoTime();
        results.put("Get Cons " + Position.END, (stop - start));

        start = System.nanoTime();
        listTest.executeGetElementsRandomly(list, elemCount);
        stop = System.nanoTime();
        results.put("Get Randomly", (stop - start));

        start = System.nanoTime();
        listTest.executeRemoveElements(list, Position.HEAD, elemCount);
        stop = System.nanoTime();
        results.put("Remove " + Position.HEAD, (stop - start));
        list = restoreList(list);

        start = System.nanoTime();
        listTest.executeRemoveElements(list, Position.MID, elemCount);
        stop = System.nanoTime();
        results.put("Remove " + Position.MID, (stop - start));
        list = restoreList(list);

        start = System.nanoTime();
        listTest.executeRemoveElements(list, Position.END, elemCount);
        stop = System.nanoTime();
        results.put("Remove " + Position.END, (stop - start));
        list = restoreList(list);

        start = System.nanoTime();
        listTest.executeInsertElements(list, Position.HEAD, elemCount);
        stop = System.nanoTime();
        results.put("Insert " + Position.HEAD, (stop - start));
        list = restoreList(list);

        start = System.nanoTime();
        listTest.executeInsertElements(list, Position.MID, elemCount);
        stop = System.nanoTime();
        results.put("Insert " + Position.MID, (stop - start));
        list = restoreList(list);

        start = System.nanoTime();
        listTest.executeInsertElements(list, Position.END, elemCount);
        stop = System.nanoTime();
        results.put("Insert " + Position.END, (stop - start));
        list = restoreList(list);

        results.put("Memory consumption", listMemoryConsumption(list));

        return results;
    }

    private List<Integer> restoreList(List<Integer> list){
        list.clear();
        listTest.executeAddElements(list);
        return list;
    }

    private Long listMemoryConsumption(List<Integer> list){
        list.clear();
        long memoryBeforeInit = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        listTest.executeAddElements(list);
        long memoryAfterInit = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        return memoryAfterInit - memoryBeforeInit;
    }
}
