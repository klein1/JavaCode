package Tools;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface UserManager {

    public void addUser(String name, String password);
    public void detUser(String name);
}

class UserManagerImpl implements UserManager {
    @Override
    public void addUser(String id, String password) {
        System.out.println("调用了UserManagerImpl.addUser()方法");
    }

    @Override
    public void detUser(String id) {
        System.out.println("调用了UserManagerImpl.detUser()的方法");
    }
}

class JDKDynamicProxy implements InvocationHandler {
    //需要代理的目标对象
    private Object targetObject;

    public Object newProxy(Object targetObject) {
        //将目标对象传入进行代理
        this.targetObject = targetObject;
        //将代理对象返回 //其中有三个参数
        return Proxy.newProxyInstance(
                targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(),
                this);
    }

    // invoke 测试方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 代理前 ：逻辑处理的方法(函数)
        checkPopedom();
        // 调用invoke()
        Object reflect = method.invoke(targetObject, args);
        // 代理后：
        isOK();
        return reflect;
    }

    private void isOK() {
        System.out.println("权限通过：isOK()");
    }

    private void checkPopedom() {
        System.out.println("检查权限：checkPopedom()");
    }
}

class CGLIBDynamicProxy implements MethodInterceptor {

    private Object targetObject;

    public Object createProxyObject(Object obj) {
        this.targetObject = obj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(this);
        Object proxyObj = enhancer.create();
        // 返回代理对象
        return proxyObj;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before: "  + method.getName());
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("After: " + method.getName());
        return object;
    }
}

public class T_proxy {

    public static void main(String[] args) {
        JDKDynamicProxy jdkDynamicProxy = new JDKDynamicProxy();
        //JDK动态代理对象传入一个需要代理的对象 然后用需要代理的对象接收就OK啦
        UserManager userManagerJDK = (UserManager) jdkDynamicProxy.newProxy(new UserManagerImpl());
        userManagerJDK.addUser("tom", "root");
        userManagerJDK.addUser("jeck", "root");

        CGLIBDynamicProxy cglibDynamicProxy = new CGLIBDynamicProxy();
        UserManager userManagerCGLIB = (UserManager) cglibDynamicProxy.createProxyObject(new UserManagerImpl());
        userManagerCGLIB.addUser("li", "root");
    }
}
