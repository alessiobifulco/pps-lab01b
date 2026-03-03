package it.unibo.pps.e2;

public interface Knight {
    boolean canMoveTo(Pair<Integer, Integer> position);

    void moveTo(Pair<Integer, Integer> position);

    Pair<Integer, Integer> getPosition();
}
