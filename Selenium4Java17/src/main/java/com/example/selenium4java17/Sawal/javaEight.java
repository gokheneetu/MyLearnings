package com.example.selenium4java17.Sawal;

import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class javaEight {
    public static void main(String[] args) {
        Student st = new Student("neetu",12);
        st.checkName("neetu");
        int count = (int) Stream.of(1, 2, 3, 4, 5, 6, 7).filter(e -> e % 2 == 0).count();
        Stream.of(1, 2, 3, 4, 5, 6, 7).filter(e -> e % 2 == 0).forEach(System.out::println);

        Stream.of("neetu","gokhe").map(e -> e + " hello").forEach(System.out::println);

        Stream.of("neetu","gokhe").map(e->e.toUpperCase(Locale.ROOT)).forEach(System.out::println);

        String[] str = {"new","year",null};
        Optional<String[]> optTest = Optional.ofNullable(str);
        System.out.println(optTest.isPresent());
        String key = "chrome";
        switch (key){
                case "chrome":
                    System.out.println("chrome====");
                    break;
                case "firefox":
                    System.out.println("firefox");
                    break;
            default:
                System.out.println("unknown");
                break;
        }

        var browser = switch (key) {
            case "chrome" -> "chrome";
            case "ff" -> "ff";
            default -> "default";
        };
        System.out.println(browser);
    }

    record Student(String name, int age) {
        public void checkName(String name) {
            if(Objects.equals(name, "neetu")){
                System.out.println("neetu");
                System.out.println(age);
            }
        }

    }

}
