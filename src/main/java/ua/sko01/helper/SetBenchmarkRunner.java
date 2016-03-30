package ua.sko01.helper;

import ua.sko01.tests.Position;
import ua.sko01.tests.set.SetTest;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Serhiy_Kovalenko on 3/30/2016.
 */
public class SetBenchmarkRunner{
    SetTest setTest;

    public void setSetTest(SetTest setTest) {
        this.setTest = setTest;
    }

    public Map<String, Long> performTests(Set<Integer> set, int elemCount){
        Map<String, Long> results = new LinkedHashMap<String, Long>();
        Long start = System.nanoTime();
        setTest.executeAddElements(set);
        Long stop = System.nanoTime();
        results.put("Add", (stop - start));

        start = System.nanoTime();
        setTest.executeGetElementsConsequently(set, Position.HEAD, elemCount);
        stop = System.nanoTime();
        results.put("Get Cons " + Position.HEAD, (stop - start));

        start = System.nanoTime();
        setTest.executeGetElementsConsequently(set, Position.MID, elemCount);
        stop = System.nanoTime();
        results.put("Get Cons " + Position.MID, (stop - start));

        start = System.nanoTime();
        setTest.executeGetElementsConsequently(set, Position.END, elemCount);
        stop = System.nanoTime();
        results.put("Get Cons " + Position.END, (stop - start));

        start = System.nanoTime();
        setTest.executeGetElementsConsequently(set, Position.END, elemCount);
        stop = System.nanoTime();
        results.put("Get Cons " + Position.END, (stop - start));

        start = System.nanoTime();
        setTest.executeGetElementsRandomly(set, elemCount);
        stop = System.nanoTime();
        results.put("Get Randomly", (stop - start));

        start = System.nanoTime();
        setTest.executeRemoveElements(set, Position.HEAD, elemCount);
        stop = System.nanoTime();
        results.put("Remove " + Position.HEAD, (stop - start));
        set = restoreSet(set);

        start = System.nanoTime();
        setTest.executeRemoveElements(set, Position.MID, elemCount);
        stop = System.nanoTime();
        results.put("Remove " + Position.MID, (stop - start));
        set = restoreSet(set);

        start = System.nanoTime();
        setTest.executeRemoveElements(set, Position.END, elemCount);
        stop = System.nanoTime();
        results.put("Remove " + Position.END, (stop - start));
        set = restoreSet(set);

        results.put("Memory consumption", setMemoryConsumption(set));

        return results;
    }

    private Set<Integer> restoreSet(Set<Integer> set){
        set.clear();
        setTest.executeAddElements(set);
        return set;
    }

    private Long setMemoryConsumption(Set<Integer> set){
        set.clear();
        long memoryBeforeInit = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        setTest.executeAddElements(set);
        long memoryAfterInit = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        return memoryAfterInit - memoryBeforeInit;
    }
}
