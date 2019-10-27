package cn.bikan8.log;

/**
 * @author 小浩
 * @date 2019/10/10 14:13
 */
/*
                             _ooOoo_
                            o8888888o
                            88" . "88
                            (| -_- |)
                            O\  =  /O
                         ____/`---'\____
                       .'  \\|     |//  `.
                      /  \\|||  :  |||//  \
                     /  _||||| -:- |||||-  \
                     |   | \\\  -  /// |   |
                     | \_|  ''\---/''  |   |
                     \  .-\__  `-`  ___/-. /
                   ___`. .'  /--.--\  `. . __
                ."" '<  `.___\_<|>_/___.'  >'"".
               | | :  `- \`.;`\ _ /`;.`/ - ` : | |
               \  \ `-.   \_ __\ /__ _/   .-` /  /
          ======`-.____`-.___\_____/___.-`____.-'======
                             `=---='
          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                     佛祖保佑        永无BUG
            佛曰:
                   写字楼里写字间，写字间里程序员；
                   程序人员写程序，又拿程序换酒钱。
                   酒醒只在网上坐，酒醉还来网下眠；
                   酒醉酒醒日复日，网上网下年复年。
                   但愿老死电脑间，不愿鞠躬老板前；
                   奔驰宝马贵者趣，公交自行程序员。
                   别人笑我忒疯癫，我笑自己命太贱；
                   不见满街漂亮妹，哪个归得程序员？
*/


import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * 切面Log类实现前置通知接口MethodBeforeAdvice
 * @author 王铭远
 *
 */
public class Log implements MethodBeforeAdvice{
    /**
     * @param method 被执行的方法对象
     * @param args 方法的参数
     * @param target 被代理的目标对象
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        //通知逻辑
        System.out.println(target.getClass().getName()+"的"+method.getName()+"方法被执行");
    }
}