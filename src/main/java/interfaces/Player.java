package interfaces;

import java.io.IOException;

public interface Player {

   //추측하는 숫자 입력
   void inputGuessableNumber() throws IOException;

   //입력된 숫자를 배열에 저장하는 메서드
   void saveInputNumberArr(int inputNumber);


}
