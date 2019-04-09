package com.hacker.framework.transactions;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by hacker on 2019/4/9 0009.
 */
public class TransactionTest {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        SimpleTransactionServiceHandler handler = ctx.getBean(SimpleTransactionServiceHandler.class);

        handler.serviceWithoutResult();
    }
}
