package timsitu.models;

public class UserSessions {
    private static int userId;
    private static String name;
    private static User.EnumRole role;

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

    public static int getUserId() {
        return userId;
    }

    public static void setUserId(int userId) {
        UserSessions.userId = userId;
    }
}
