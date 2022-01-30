public class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.email = email;
        this.name = name;
    }

    public String greet() {
        return "Hello " + this.name + "!," + " your email is: " + this.email;
    }
}
