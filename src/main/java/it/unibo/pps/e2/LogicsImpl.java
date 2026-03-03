package it.unibo.pps.e2;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Pair<Integer,Integer> pawn;
	private final Knight knight;
    private final Board board;

    public LogicsImpl(int size){
        this.board = new BoardImpl(size);
        this.pawn = this.randomEmptyPosition();
        this.knight = new KnightImpl(this.randomEmptyPosition());
    }

    public LogicsImpl(int size, Pair<Integer, Integer> posKnight, Pair<Integer, Integer> posPawn) {
        this.board = new BoardImpl(size);
        this.knight = new KnightImpl(posKnight);
        this.pawn = posPawn;

    }
    
	private final Pair<Integer,Integer> randomEmptyPosition(){
        Pair<Integer,Integer> position = this.board.getRandomPosition();
    	// the recursive call below prevents clash with an existing pawn
        return this.pawn != null && this.pawn.equals(position) ? randomEmptyPosition() : position;}
    
	@Override
	public boolean hit(int row, int col) {
        Pair<Integer, Integer> position = new Pair<>(row, col);
        if (!this.board.isInBoard(position)) {
            throw new IndexOutOfBoundsException();
        }
        if (this.knight.canMoveTo(position)) {
            this.knight.moveTo(position);
            return this.pawn.equals(this.knight.getPosition());
        }
        return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.getPosition().equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.equals(new Pair<>(row,col));
	}
}
