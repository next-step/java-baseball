import java.util.*;

public class BaseBallGame {

    static private Scanner sc;
    static private final int MAX_LENGTH=3;

    public void runBaseBallGame(){

        sc=new Scanner(System.in);
        while (isStart()) {
            startGame();
        }

    }

    private void startGame(){

        String botAnswer=generateAnswer();
        String userAnswer;

    }
    private String getUserInput(){

        System.out.print("숫자를 입력해주세요:");
        return sc.nextLine();
    }

    private String generateAnswer(){

        HashSet<Integer> set=new HashSet<Integer>();
        Random random=new Random();
        while(set.size()<MAX_LENGTH){
            set.add(random.nextInt(9)+1);
        }
        List<Integer> list=new ArrayList<>(set);
        Collections.shuffle(list);
        return listToString(list);
    }

    private String listToString(List list){

        String answer="";
        for(int i=0;i<list.size();i++){
            answer+=String.valueOf(list.get(i));
        }
        return answer;
    }


    private boolean isStart(){

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String startInput=sc.nextLine();
        while (!validateStartInput(startInput)) {
            startInput=sc.nextLine();
        }

        return checkStartInput(startInput);
    }

    private boolean validateStartInput(String startInput){

        if(startInput.equals("1")||startInput.equals("2")){
            return true;
        }
        System.out.println("잘못된 입력입니다.");
        return false;
    }

    private boolean checkStartInput(String startInput){

        if(startInput.equals("1")){
            return true;
        }
        return false;
    }

}



