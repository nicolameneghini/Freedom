package input;

import exceptions.OutOfBoundsException;

import java.util.List;

public class ValidInputMove {
    
    private List<Integer> move;
    private Integer boardSize;
    
    public ValidInputMove(Integer boardSize, List<Integer> parsedIntegers){
        this.move = parsedIntegers;
        this.boardSize = boardSize;
    }
    
    public List<Integer> inputMove() throws OutOfBoundsException {
        Integer row = move.get(0);
        Integer column = move.get(1);
        if(row >= boardSize || row < 0 || column < 0 || column >= boardSize) {
            throw new OutOfBoundsException("Input coordinates must be between 1 and " + boardSize + "!");
        } else return move;
    }
    
}
    
