package dev.cobi.domains;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cobiyu
 */
public class PlayNumber {
  private final String number;
  public final static int PLAY_NUMBER_LENGTH = 3; // 숫자 최대 길이

  /**
   * Constructor 
   * inputNumberValidationCheck을 통과하지 못하면 생성 불가
   * 
   * @param number 사용할 숫자
   */
  public PlayNumber(String number) {
    this.number = number;
    inputNumberValidationCheck();
  }

  /**
   * 사용할 숫자 validation check
   */
  public void inputNumberValidationCheck(){
    if(number.length()!= PLAY_NUMBER_LENGTH){
      throw new IllegalArgumentException("playNumber length error");
    }
    if(number.charAt(0) == '0'){
      throw new IllegalArgumentException("playNumber format error");
    }
    if(isDuplicateNumber()){
      throw new IllegalArgumentException("playNumber is duplicate");
    }
  }

  /**
   * 중복체크 
   * 
   * @return 중복체크 여부
   */
  public boolean isDuplicateNumber(){
    Set<Character> setForDuplicateCheck = new HashSet<>();
    for (int i = 0; i < number.length(); i++) {
      setForDuplicateCheck.add(number.charAt(i));
    }
    
    return setForDuplicateCheck.size() != number.length(); 
  }

  public String getNumber() {
    return number;
  }
}
