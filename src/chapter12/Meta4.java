package chapter12;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Meta4 {

    @MyAnno()
    public static void myMeth() {
        Meta4 ob = new Meta4();

        try {
            Class<?> c = ob.getClass();
            Method m = c.getMethod("myMeth");

            MyAnno anno = m.getAnnotation(MyAnno.class);
            System.out.println(anno.str() + " " + anno.val());
        } catch (NoSuchMethodException exc) {
            System.out.println("Method not found.");
        }

    }

    public static void main(String[] args) {
        myMeth();
    }
}

