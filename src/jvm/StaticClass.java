package jvm;

/**
 * Script Created by daidai on 2017/8/18.
 */
public class StaticClass {
    public static long date = System.currentTimeMillis();//1
    public int da = 1;//3,5

    static {
        System.out.println("StaticClass:" + System.currentTimeMillis());//2
    }

    public StaticClass() {
        System.out.println(System.currentTimeMillis());//4,6
    }

    static class st {
        public static long date = System.currentTimeMillis();//8
    }

    public long getDate() {
        return st.date;//7,9
    }

    public static void main(String[] args) {
        StaticClass t = new StaticClass();
        StaticClass t1 = new StaticClass();
        System.out.println(t.getDate());
        System.out.println(t1.getDate());
    }
}
