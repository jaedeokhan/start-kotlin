package ch1;

public class Test {
    public static void main(String[] args) {
        // Java에서 Kotlin 파일에 선언된 변수, 함수 이용
        // 파일명+Kt 클래스의 static 멤버로 이용해야 한다.
        System.out.println(Test1Kt.getSum());
        Test1Kt.calSum();

        User user = new User();
        user.sayHello();
    }
}
