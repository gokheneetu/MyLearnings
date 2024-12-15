//package com.example.selenium4java17;
//
//import org.openqa.selenium.remote.Browser;
//
//public class SingletonDriver {
//
//    private static Browser browser;
//
//    private SingletonDriver(){}
//
//    public static void getInstance(Browser browser){
//        if(SingletonDriver.browser == null){
//            synchronized (SingletonDriver.class){
//                if(SingletonDriver.browser == null){
//                    SingletonDriver.browser = new Browser() {
//                        @Override
//                        public String browserName() {
//                            return "";
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
