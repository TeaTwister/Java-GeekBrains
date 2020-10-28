import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WinCheckTest {
    @Before
    public void setUp() {
        TicTacToe.player = 'X';
    }
    
    @Test
    public void test5x4() {
        TicTacToe.fieldSide = 5;
        TicTacToe.winCondition = 4;

        TicTacToe.emptyField();
        TicTacToe.commitMove(new int[]{1, 1}, 'X');
        TicTacToe.commitMove(new int[]{2, 2}, 'X');
        TicTacToe.commitMove(new int[]{4, 4}, 'X');
        TicTacToe.commitMove(new int[]{0, 0}, 'X');
        Assert.assertFalse(TicTacToe.checkWin());
        TicTacToe.commitMove(new int[]{3, 3}, 'X');
        Assert.assertTrue(TicTacToe.checkWin());

        TicTacToe.emptyField();
        TicTacToe.commitMove(new int[]{0, 4}, 'X');
        TicTacToe.commitMove(new int[]{1, 3}, 'X');
        TicTacToe.commitMove(new int[]{2, 2}, 'X');
        TicTacToe.commitMove(new int[]{3, 1}, 'X');
        Assert.assertTrue(TicTacToe.checkWin());

        TicTacToe.emptyField();
        TicTacToe.commitMove(new int[]{0, 1}, 'X');
        TicTacToe.commitMove(new int[]{1, 2}, 'X');
        TicTacToe.commitMove(new int[]{2, 3}, 'X');
        TicTacToe.commitMove(new int[]{3, 4}, 'X');
        Assert.assertTrue(TicTacToe.checkWin());

        TicTacToe.emptyField();
        TicTacToe.commitMove(new int[]{0, 1}, 'X');
        TicTacToe.commitMove(new int[]{1, 1}, 'X');
        TicTacToe.commitMove(new int[]{3, 1}, 'X');
        TicTacToe.commitMove(new int[]{4, 1}, 'X');
        Assert.assertFalse(TicTacToe.checkWin());
        TicTacToe.commitMove(new int[]{2, 1}, 'X');
        Assert.assertTrue(TicTacToe.checkWin());

        TicTacToe.emptyField();
        TicTacToe.commitMove(new int[]{1, 1}, 'X');
        TicTacToe.commitMove(new int[]{1, 2}, 'X');
        TicTacToe.commitMove(new int[]{1, 3}, 'X');
        TicTacToe.commitMove(new int[]{1, 4}, 'X');
        Assert.assertTrue(TicTacToe.checkWin());
    }

    @Test
    public void test3x3() {
        TicTacToe.fieldSide = 3;
        TicTacToe.winCondition = 3;

        TicTacToe.emptyField();
        TicTacToe.commitMove(new int[]{0, 1}, 'X');
        TicTacToe.commitMove(new int[]{1, 1}, 'X');
        Assert.assertFalse(TicTacToe.checkWin());
        TicTacToe.commitMove(new int[]{2, 1}, 'X');
        Assert.assertTrue(TicTacToe.checkWin());

        TicTacToe.emptyField();
        TicTacToe.commitMove(new int[]{2, 0}, 'X');
        TicTacToe.commitMove(new int[]{2, 1}, 'X');
        TicTacToe.commitMove(new int[]{2, 2}, 'X');
        Assert.assertTrue(TicTacToe.checkWin());

        TicTacToe.emptyField();
        TicTacToe.commitMove(new int[]{0, 0}, 'X');
        TicTacToe.commitMove(new int[]{1, 1}, 'X');
        TicTacToe.commitMove(new int[]{2, 2}, 'X');
        Assert.assertTrue(TicTacToe.checkWin());

        TicTacToe.emptyField();
        TicTacToe.commitMove(new int[]{0, 2}, 'X');
        TicTacToe.commitMove(new int[]{1, 1}, 'X');
        TicTacToe.commitMove(new int[]{2, 0}, 'X');
        Assert.assertTrue(TicTacToe.checkWin());

    }

}
