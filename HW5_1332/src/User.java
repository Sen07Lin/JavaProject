/**
 * This class describes a user. It implements Comparable<User>, which allows
 * compare user.
 * @author Sen
 * 
 */
public class User implements Comparable<User> {
    private String name;
    private String userName;
    /**
     * public constructor of the class user.
     * @param name real name of the user
     * @param userName userName of the user
     */
    public User(String userName, String name) {
        this.name = name;
        this.userName = userName.toLowerCase();
    }
    /**
     * The getter method for userName.
     * @return return the userName
     */
    public String getUserName() {
        return userName;
    }
    @Override
    public String toString() {
        return userName + "-" + name;
    }
    @Override
    public int compareTo(User o) {
        String otherUName = o.getUserName().toLowerCase();
        String thisUName = getUserName().toLowerCase();
        return thisUName.compareTo(otherUName);
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof User)) {
            return false;
        }
        if (o == this) {
            return true;
        }
        User that = (User) o;
        return this.getUserName().equals(that.getUserName());
    }
    /**
     * The hasCode method.
     * @return return the hasCode of a user
     */
    public int hasCode() {
        return getUserName().hashCode();
    }
}
