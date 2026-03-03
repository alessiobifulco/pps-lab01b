package it.unibo.pps.e2;

public interface Board {
    boolean isInBoard(Pair<Integer,Integer> position);
    Pair<Integer, Integer> getRandomPosition();
}
