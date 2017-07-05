import Models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Burak Köken on 5.7.2017.
 */
public class HibernateTest {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "select E.id, E.name from Employee as E";
        Query query = session.createQuery(hql);
        List resultList = query.list();

        System.out.println("result list size : " + resultList.size());

        for (Object object : resultList) {
            Object[] fields = (Object[]) object;
            System.out.println("id : " + fields[0] + ", name : " + fields[1]);
        }

    }
}
