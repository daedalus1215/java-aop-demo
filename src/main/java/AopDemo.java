import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.MetadataSources;

public class AopDemo {

    public static void main(String[] args) {


//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Configuration con = new Configuration().configure();
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        try {
            // create a student object
            System.out.println("Creating new student object...");
            Student studentDTO = new Student("JLANG", "lJANG", "paul@luv2code.com");
//
//			// start a transaction
            System.out.println("Starting a transaction...");
            session.beginTransaction();
//
//			// save the student object
            session.save(studentDTO);
            System.out.println("Creating new student object...");
            System.out.println("Saving the student...");
//
//			// commit transaction
//			System.out.println("Creating new student object...");
            session.getTransaction().commit();
            session.close();
            sf.close();
        } catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
        } finally {

        }
    }

}
