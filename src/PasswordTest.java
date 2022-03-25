public class PasswordTest {
    // 멤버 변수
    private String password;

    public String getPassword() {
        return password;
    }

    // throws로 설정하면 해당 메서드, 즉 setPassword() 메서드에서 예외 처리를 하는 것이 아니라 이 메서드를 호출해서 사용하는 쪽에서 예외 처리를 하라는 것.
    // PasswordException 클래스는 프로그래머가 직접 만든 예외 처리. 즉, 사용자 정의 예외 처리 클래스.
    public void setPassword(String password) throws PasswordException {
        if (password == null) {
            throw new PasswordException("비밀번호는 null 일 수 없습니다.");
        } else if (password.length() < 5) {
            throw new PasswordException("비밀번호는 5자 이상이어야 합니다.");
        } else if (password.matches("[a-zA-Z]+")) {
            throw new PasswordException("비밀번호는 숫자나 특수문자를 포함해야 합니다.");
        }

        this.password = password;
    }

    public static void main(String[] args) {
        PasswordTest passwordTest = new PasswordTest();

        String password = null;

        // setPassword() 메서드에서 throws를 설정하였기 때문에 호출해서 사용하는 쪽에서 예외 처리를 해야 한다.
        try {
            passwordTest.setPassword(password);
            System.out.println("오류없음1");
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }

        password = "abc";

        try {
            passwordTest.setPassword(password);
            System.out.println("오류없음2");
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }

        password = "abcde";

        try {
            passwordTest.setPassword(password);
            System.out.println("오류없음3");
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }

        password = "abcde123";

        try {
            passwordTest.setPassword(password);
            System.out.println("오류없음4");
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }

        // 결과
        // 비밀번호는 null 일 수 없습니다.
        // 비밀번호는 5자 이상이어야 합니다.
        // 비밀번호는 숫자나 특수문자를 포함해야 합니다.
        // 오류없음4
    }
}
