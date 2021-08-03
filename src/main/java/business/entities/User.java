package business.entities;

public class User
{

    public User(int id, String email, String name, int phone, String role, String password)
    {
        this.id = id;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.role = role;
    }

    public User(String email, String password, String role, String name)
    {
        this.email = email;
        this.password = password;
        this.role = role;
        this.name = name;
    }

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private String name;
    private int phone;
    private String role;
    private String password; // Should be hashed and secured

    public String getName() { return name; }

    public int getPhone() { return phone; }

    public void setName(String name) { this.name = name; }

    public void setPhone(int phone) { this.phone = phone; }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

}
