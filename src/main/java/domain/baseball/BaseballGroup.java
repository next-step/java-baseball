package domain.baseball;

import org.apache.commons.lang.StringUtils;

import java.util.*;

public class BaseballGroup {

    // Random으로 생성될 자리 수
    private static final int RANDOM_LENGTH = 3;

    private final List<Baseball> baseballValues;

    public static int getRandomLength() {
        return RANDOM_LENGTH;
    }

    public BaseballGroup(List<Baseball> baseballValues) {
        validateNumberSize(baseballValues);
        validateDuplicateNumberValue(baseballValues);
        this.baseballValues = baseballValues;
    }

    public BaseballGroup(String baseballValues){
        validateStringCheck(baseballValues);
        List<Baseball> baseballList = convertStringNumberToListBaseball(baseballValues);

        validateNumberSize(baseballList);
        validateDuplicateNumberValue(baseballList);
        this.baseballValues = baseballList;
    }

    private void validateStringCheck(String baseballValues) {
        if(StringUtils.isEmpty(baseballValues)){
            throw new IllegalArgumentException("잘못된 숫자 값이 입력되었습니다.");
        }
    }

    private List<Baseball> convertStringNumberToListBaseball(String baseballValues){
        String[] baseballStringValues = baseballValues.split("");

        List<Baseball> baseballs = new ArrayList<>();
        for(String baseballNumber : baseballStringValues){
            baseballs.add(new Baseball(Long.valueOf(baseballNumber)));
        }

        return baseballs;
    }

    // domain.baseball 내에 value로 넘어온 값의 Size 체크
    public static void validateNumberSize(List<Baseball> baseballValues) {
        if(baseballValues.size() != RANDOM_LENGTH){
            throw new IllegalArgumentException(String.format("야구 게임의 입력 숫자는 %d 개를 입력해주세요.",RANDOM_LENGTH));
        }
    }

    // domain.baseball 내에 value 값이 중복된 값이 있는지 체크
    public static void validateDuplicateNumberValue(List<Baseball> baseballValues){
        Set<Baseball> duplicateNumbers = new HashSet<>(baseballValues);
        if(RANDOM_LENGTH != duplicateNumbers.size()){
            throw new IllegalArgumentException("야구 게임의 입력 숫자는 중복 될 수 없습니다.");
        }
    }

    public int baseballValueSize(){
        return baseballValues.size();
    }

    public List<Baseball> getBaseballList(){
        return baseballValues;
    }
}

