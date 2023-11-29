package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class InputNumber {

    private final List<Integer> userNumber = new ArrayList<>();


    // 표준적인 접근 방법
    public List<Integer> getUserNumber() {
        return this.userNumber;
    }

    public void inputNumber () {
        String inputNumber = Console.readLine();
        validate(inputNumber);

        for (char number : inputNumber.toCharArray()) {
            userNumber.add(Integer.parseInt(String.valueOf(number)));
        }
    }

    // 숫자가 3개인지, 중복없는 숫자인지, 0 - 9까지의 범위인지
    private void validate(String inputNumber) {
        if (!inputNumber.matches("\\d{3}")) {
            throw new IllegalArgumentException("3개의 숫자를 입력해주세요.");
        }

        if (hasDuplicateOrInvalidRange(inputNumber)) {
            throw new IllegalArgumentException("0 ~ 9까지 중복없는 숫자를 입력해주세요.");
        }
    }

    private boolean hasDuplicateOrInvalidRange(String inputNumber) {
        HashSet<Character> hashSet = new HashSet<>();
        for (char ch : inputNumber.toCharArray()) {
            if (ch < '0' || ch > '9' || !hashSet.add(ch)) {
                return true;
            }
        }
        return false;
    }
}
