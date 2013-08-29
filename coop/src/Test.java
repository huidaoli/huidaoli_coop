import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;


public class Test
{
    static class Student
    {
        
    }

    public static void main(String[] args)
    {
        Tss s = new Tss();
        s.setId(1);
        s.setName("ddddd");
        s.setS("ccccccccccc");
        BeanMap bean = new BeanMap(s);
        Map map = new HashMap();
        map.putAll(bean);
        System.out.println(map);
    }
}
