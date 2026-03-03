package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;
    private final static int SIZE = 5;

    @BeforeEach
    public void init(){
        this.board= new BoardImpl(SIZE);
    }

    @Test
    public void testPositionIsInBoard(){
        Pair<Integer, Integer> positon = new Pair<>(1,1);
        assertTrue(this.board.isInBoard(positon));
    }

    @Test
    public void testPositionIsNotInBoard(){
        Pair<Integer, Integer> positon = new Pair<>(10,10);
        assertFalse(this.board.isInBoard(positon));
    }

    @Test
    public void testRandomPositionIsInsideBoard(){
        Pair<Integer, Integer> randomPos = this.board.getRandomPosition();
        assertTrue(this.board.isInBoard(randomPos));
    }
}
