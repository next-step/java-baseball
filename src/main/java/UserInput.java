import java.util.Scanner;

public class UserInput {

    public UserInput() {
    }

    Integer inputNumber = 0;

    public Integer setAndGetInputNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");

        try {
            this.inputNumber = sc.nextInt();
            if((int)Math.log10( inputNumber) +1 != 3) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("3자리의 자연수 형식으로 다시 입력해 주세요");
            inputNumber = setAndGetInputNumber();
        }

        return inputNumber;
    }

}
