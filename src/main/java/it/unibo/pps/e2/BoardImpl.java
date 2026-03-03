package it.unibo.pps.e2;

import java.util.Random;

public class BoardImpl implements Board {

    private final int size;
    private final Random random = new Random();

    public BoardImpl(int size) {
        this.size = size;
    }

    @Override
    public boolean isInBoard(Pair<Integer, Integer> position) {
        return (position.getX() >= 0 && position.getX() < size)
                && (position.getY() >= 0 && position.getY() < size);
    }

    @Override
    public Pair<Integer, Integer> getRandomPosition() {
        return new Pair<>(this.random.nextInt(size), this.random.nextInt(size));
    }
}
