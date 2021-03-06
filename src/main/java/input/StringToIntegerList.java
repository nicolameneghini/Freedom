package input;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class StringToIntegerList {

    private String inputString;

    public StringToIntegerList(String inputString) {
        this.inputString = inputString;
    }

    public List<Integer> integerList() {
      return Stream.of(inputString.split(" ")).
              map(x -> Integer.parseInt(x)-1).collect(Collectors.toList());
    }
}
