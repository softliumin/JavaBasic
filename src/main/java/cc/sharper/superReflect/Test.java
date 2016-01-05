package cc.sharper.superReflect;

/**
 * Created by liumin3 on 2016/1/4.
 */
public class Test
{
    public static void main(String[] args)
    {
        Inter in = new Inter();

        Intercepts inter =  in.getClass().getAnnotation(Intercepts.class);

        Signature[] si = inter.value();

        for(Signature ss:si)
        {
            System.out.println(ss.method());
            System.out.println(ss.args());
            System.out.println(ss.type());
        }

    }
}
