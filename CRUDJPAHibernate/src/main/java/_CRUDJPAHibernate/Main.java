package _CRUDJPAHibernate;

import java.sql.Date;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
	
	public static Student createStudent(EntityManager em, String firstName, String lastName, Date dob, char gender, Classes cls) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setDob(dob);
        student.setGender(gender);
        student.setClasses(cls);
        em.persist(student);
        return student;
    }
	
	public static Classes createClass(EntityManager em, String className, char section) {
        Classes cls = new Classes();
        cls.setClassName(className);
        cls.setSection(section);
//        cls.getStudent().add(student);
        em.persist(cls);
        return cls;
    }
	
	public static void createTeacher(EntityManager em, String teacherName, char gender, String phoneNo, Classes cls, Subject sub) {
        Teacher teacher = new Teacher();
        teacher.setTeacherName(teacherName);
        teacher.setGender(gender);
        teacher.setPhoneNo(phoneNo);
        teacher.getClasses().add(cls);
        teacher.getSubjects().add(sub);
        cls.getTeachers().add(teacher);
        sub.getTeachers().add(teacher);
        em.persist(teacher);
    }
	
	public static Subject createSubjects(EntityManager entityManager, String subjectName) {
            Subject sub = new Subject();
            sub.setSubjectName(subjectName);
            entityManager.persist(sub);
            return sub;
        
    }
	

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            //Classes cls = createClass(entityManager, "Grade-10", 'A');
            
            //Student student = createStudent(entityManager, "Janagan", "Rangadurai", Date.valueOf("2024-06-26"), 'M',cls);
            
            //Student stu = createStudent(entityManager, "Harsha", "M", Date.valueOf("2024-12-30"), 'M', cls);
            
            //cls.getStudent().add(student);
            
            //cls.getStudent().add(stu);
            
//            Subject sub = createSubjects(entityManager,"Mathmetics");
            Subject eng = createSubjects(entityManager,"English");
            Subject bio = createSubjects(entityManager,"Biology");
            Subject phy = createSubjects(entityManager,"Physics");
            Subject che = createSubjects(entityManager,"Chemistry");
            Subject his = createSubjects(entityManager,"History");
            Subject geo = createSubjects(entityManager,"Geography");
            
            
            //createTeacher(entityManager, "xyz", 'F', "+91 9876543210", cls,sub);
            
            //createTeacher(entityManager, "abc", 'F', "+91 9876543000", cls,sub);
            
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
		
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		entityManager.getTransaction().begin();
//		
//		Student student = new Student();
//		student.setFirstName("Janagan");
//		student.setLastName("Rangadurai");
//		student.setDob(Date.valueOf("2024-06-26"));
//		student.setGender('M');
//		entityManager.persist(student);
//		
//		Classes cls = new Classes();
//		cls.setClassName("Grade-10");
//		cls.setSection('A');
//		cls.getStudent().add(student);
//		entityManager.persist(cls);
//		
//		Teacher teacher = new Teacher();
//		teacher.setTeacherName("xyz");
//		teacher.setGender('F');
//		teacher.setPhoneNo("+91 9876543210");
//		teacher.getClasses().add(cls);
//		
//		Subject maths = new Subject();
//        maths.setSubjectName("Mathmetics");
//        entityManager.persist(maths);
//
//        Subject eng = new Subject();
//        eng.setSubjectName("English");
//        entityManager.persist(eng);
//
//        Subject phy = new Subject();
//        phy.setSubjectName("Physics");
//        entityManager.persist(phy);
//
//        Subject che = new Subject();
//        che.setSubjectName("Chemistry");
//        entityManager.persist(che);
//
//        Subject bio = new Subject();
//        bio.setSubjectName("Biology");
//        entityManager.persist(bio);
//		
//		
//		entityManager.getTransaction().commit();
//		
//		entityManager.close();
//		entityManagerFactory.close();
		

	}

}