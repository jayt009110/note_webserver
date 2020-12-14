package exception;

/**
 * 使用当前类演示异常的抛出
 */
public class Person {
    private  int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalAgeException {
        if(age<0||age>100){

//            throw new RuntimeException("年龄不合法");
            /*
                通常在一个方法中使用throw主动对外抛出一个异常时就要在当前方法上使用
                throws声明该异象的抛出，否则编译不通过，只有RuntimeException例外
             */
            throw new IllegalAgeException("年龄不合法 ");

        }
        this.age = age;
    }
}
