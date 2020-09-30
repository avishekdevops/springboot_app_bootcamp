package com;



import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;



import com.SpringBootApp;



@ExtendWith(SpringExtension.class)

@SpringBootTest

public class SpringBootAppUnitTest {

int a=20,b=10;

SpringBootApp s = new SpringBootApp();

@Test

public void testAdd() {

Assertions.assertEquals(s.Add(a,b), 30);

}

@Test

public void testSub() {

Assertions.assertEquals(s.Sub(a,b), 10);

}

@Test

public void testMul() {

Assertions.assertEquals(s.Mul(a,b), 200);

}

@Test

public void testDiv() {

Assertions.assertEquals(s.Div(a,b), 2);

}

@Test

public void testRem() {

Assertions.assertEquals(s.Rem(a,b), 0);

}

} 

