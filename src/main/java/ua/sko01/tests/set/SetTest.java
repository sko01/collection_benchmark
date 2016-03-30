package ua.sko01.tests.set;

import ua.sko01.tests.Position;

import java.util.Set;

/**
 * Created by Serhiy_Kovalenko on 3/14/2016.
 */
public interface SetTest {
    void executeAddElements(Set<Integer> set);
    void executeGetElementsConsequently(Set<Integer> set, Position pos, int elemCount);
    void executeGetElementsRandomly(Set<Integer> set, int elemCount);
    void executeRemoveElements(Set<Integer> set, Position pos, int elemCount);
}
