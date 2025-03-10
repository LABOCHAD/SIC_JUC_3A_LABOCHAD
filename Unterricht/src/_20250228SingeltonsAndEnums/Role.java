package _20250228SingeltonsAndEnums;
//• Erstellt einen Enum Role mit folgenden Eigenschaften:
//• name : String
//• accessRights : int (accessRights-Skala: 0 keine – 3 höchste)
//• Es sollen folgende Rollen geben:
//• Admin
//• CEO
//• Employee
//• Guest
//• Welche Rolle soll welche Zugriffsrechte haben?
public enum Role {
    GUEST("Guest", 0),
    EMPLOYEE("Employee", 1),
    ADMIN("Admin", 2),
    CEO("CEO", 3);

    private final String name;
    private final int accessRight;

    Role(String name, int accessRight) {
        if (accessRight > 3 || accessRight < 0) {
            throw new IllegalArgumentException("Access Right must be between 0 and 3");
        }
        this.name = name;
        this.accessRight = accessRight;
    }

}
