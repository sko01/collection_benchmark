package ua.sko01.tests.map;

import ua.sko01.tests.Position;

import java.util.Map;

public interface MapTest {
    void executeAddElements(Map<Integer, Integer> map);
    void executeGetElementsConsequently(Map<Integer, Integer> map, Position pos, int elemCount);
    void executeGetElementsRandomly(Map<Integer, Integer> map, int elemCount);
    void executeRemoveElements(Map<Integer, Integer> map, Position pos, int elemCount);
}
