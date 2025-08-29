package io.loop.test.day9;

public class T2_singletonPattern_Example {
    // to achieve it we need private constructor

    private T2_singletonPattern_Example() {

    }

    private static String word;

    // public getter
    public static String getWord() {
        if (word == null) {
            System.out.println("First time calling, the object is null and hasn't been assigned yet");
            word = "driver";
        } else {
            System.out.println("word is already assigned and has value");
        }

        return word;
    }
}
