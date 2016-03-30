package ua.sko01.tests.set.impl;

import ua.sko01.tests.Position;
import ua.sko01.tests.set.SetTest;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SetTestImpl implements SetTest {
    private Integer SIZE;

    public void setSIZE(Integer SIZE) {
        this.SIZE = SIZE;
    }

    public void executeAddElements(Set<Integer> set) {
        for (int i = 0; i < SIZE; i++){
            set.add(i);
        }
    }

    public void executeGetElementsConsequently(Set<Integer> set, Position pos, int elemCount) {
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
            for(Integer val : set){
                if(startPos == val){
                    startPos++;
                    break;
                }
            }
        }
    }

    public void executeGetElementsRandomly(Set<Integer> set, int elemCount) {
        Random rand = new Random();
        for(int i = 0; i < elemCount; i++) {
            int pos = rand.nextInt(SIZE);
            for(Integer val : set){
                if(pos == val){
                    break;
                }
            }
        }
    }

    public void executeRemoveElements(Set<Integer> set, Position pos, int elemCount) {
        int startPos = 0;
        Set<Integer> itemsToRemove = new HashSet<Integer>();
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
            itemsToRemove.add(startPos);
            startPos++;
        }

        set.removeAll(itemsToRemove);
    }
}
