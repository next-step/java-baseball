package service;

import domain.Check;
import domain.Com;

public interface BaseService {
    boolean resultCheck(int st, int ball);
    boolean playChoice(String ch);
    String getUserNum();
    Com comNan();
    Check resultPrint(Check check);
    Check result(Check check, String s, String anObject, int i, int j);
}
