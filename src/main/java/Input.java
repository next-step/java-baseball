public interface Input {

    /**
     * 플레이어의 응답(입력값)을 받는다.
     *
     * @return 플레이어가 입력한 값
     */
    String getInputValue();

    /**
     * 특정 메시지에 대한 플레이어의 응답(입력값)을 받는다.
     *
     * @param message 플레이어에게 출력할 요청 메시지
     * @return 플레이어가 입력한 값
     */
    String getInputValue(String message);
}
