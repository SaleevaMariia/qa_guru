package guru.qa.lesson_java_1.homework;

import static guru.qa.lesson_java_1.homework.Sex.MAN;
import static guru.qa.lesson_java_1.homework.Sex.WOMAN;

public class Person {

    private String firstName;
    private String surname;
    private String secondName;
    private int age;
    private Sex sex;

    public Person(String firstName, String surname, String secondName, int age, Sex sex) {
        this.firstName = firstName;
        this.surname = surname;
        this.secondName = secondName;
        this.age = age;
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void changeSex(){
        if(this.sex == MAN){
            this.sex = WOMAN;
        }else{
            this.sex = MAN;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
