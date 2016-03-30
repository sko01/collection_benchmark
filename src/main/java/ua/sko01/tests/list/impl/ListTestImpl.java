package ua.sko01.tests.list.impl;

import ua.sko01.tests.Position;
import ua.sko01.tests.list.ListTest;

import java.util.List;
import java.util.Random;

public class ListTestImpl implements ListTest {
    private Integer SIZE;

    public void setSIZE(String SIZE) {
        this.SIZE = Integer.parseInt(SIZE);
    }

    public void executeAddElements(List<Integer> list) {
        for(int i = 0; i < SIZE; i++){
            list.add(i);
        }
    }

    public void executeInsertElements(List<Integer> list, Position pos, int elemCount) {
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
            list.add(startPos, i);
            startPos++;
        }
    }

    public void executeGetElementsConsequently(List<Integer> list, Position pos, int elemCount) {
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
            list.get(startPos);
            startPos++;
        }
    }

    public void executeGetElementsRandomly(List<Integer> list, int elemCount) {
        Random rand = new Random();
        for(int i = 0; i < elemCount; i++) {
            int pos = rand.nextInt(SIZE);
            list.get(pos);
        }
    }

    public void executeRemoveElements(List<Integer> list, Position pos, int elemCount) {
        if(SIZE > elemCount) {
            int startPos = 0;
            switch (pos) {
                case HEAD:
                    startPos = elemCount - 1;
                    break;
                case MID:
                    startPos = SIZE / 2 - 1;
                    if(elemCount > startPos){
                        startPos = elemCount - 1;
                    }
                    break;
                case END:
                    startPos = SIZE - 1;
                    break;
            }
            for (int i = 0; i < elemCount; i++) {
                list.remove(startPos);
                startPos--;
            }
        }
        else{
            list.clear();
        }
    }
}
