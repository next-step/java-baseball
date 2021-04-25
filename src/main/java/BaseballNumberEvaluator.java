/**
 * 입력된 숫자와 생성된 숫자를 검사
 */
public class BaseballNumberEvaluator {

    /**
     * 베이스볼 숫자를 검사하여 결과 값을 반환
     * @param source
     * @param target
     * @return
     */
    public EvaluationResult evaluate(String source, String target) {
        EvaluationResult result = new EvaluationResult();
        // 일치하는지 검사
        if (source.equals(target)) {
            result.success(); // 성공 처리
            return result;
        }
        // 볼, 스트라이크 검사
        for (int i = 0; i < 3; i++) {
            evaluateBallOrStrike(result, source, target, i);
        }

        return result;
    }

    /**
     * 평가하여 스트라이크, 볼수 세팅
     * @param result
     * @param source
     * @param target
     * @param position
     * @return
     */
    private EvaluationResult evaluateBallOrStrike(EvaluationResult result, String source, String target, int position) {
        // 스트라이크 검사
        if (isStrike(source, target, position)) {
            result.increaseStrike();
            return result;
        }
        // 볼 검사
        if(isBall(source, target, position)){
            result.increaseBall();
        }
        return result;
    }

    /**
     * 스트라이크인지 검사
     * @param source
     * @param target
     * @param position
     * @return
     */
    private Boolean isStrike(String source, String target, int position) {
        char sourceChar = source.charAt(position);
        char targetChar = target.charAt(position);
        if(sourceChar == targetChar){
            return true;
        }
        return false;
    }

    /**
     * 볼인지 검사
     * @param source
     * @param target
     * @param position
     * @return
     */
    private Boolean isBall(String source, String target, int position) {
        char targetChar = target.charAt(position);
        Boolean isBall = false;
        for (int i = 0; i < 3 && !isBall; i++) {
            char sourceChar = source.charAt(i);
            isBall = sourceChar == targetChar;
        }
        return isBall;
    }
}
