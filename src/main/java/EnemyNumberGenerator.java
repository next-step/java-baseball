import java.util.List;

public class EnemyNumberGenerator {

    private void initNumber(BaseBallDTO dto){
        List<Integer> numbers = dto.getNumberStorage();
        int randomNumber = (int)(Math.random()*GameSetting.COUNT.getValue())+1;
        if(!numbers.contains(randomNumber)){
            numbers.add(randomNumber);
        }
        dto.setNumberStorage(numbers);
    }


}
