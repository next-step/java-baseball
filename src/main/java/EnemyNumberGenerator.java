import java.util.ArrayList;
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

    protected BaseBallDTO generateNumber(BaseBallDTO dto){
        List<Integer> numberStorage = new ArrayList<>();
        dto.setNumberStorage(numberStorage);
        int maxLength = GameSetting.LENGTH.getValue();
        while(dto.getNumberStorage().size()<maxLength){
            initNumber(dto);
        }
        return dto;
    }

    protected BaseBallDTO setEnemyNumber(BaseBallDTO dto){
        StringBuilder numbers = new StringBuilder();
        dto.getNumberStorage().forEach((Integer index)->numbers.append(index));
        dto.setEnemyNumber(String.valueOf(numbers));
        return dto;
    }

}
