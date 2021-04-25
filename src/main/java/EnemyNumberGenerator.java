import java.util.ArrayList;
import java.util.List;

public class EnemyNumberGenerator {

    private void initNumber(BaseBallDTO dto){
        List<String> numbers = dto.getEnemyNumbers();
        String randomNumber = String.valueOf((int)(Math.random()*GameSetting.COUNT.value)+1);
        if(!numbers.contains(randomNumber)){
            numbers.add(randomNumber);
        }
        System.out.println("컵퓨터->"+numbers);
    }

    protected void generateNumber(BaseBallDTO dto){
        List<String> numberStorage = new ArrayList<>();
        dto.setEnemyNumbers(numberStorage);
        int maxLength = GameSetting.LENGTH.value;
        while(dto.getEnemyNumbers().size()<maxLength){
            initNumber(dto);
        }
    }

}
