package winningtest;

import org.junit.Before;
import org.junit.Test;
import winning.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class QuadrupletsTest {

    private Character[][] fullBoard;
    
    private Boolean[][] liveStonesBoardAfterHorizontalQuadrupletEightZero;
    private Boolean[][] liveStonesBoardAfterHQEightZeroEightSix;
    private Boolean[][] liveStonesBoardAfterSettingHVBlackStones;
    private Boolean[][] liveStonesBoardAfterSettingHVDBlackStones;
    private Boolean[][] liveStonesBoardAfterSettingHVDABlackStones;

    @Before
    public void initFullBoard(){

        fullBoard = new Character[][]
                        {{'B', 'W', 'B', 'W', 'B', 'B', 'W', 'W', 'B', 'W'},
                        {'B', 'W', 'B', 'B', 'W', 'W', 'B', 'B', 'B', 'W'},
                        {'W', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'B'},
                        {'B', 'B', 'W', 'B', 'B', 'W', 'B', 'W', 'W', 'W'},
                        {'W', 'W', 'B', 'W', 'W', 'W', 'B', 'B', 'W', 'B'},
                        {'B', 'B', 'W', 'B', 'B', 'W', 'W', 'B', 'B', 'W'},
                        {'W', 'W', 'B', 'W', 'W', 'B', 'B', 'W', 'B', 'B'},
                        {'W', 'W', 'B', 'W', 'W', 'B', 'W', 'W', 'W', 'W'},
                        {'B', 'B', 'B', 'B', 'W', 'W', 'B', 'B', 'B', 'B'},
                        {'W', 'B', 'W', 'W', 'B', 'B', 'W', 'W', 'W', 'B'}};
        
        liveStonesBoardAfterHorizontalQuadrupletEightZero = new Boolean[][]
                                {{false, false, false, false, false, false, false, false, false, false},
                                {false, false, false, false, false, false, false, false, false, false},
                                {false, false, false, false, false, false, false, false, false, false},
                                {false, false, false, false, false, false, false, false, false, false},
                                {false, false, false, false, false, false, false, false, false, false},
                                {false, false, false, false, false, false, false, false, false, false},
                                {false, false, false, false, false, false, false, false, false, false},
                                {false, false, false, false, false, false, false, false, false, false},
                                {true, true, true, true, false, false, false, false, false, false},
                                {false, false, false, false, false, false, false, false, false, false}};

        liveStonesBoardAfterHQEightZeroEightSix = new Boolean[][]
                        {{false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false},
                        {true, true, true, true, false, false, true, true, true, true},
                        {false, false, false, false, false, false, false, false, false, false}};

        liveStonesBoardAfterSettingHVBlackStones = new Boolean[][]
                        {{false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, true, false, false, false},
                        {false, false, false, false, false, false, true, false, false, false},
                        {false, false, false, false, false, false, true, false, false, false},
                        {false, false, false, false, false, false, true, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false},
                        {true, true, true, true, false, false, true, true, true, true},
                        {false, false, false, false, false, false, false, false, false, false}};

        liveStonesBoardAfterSettingHVDBlackStones = new Boolean[][]
                        {{false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, true, false, false, false},
                        {false, false, false, false, false, false, true, false, false, false},
                        {false, false, false, false, false, false, true, false, false, false},
                        {false, false, false, false, false, false, true, true, false, false},
                        {false, false, false, false, false, false, false, false, true, false},
                        {false, false, false, false, false, false, false, false, false, true},
                        {false, false, false, false, false, false, false, false, false, false},
                        {true, true, true, true, false, false, true, true, true, true},
                        {false, false, false, false, false, false, false, false, false, false}};

        liveStonesBoardAfterSettingHVDABlackStones = new Boolean[][]
                        {{false, false, false, false, true, false, false, false, false, false},
                        {false, false, false, true, false, false, true, false, false, false},
                        {false, false, true, false, true, false, true, false, false, false},
                        {false, true, false, true, false, false, true, false, false, false},
                        {false, false, true, false, false, false, true, true, false, false},
                        {false, true, false, false, false, false, false, false, true, false},
                        {false, false, false, false, false, false, false, false, false, true},
                        {false, false, false, false, false, false, false, false, false, false},
                        {true, true, true, true, false, false, true, true, true, true},
                        {false, false, false, false, false, false, false, false, false, false}};

    }
    
    @Test
    public void doINeedToCheckHorizontalQuadrupletElementZeroZero() {
        HorizontalQuadruplet horizontalQuadruplet = new HorizontalQuadruplet(fullBoard, 0, 0);
        assertThat(horizontalQuadruplet.isQuadrupletACandidate(), is(false));
    }

    @Test
    public void doINeedToCheckVerticalQuadrupletElementZeroZero() {
        VerticalQuadruplet verticalQuadruplet = new VerticalQuadruplet(fullBoard, 0, 0);
        assertThat(verticalQuadruplet.isQuadrupletACandidate(), is(true));
    }

    @Test
    public void doINeedToCheckDiagonalQuadrupletElementZeroZero() {
        DiagonalQuadruplet diagonalQuadruplet = new DiagonalQuadruplet(fullBoard, 0, 0);
        assertThat(diagonalQuadruplet.isQuadrupletACandidate(), is(true));
    }

    @Test
    public void doINeedToCheckHorizontalQuadrupletElementZeroOne() {
        HorizontalQuadruplet horizontalQuadruplet = new HorizontalQuadruplet(fullBoard, 0, 1);
        assertThat(horizontalQuadruplet.isQuadrupletACandidate(), is(true));
    }
    
    @Test
    public void doINeedToCheckHorizontalQuadrupletElementZeroFive() {
        HorizontalQuadruplet horizontalQuadruplet = new HorizontalQuadruplet(fullBoard, 0, 5);
        assertThat(horizontalQuadruplet.isQuadrupletACandidate(), is(false));
    }
    
    @Test
    public void testValidQuadruplet() {
        HorizontalQuadruplet horizontalQuadruplet = new HorizontalQuadruplet(fullBoard, 8, 0);
        assertThat(horizontalQuadruplet.isQuadrupletValid('B'), is(true));
    }

    @Test
    public void testAllHorizontalQuadrupletsAreSet() {
        LiveStonesBoard liveStonesBoard = new LiveStonesBoard(fullBoard.length);
        QuadrupletChecker quadrupletChecker = new QuadrupletChecker(liveStonesBoard, fullBoard);
        quadrupletChecker.setAllRowStones();
        assertThat(liveStonesBoard.getCurrentBoard(), is(liveStonesBoardAfterHQEightZeroEightSix));
    }

    @Test
    public void testAllHorizontalVerticalQuadrupletsAreSet() {
        LiveStonesBoard liveStonesBoard = new LiveStonesBoard(fullBoard.length);
        QuadrupletChecker quadrupletChecker = new QuadrupletChecker(liveStonesBoard, fullBoard);
        quadrupletChecker.setAllRowStones();
        quadrupletChecker.setAllColumnStones();
        assertThat(liveStonesBoard.getCurrentBoard(), is(liveStonesBoardAfterSettingHVBlackStones));
    }

    @Test
    public void testAllHorizontalVerticalDiagonalQuadrupletsAreSet() {
        LiveStonesBoard liveStonesBoard = new LiveStonesBoard(fullBoard.length);
        QuadrupletChecker quadrupletChecker = new QuadrupletChecker(liveStonesBoard, fullBoard);
        quadrupletChecker.setAllRowStones();
        quadrupletChecker.setAllColumnStones();
        quadrupletChecker.setAllDiagonalStones();
        assertThat(liveStonesBoard.getCurrentBoard(), is(liveStonesBoardAfterSettingHVDBlackStones));
    }

    @Test
    public void testAllHorizontalVerticalDiagonalAntiQuadrupletsAreSet() {
        LiveStonesBoard liveStonesBoard = new LiveStonesBoard(fullBoard.length);
        QuadrupletChecker quadrupletChecker = new QuadrupletChecker(liveStonesBoard, fullBoard);
        quadrupletChecker.setAllRowStones();
        quadrupletChecker.setAllColumnStones();
        quadrupletChecker.setAllDiagonalStones();
        quadrupletChecker.setAllAntiDiagonalStones();
        assertThat(liveStonesBoard.getCurrentBoard(), is(liveStonesBoardAfterSettingHVDABlackStones));
    }
    
    
}
