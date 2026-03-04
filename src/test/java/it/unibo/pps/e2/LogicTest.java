package it.unibo.pps.e2;
import org.junit.jupiter.api.*;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    private Logics logics;
    private Pair<Integer, Integer> posKnight;
    private Pair<Integer, Integer> posPawn;
    private final Random random = new Random();
    private static final int SIZE = 5;

    // TODO: Add your test logic here
    // You can generate random inputs and assert the expected output
    // For example:
    // int result = Logic.someMethod(5, 10);
    // assertEquals(expectedResult, result);

    @BeforeEach
    public void init(){
        this.posKnight = new Pair<>(0,0);
        this.posPawn = new Pair<>(1,2);
        this.logics = new LogicsImpl(SIZE, posKnight, posPawn);
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

    @Test
    public void testRandomKnightMoves() {
        for (int i = 0; i < 10; i++) {
            Pair<Integer, Integer> randomPosition = new Pair<>(random.nextInt(SIZE), random.nextInt(SIZE));
            boolean isLMove = isValidKnightMove(this.posKnight, randomPosition);
            boolean expectedHit = isLMove && randomPosition.equals(this.posPawn);
            boolean actualHit = logics.hit(randomPosition.getX(), randomPosition.getY());
            assertEquals(expectedHit, actualHit);
            if (isLMove) {
                this.posKnight = randomPosition;
            }
            assertTrue(logics.hasKnight(this.posKnight.getX(), this.posKnight.getY()));
        }
    }

    @Test
    public void testHitOutOfBoundsThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> logics.hit(-1, 2));
        assertThrows(IndexOutOfBoundsException.class, () -> logics.hit(2, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> logics.hit(SIZE, 2));
        assertThrows(IndexOutOfBoundsException.class, () -> logics.hit(2, SIZE));
    }

    private boolean isValidKnightMove(Pair<Integer, Integer> start, Pair<Integer, Integer> end) {
        int dx = Math.abs(start.getX() - end.getX());
        int dy = Math.abs(start.getY() - end.getY());
        return (dx == 1 && dy == 2) || (dx == 2 && dy == 1);
    }
}
