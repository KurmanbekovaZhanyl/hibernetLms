package homework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class App {
    public static void main( String[] args ) {
    Users [] users = new Users[6];
    users [0] =new Users("Aza",20);
    users [1] =new Users("Azat",30);
    users [2] =new Users("Aza",40);
    users [3] =new Users("Azamat",50);
    users [4] =new Users("Bekzat",60);
    users [5] =new Users("Aza",70);
        for (int i = 0; i < users.length ; i++) {
//        create(users[i]);
         //   getAza();
          //  changeAge("Aza",18);
            deleteName();
        }


    }
    public static void create (Users users) {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(users);
        session.getTransaction().commit();
        session.close();
        System.out.println("Our table is successfully created");
    }
    public static List<Users> getAza() {
     Session session = Util.getSessionFactory().openSession();
     session.beginTransaction();
     List <Users> list =
             session.createQuery("from Users where name ='Aza' and age > 20 ").getResultList();
     session.getTransaction().commit();
     session.close();
        System.out.println("Selected");
    return list;
    }
    public static void changeAge(String name, int age) {
    Session session =Util.getSessionFactory().openSession();
    session.beginTransaction();
    session.createQuery("update Users set age =:age where name =:name ").setParameter("name", name ).setParameter("age", age).executeUpdate();
    session.getTransaction().commit();
        System.out.println("Successfully updated ");
    session.close();
    }
    public static  void deleteName() {
    Session session =Util.getSessionFactory().openSession();
    session.beginTransaction();
    session.createQuery(" delete from Users where name  = 'Aza'").executeUpdate();
    session.getTransaction().commit();
        System.out.println("Successfully deleted");
    session.close();

    }


}
