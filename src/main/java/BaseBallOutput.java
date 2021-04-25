public class BaseBallOutput {


    protected int resultOfAtack(BaseBallDTO dto){
        int result = new BaseBallOutput()
                .strikeOutput(dto)
                .ballOutput(dto)
                .nothingOutput(dto)
                .threeStrikeOutput(dto);
        return result;
    }

    public BaseBallOutput strikeOutput(BaseBallDTO dto){
        if(dto.getCountOfStrike()>0){
            System.out.print(dto.getCountOfStrike()+" 스트라이크 ");
        }
        return this;
    }
    public BaseBallOutput ballOutput(BaseBallDTO dto){
        if(dto.getCountOfBall()>0){
            System.out.print(dto.getCountOfBall()+" 볼");
        }
        return this;
    }

    public BaseBallOutput nothingOutput(BaseBallDTO dto){
        if((dto.getCountOfStrike()+dto.getCountOfBall())==0){
            System.out.print("낫싱");
        }
        return this;
    }

    public int threeStrikeOutput(BaseBallDTO dto){
        if(dto.getCountOfStrike()==3){
            System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            return CODE.SUCCESS.getValue();
        }
        System.out.println();
        return 0;
    }

}
