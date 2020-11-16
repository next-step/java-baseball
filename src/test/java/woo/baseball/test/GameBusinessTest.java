package woo.baseball.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import woo.baseball.business.GameBusiness;
import woo.baseball.domain.GameStatus;
import woo.baseball.service.InputService;

/**
 * @author : chano
 * @Date : 2020. 11. 11.
 * @Description : woo.baseball.utils 패키지에 대한 테스트.
 */
public class GameBusinessTest {

List<String> listHuman;
List<String> listComputer;
String [] humanString= {"1","2","3"};
String [] computerString= {"1","7","4"};


  
  @BeforeEach
  void setUp1() {
    listHuman= Arrays.asList(humanString);
    listComputer= Arrays.asList(computerString);
    
    }

  
	@Test
	@DisplayName("validationNumber Test")
	void validationNumber() {
	  List<String> listhuman = new ArrayList<String>();
	  List<String> listcomputer = new ArrayList<String>();
    
	  listhuman.add("1");
	  listhuman.add("2");
	  listhuman.add("3");
    listcomputer.add("4");
    listcomputer.add("6");
    listcomputer.add("3");
    
	      
	  assertFalse(InputService.validDistinctNumber(133));
	  assertThat(InputService.validDistinctNumber(143));
    
	}
	
	
	@Test
	@DisplayName("strikeBallTest")
	void strikeTest()
	{
	  for (int i = 0; i < computerString.length; i++) {
	    GameBusiness.strikeBallCount(listHuman, listComputer, i);      
    }
	  assertThat("1").contains(String.valueOf(GameStatus.strike));
	  assertThat("0").contains(String.valueOf(GameStatus.ball));
	  
	}

}
