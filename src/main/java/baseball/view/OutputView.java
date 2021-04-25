/**
* FileName : UserOutput.java
* Created  : 2021. 4. 25.
* Author   : youngjun.jin
* Summary  :
* Copyright (C) 2021 yzzzzun. All rights reserved.
*
* 이 문서의 모든 저작권 및 지적 재산권은 yzzzzun에게 있습니다.
* 이 문서의 어떠한 부분도 허가 없이 복제 또는 수정 하거나, 전송할 수 없습니다.
*/
package baseball.view;

import baseball.model.InningResult;

public class OutputView extends View {

	public void printInningResult(InningResult inningResult) {
		out.println(inningResult.toString());
	}

	public void printEndGame() {
		out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
	}
}
