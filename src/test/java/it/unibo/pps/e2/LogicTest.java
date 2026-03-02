package it.unibo.pps.e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    private Logics logics;
    private Pair<Integer, Integer> posKnight;
    private Pair<Integer, Integer> posPawn;

    // TODO: Add your test logic here
    // You can generate random inputs and assert the expected output
    // For example:
    // int result = Logic.someMethod(5, 10);
    // assertEquals(expectedResult, result);

    @BeforeEach
    public void init(){
        int size = 5;
        this.posKnight = new Pair<>(0,0);
        this.posPawn = new Pair<>(1,2);
        this.logics = new LogicsImpl(size, posKnight, posPawn);
    }

    @Test
    public void testInitialPositionHasKnightAndPawn(){
        assertTrue(logics.hasKnight(posKnight.getX(), posKnight.getY()));
        assertTrue(logics.hasPawn(posPawn.getX(), posPawn.getY()));
    }

    @Test
    public void testInitialPositionHasNotKnightAndPawn(){
        assertFalse(logics.hasKnight(1, 1));
        assertFalse(logics.hasPawn(1, 1));
    }

    @Test
    public void testValidMoveWithoutHit(){
        boolean isHit = logics.hit(2, 1);
        assertFalse(isHit);
        assertTrue(logics.hasKnight(2, 1));
        assertFalse(logics.hasKnight(posKnight.getX(), posKnight.getY()));
    }

    @Test
    public void testInvalidMove(){
        boolean isHit = logics.hit(1, 1);
        assertFalse(isHit);
        assertTrue(logics.hasKnight(posKnight.getX(), posKnight.getY()));
    }

    @Test
    public void testValidMoveWithHit(){
        boolean isHit = logics.hit(posPawn.getX(), posPawn.getY());
        assertTrue(isHit);
        assertTrue(logics.hasKnight(posPawn.getX(), posPawn.getY()));
    }
}
