package guru.qa.lesson_java_1.homework;

public class MainPerson {

    public static void main(String[] args) {
        Person ivan = new Person("Ivan", "Petrov", "Petrovich", 25, Sex.MAN);
        System.out.println("Before:" + ivan);
        ivan.changeSex();
        System.out.println("After:" + ivan);
    }
}
