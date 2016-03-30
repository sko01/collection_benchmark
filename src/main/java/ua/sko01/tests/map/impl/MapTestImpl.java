package ua.sko01.tests.map.impl;

import ua.sko01.tests.Position;
import ua.sko01.tests.map.MapTest;

import java.util.Map;
import java.util.Random;

public class MapTestImpl implements MapTest {
    private Integer SIZE;

    public void setSIZE(Integer SIZE) {
        this.SIZE = SIZE;
    }

    public void executeAddElements(Map<Integer, Integer> map) {
        for(int i = 0; i < SIZE; i++){
            map.put(i, i);
        }
    }

    public void executeGetElementsConsequently(Map<Integer, Integer> map, Position pos, int elemCount) {
        int startPos = 0;
        switch (pos){
            case HEAD:
                startPos = 0;
                break;
            case MID:
                startPos = SIZE / 2;
                break;
            case END:
                startPos = SIZE - elemCount;
                break;
        }
        for(int i = 0; i < elemCount; i++){
            map.get(startPos);
            startPos++;
        }
    }

    public void executeGetElementsRandomly(Map<Integer, Integer> map, int elemCount) {
        Random rand = new Random();
        for(int i = 0; i < SIZE; i++){
            map.get(rand.nextInt(SIZE));
        }
    }

    public void executeRemoveElements(Map<Integer, Integer> map, Position pos, int elemCount) {
        int startPos = 0;
        switch (pos){
            case HEAD:
                startPos = 0;
                break;
            case MID:
                startPos = SIZE / 2;
                break;
            case END:
                startPos = SIZE - elemCount;
                break;
        }
        for(int i = 0; i < elemCount; i++){
            map.remove(startPos);
            startPos++;
        }
    }
}
