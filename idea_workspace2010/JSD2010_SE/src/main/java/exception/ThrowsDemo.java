package exception;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLClientInfoException;

/**
 * 子类重写超类中含有throws声明方法时，对throws的特殊重写规则
 */
public class ThrowsDemo {
    public void dosome()throws IOException, AWTException{}
}

class SubClass extends ThrowsDemo{
//    public void dosome()throws IOException,AWTException{}
//
//    子类方法可以不抛出任何异常
//    public void dosome(){}

//    子类方法可以仅抛出超类方法抛出的部分异常
//    public void dosome()throws AWTException{}

    //子类方法抛出超类方法抛出异常的子类型异常
//    public void dosome()throws FileNotFoundException{}

    //不允许抛出额外异常（超类方法没有的，也没有继承关系的）
//    public void dosome()throws SQLException{}

    //不允许子类方法抛出超类方法抛出异常的超类型异常
//    public  void dosome()throws Exception(){}
}