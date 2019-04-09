package com.hacker.framework.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by hacker on 2019/4/9 0009.
 */
public class SimpleTransactionServiceHandler implements TransactionServiceHandler{

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public void serviceWithResult() {

        UserInfo userInfo = this.transactionTemplate.execute(new TransactionCallback<UserInfo>() {

            @Nullable
            @Override
            public UserInfo doInTransaction(TransactionStatus transactionStatus) {

                userInfoService.update("update userinfo set user_name = 'lisi' where user_id=1");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //这个sql一定会出错，演示查看数据库是否会回滚
                teacherService.update("xxx delete from teacher where teacher_id = 1");

                return new UserInfo();
            }
        });

        //可以继续做一些操作，就是他可以有返回值
    }

    /**
     * 其实他和上面一样的，只不过他是没有返回值而已
     */
    @Override
    public void serviceWithoutResult() {
       this.transactionTemplate.execute(new TransactionCallbackWithoutResult() {
           @Override
           protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {

               /**
                * 本身就关闭了自动提交
                * */
               try {
                   userInfoService.update("update userinfo set user_name = 'zhangsan' where user_id=1");

                   try {
                       Thread.sleep(2000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   //这个sql一定会出错，演示查看数据库是否会回滚
                   teacherService.update("xxx delete from teacher where teacher_id = 1");
               } catch (Exception e) {
                   e.printStackTrace();
                   /**
                    * 出现异常要记得回滚
                    */
                   transactionStatus.setRollbackOnly();;
               }
           }
       });
    }
}
