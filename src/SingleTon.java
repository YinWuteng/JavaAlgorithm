/**
 * 创建人：yinwuteng
 * 创建时间：2019/2/21
 * 版本号：1.0.1
 * 描述：单例模式
 * 设计文档：
 */


public class SingleTon {

    /**
     * 俄汉式 ,避免了多线程的同步问题，在类加载的时候就完成实例化，没有达到懒加载的效果，如果始终未使用这个实例，或造成内存的浪费
     */
//    private SingleTon() {
//    }
//
//    private static SingleTon instance = new SingleTon();
//
//    public static SingleTon getInstance() {
//        return instance;
//    }

    /**
     * 懒汉式(线程不安全)声明一个静态对象，在用户第一次调用时初始化
     */
//    private static SingleTon instance;
//
//    private SingleTon() {
//    }
//
//    public static SingleTon getInstance() {
//        if (instance == null) {
//            instance = new SingleTon();
//        }
//        return instance;
//    }
    /**
     * 懒汉式（线程安全）,在多线程中很好工作，但是每次调用getInstance都需要进行同步，
     * 造成不必要同步开销
     */

//    private static SingleTon instance;
//    private SingleTon(){}
//    public  static synchronized  SingleTon getInstance(){
//        if (instance==null){
//            instance=new SingleTon();
//        }
//        return instance;
//    }

    /**
     * 静态内部类(不仅能保证线程安全，还能保证Singleton的唯一性)
     */
    private SingleTon() {
    }

    public static SingleTon getInstance() {
        return SingletonHolder.sInstance;
    }

    private static class SingletonHolder {
        private static final SingleTon sInstance = new SingleTon();
    }


}





