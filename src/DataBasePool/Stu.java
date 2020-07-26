package DataBasePool;

public class Stu {
    private String name;
    private int sid;
    private int age;
    private String gender;

    public Stu(int sid, String name, int age, String gender) {
        this.name = name;
        this.sid = sid;
        this.age = age;
        this.gender = gender;
    }

    public Stu() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
