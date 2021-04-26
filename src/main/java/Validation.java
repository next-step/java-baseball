import java.util.HashSet;
import java.util.Set;

public class Validation {
    //입력 받은 숫자 정합성 확인
    public ValidationResult validationPitching(String pitching){
        ValidationResult validationResult = new ValidationResult();
        if(pitching.length()>3){
            validationResult.setResult(false);
            validationResult.setMessage("3자리까지만 입력 가능합니다. 다시 입력해주세요.");
            return validationResult;
        }

        boolean isNumeric =  pitching.matches("^[1-9]*$");
        if(!isNumeric){
            validationResult.setResult(false);
            validationResult.setMessage("1~9 숫자만 입력 가능합니다. 다시 입력해주세요.");
            return validationResult;
        }

        Set<Integer> pitch = new HashSet<>();
        for(int i=0;i<pitching.length();i++){
            pitch.add(Integer.parseInt(String.valueOf(pitching.charAt(i))));
        }

        if(pitch.size()!=3){
            validationResult.setResult(false);
            validationResult.setMessage("중복하지 않는 숫자로 다시 입력해주세요.");
            return validationResult;
        }

        int i = 0;
        int[] pitches = new int[3];
        for (int p: pitch) {
            pitches[i++] = p;
        }

        validationResult.setResult(true);
        validationResult.setPitches(pitches);

        return validationResult;
    }
}
