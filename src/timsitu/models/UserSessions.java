package timsitu.models;

public class UserSessions {
    private static String name = "null";
    private static User.EnumRole role = User.EnumRole.DOKTER;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        UserSessions.name = name;
    }

    public static User.EnumRole getRole() {
        return role;
    }

    public static void setRole(User.EnumRole role) {
        UserSessions.role = role;
    }
}
