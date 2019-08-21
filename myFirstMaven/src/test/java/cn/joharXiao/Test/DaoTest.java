package cn.joharXiao.Test;

import cn.joharxiao.dao.MavenTestDao;
import cn.joharxiao.dao.impl.MavenTestDaoImpl;
import cn.joharxiao.domain.MavenTest;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

public class DaoTest {
    @Test
    public void test1(){
        MavenTestDao dao =new MavenTestDaoImpl();
        List<MavenTest> lists=dao.showAll();
        Iterator<MavenTest> iterator=lists.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
