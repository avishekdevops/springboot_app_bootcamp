package com;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication

public class Application {

private static final Logger log = LoggerFactory.getLogger(SpringBootApp.class);
public int Add(int a, int b) {
return a+b;
}
public int Sub(int a, int b) {
return a-b;
}
public int Mul(int a, int b) {
return a*b;
}
public int Div(int a, int b) {
return a/b;
}
public int Rem(int a, int b) {
return a%b;
}
public static void main(String[] args) {
log.info("Main method has been invoked");
springApplication.run(SpringBootApp.class,args);
}
} 

