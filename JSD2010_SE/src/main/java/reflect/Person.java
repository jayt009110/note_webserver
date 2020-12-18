package reflect;

/**
 * 使用当前类测试反射
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(){
        this.name = "张三";
        this.age = 23;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void sayHello(){
        System.out.println(name+"说:hello!");
    }

    public void say(String info){
        System.out.println(name+":"+info);
    }

    public void say(String info,int sum){
        for(int i=0;i<sum;i++){
            System.out.println(name+":"+info);
        }
    }
    private void hehe(){
        System.out.println("你不能硬着来");
    }
}
