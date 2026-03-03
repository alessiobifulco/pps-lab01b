package it.unibo.pps.e2;

public class KnightImpl implements Knight {

    private Pair<Integer, Integer> position;

    public KnightImpl(Pair<Integer, Integer> position) {
        this.position = position;
    }

    @Override
    public boolean canMoveTo(Pair<Integer, Integer> position) {
        return isValidPosition(position) && isKnightMove(position);
    }

    @Override
    public void moveTo(Pair<Integer, Integer> position) {
        if (canMoveTo(position)){
            this.position = position;
        }
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

    private boolean isValidPosition(Pair<Integer, Integer> position) {
        return position.getX() >= 0 && position.getY() >= 0;
    }

    private boolean isKnightMove(Pair<Integer, Integer> position) {
        int dx = Math.abs(position.getX() - this.position.getX());
        int dy = Math.abs(position.getY() - this.position.getY());
        return (dx + dy == 3) && (dx != 0) && (dy != 0);
    }

}
