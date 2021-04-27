package util;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author 이충선
 *
 * @memo 사용자 Number check
 * 
 */
public class CheckNumber {
	
	public int idx = 0;
	public int[] rtnNumber = null;
	public String tmpNumber = "";
	
	public boolean checkNumber(String tempNumber) {
		
		if(!stringCheck(tempNumber))return false;
		if(!lengthCheck(tempNumber))return false;
		if(!duplicateCheck(tempNumber))return false;
		return true;
	}
	
	/**
	 * 
	 * @author 이충선
	 *
	 * @memo 숫자만 입력했는지 여부
	 * 
	 */
	public boolean stringCheck(String tempNumber) {
		boolean rslt = true;
		String regex = "[0-9]+";
		
		if(!tempNumber.matches(regex)) {
			System.out.println("숫자만 입력 가능합니다.");
			rslt = false;
		}
		
		return rslt;
	}
	
	/**
	 * 
	 * @author 이충선
	 *
	 * @memo 3자리 입력했는지 여부
	 * 
	 */
	public boolean lengthCheck(String tempNumber) {
		boolean rslt = true;
		
		if(tempNumber.length() != 3) {
			System.out.println("3자리를 입력해 주세요.");
			rslt = false;
		}
		
		return rslt;
	}
	
	/**
	 * 
	 * @author 이충선
	 *
	 * @memo 중복 숫자 있는지 여부
	 * 
	 */
	public boolean duplicateCheck(String tempNumber) {
		boolean rslt = true;
		
		Set duplSet = new HashSet();
		for(char chr : tempNumber.toCharArray()) {
			duplSet.add(chr);
		}
		
		if(duplSet.size() != 3) {
			System.out.println("숫자가 중복되면 안됩니다.");
			rslt = false;
		}
		
		return rslt;
	}
	
}