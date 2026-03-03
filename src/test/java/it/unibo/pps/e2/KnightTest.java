package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTest {

    private Knight knight;
    private final static Pair<Integer, Integer> INITIAL_POSITION = new Pair<>(0,0);

    @BeforeEach
    public void init(){
        this.knight = new KnightImpl(INITIAL_POSITION);
    }

    @Test
    public void testCanMove(){
        Pair<Integer,Integer> position = new Pair<>(2,1);
        assertTrue(knight.canMoveTo(position));
    }

    @Test
    public void testCanNotMove(){
        Pair<Integer,Integer> position = new Pair<>(1,1);
        assertFalse(knight.canMoveTo(position));
    }

    @Test
    public void testMoveTo(){
        Pair<Integer,Integer> positionToMoveTo = new Pair<>(2,1);
        this.knight.moveTo(positionToMoveTo);
        assertEquals(positionToMoveTo, this.knight.getPosition());
    }

    @Test
    public void testDoesntMoveTo(){
        Pair<Integer,Integer> positionToNotMoveTo = new Pair<>(1,1);
        this.knight.moveTo(positionToNotMoveTo);
        assertEquals(INITIAL_POSITION, this.knight.getPosition());
    }


}
