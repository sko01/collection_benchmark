package ua.sko01.tests.list;

import ua.sko01.tests.Position;

import java.util.List;

/**
 * Created by Serhiy_Kovalenko on 3/14/2016.
 */
public interface ListTest {
    void executeAddElements(List<Integer> list);
    void executeInsertElements(List<Integer> list, Position pos, int elemCount);
    void executeGetElementsConsequently(List<Integer> list, Position pos, int elemCount);
    void executeGetElementsRandomly(List<Integer> list, int elemCount);
    void executeRemoveElements(List<Integer> list, Position pos, int elemCount);
}
