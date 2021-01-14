import java.util.Set;

public class Numbers {

    private final Set<Integer> numbers;

    public Numbers(Set<Integer> numbers) {
        // TODO: 인자 numbers에 대한 유효성 검증

        this.numbers = numbers;
    }

    public Set<Integer> getNumbers() {
        return this.numbers;
    }

    // TODO: 다른 `Numbers`를 인자로 받아 두 `Numbers`에 대해 볼카운트를 알려주는 public 메서드 제공

}
