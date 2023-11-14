public class Employee {
    int id;
    int age;
    char gender;
    String name;
    HomeTown homeTown;

    Employee(int id, int age, char gender, String name, HomeTown homeTown) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.name = name;
        this.homeTown = homeTown;
    }

    public void printInfo() {
        System.out.println("員工編號: " + this.id + "\t" + "員工年齡: " + this.age + "\t" + "員工性別: " + this.gender + "\t員工姓名: " + this.name );
        System.out.println("城市: " + this.homeTown.city + "\t省份: " + this.homeTown.state + "\t國別: " + this.homeTown.country);
    }
}
