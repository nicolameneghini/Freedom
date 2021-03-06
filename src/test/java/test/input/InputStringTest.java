package test.input;

import exceptions.BoardTooSmallException;
import exceptions.OutOfBoundsException;
import exceptions.WrongPassMessageException;
import input.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputStringTest {

    private final Integer boardTenSize = 10;

    @Test
     public void whenSizeIsTenAndRowPlayedIsElevenExceptionIsThrown() {

        List<Integer> moveList = Arrays.asList(11,9);
        ValidInputMove validInputMove = new ValidInputMove(boardTenSize, moveList);

        OutOfBoundsException thrown = assertThrows(OutOfBoundsException.class, () -> {
            validInputMove.inputMove();
        });
        assertTrue(thrown.getMessage().contains("Input coordinates must be between 1 and " + boardTenSize + "!"));
    }


    @Test
    public void whenNotIntegerInputAnExceptionIsCaught() {

        String stringMove = "e 1";
        StringToIntegerList stringToIntegerList = new StringToIntegerList(stringMove);

         NumberFormatException thrown = assertThrows(NumberFormatException.class, () -> {
            stringToIntegerList.integerList();
        });
    }

    @Test
    public void testWhenBoardSizeIsLessThanSixException() {

        ValidBoardSize validBoardSize = new ValidBoardSize(3);
        BoardTooSmallException thrown = assertThrows(BoardTooSmallException.class,
                            () -> validBoardSize.boardSize());
                            
         assertTrue(thrown.getMessage().contains("Board size must be greater than or equal to 6!"));
    }

    @Test
    public void whenPassMessageIsWrongThanThrowException() {
        String wrongPassMessage = "Z";
        ValidPassMessage validPassMessage = new ValidPassMessage(wrongPassMessage);

        WrongPassMessageException thrown = assertThrows(WrongPassMessageException.class,
                () -> validPassMessage.passMessage());

        assertTrue(thrown.getMessage().contains("Type Y if you want to pass, N otherwise!"));
    }

    @Test
    public void whenPassMessageIsRightThanNoException() throws WrongPassMessageException {
        String wrongPassMessage = "Y";
        ValidPassMessage validPassMessage = new ValidPassMessage(wrongPassMessage);


        assertThat(validPassMessage.passMessage(), is("Y"));
    }
}
    

