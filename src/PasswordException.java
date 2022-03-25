public class PasswordException extends Exception { // PasswordException 클래스는 프로그래머가 직접 만든 예외 처리. 즉, 사용자 정의 예외 처리 클래스.
    // 생성자
    public PasswordException(String message) {
        super(message);
    }
}
