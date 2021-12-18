package chapter12;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MyMarker { }

public class Marker {

    @MyMarker
    public static void myMeyh() {
        Marker ob = new Marker();

        try {
            Method m = ob.getClass().getMethod("myMeyh");
            if (m.isAnnotationPresent(MyMarker.class)) {
                System.out.println("MyMarker is present.");
            }
        } catch (NoSuchMethodException exc) {
            System.out.println("Method not found.");
        }
    }

    public static void main(String[] args) {
        myMeyh();
    }
}
