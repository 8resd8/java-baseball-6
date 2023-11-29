package baseball;

import java.util.List;
import java.util.stream.IntStream;

public class Calculate {
    private static final int NUMBER_SIZE = 3;

    // 같은 위치에 같은 숫자가 있는 경우
    public int strike(List<Integer> computerNumber, List<Integer> userNumber) {
        return (int) IntStream.range(0, NUMBER_SIZE)
                .filter(i -> userNumber.get(i).equals(computerNumber.get(i)))
                .count();
    }

    // 같은 위치가 아니고 일치하는 숫자가 있는 경우
    public int ball(List<Integer> computerNumber, List<Integer> userNumber) {
        return (int) IntStream.range(0, NUMBER_SIZE)
                .filter(i -> !userNumber.get(i).equals(computerNumber.get(i)) &&
                                computerNumber.contains(userNumber.get(i)))
                .count();
    }

}
