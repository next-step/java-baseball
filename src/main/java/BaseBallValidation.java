public class BaseBallValidation {

    public boolean restartValidationChk(String str){
        return "1".equals(str)||"2".equals(str);
    }

    public boolean validationChk(BaseBallDTO dto){
        return filedNumberChk(dto)||filedLengthChk(dto);
    }

    public boolean filedNumberChk(BaseBallDTO dto){
        boolean flag =  dto.getInputNumber().matches("[+-]?\\d*(\\.\\d+)?");
        if(!flag){
            System.out.println("숫자만 입력 가능합니다.");
        }
        return !flag;
    }

    public boolean filedLengthChk(BaseBallDTO dto){
        boolean flag = dto.getInputNumber().length()>GameSetting.LENGTH.value;
        if(flag){
            System.out.println("입력하신 길이가 초과 하였습니다.");
        }
        return flag;
    }
}
