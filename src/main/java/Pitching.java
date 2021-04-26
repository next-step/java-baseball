public class Pitching {

    public PitchingResult getPitchingResult(String pitching, int[] baseballNumber){
        PitchingResult pitchingResult = new PitchingResult();

        int strike = 0;
        int ball = 0;

        int[] pitches = getPitches(pitching);
        for(int i=0 ; i<pitches.length ; i++){
            if(isStrike(baseballNumber, i, pitches[i])) strike++;
            if(isBall(baseballNumber, i, pitches[i])) ball++;
        }

        pitchingResult.setStrike(strike);
        pitchingResult.setBall(ball);

        if(strike==3){
            pitchingResult.setResult(true);
            return pitchingResult;
        }else if(strike==0 && ball==0){
            pitchingResult.setNothing(false);
            return pitchingResult;
        }

        return pitchingResult;
    }

    //입력 받은 숫자를 한 글자씩 끊어 저장
    public int[] getPitches(String pitching){
        int[] pitches = new int[pitching.length()];
        for(int i=0;i<pitching.length();i++){
            pitches[i]= Integer.parseInt(String.valueOf(pitching.charAt(i)));
        }
        return pitches;
    }

    //숫자가 스트라이크인지 판별
    public boolean isStrike(int[] baseballNumber, int index, int pitch){
        if(baseballNumber[index] == pitch){
            return true;
        }
        return false;
    }

    //숫자가 볼인지 판별
    public boolean isBall(int[] baseballNumber, int index, int pitch){
        boolean contain = false;
        for(int number : baseballNumber){
            if(pitch == number){
                contain = true;
                break;
            }
        }

        if(contain && baseballNumber[index] != pitch){
            return true;
        }
        return false;
    }
}
