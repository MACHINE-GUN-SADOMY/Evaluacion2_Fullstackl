package cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Service.Domain;

public class UserManager {
    private int userId;
    private String userName;
    private String password;
    private String emailUser;
    private boolean isActive;
    private String Role;

    public UserManager(int userId, String userName, String password,
                       String emailUser, String role , boolean isActive){
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.emailUser = emailUser;
        this.Role = role;
        this.isActive = isActive;
    }

    // GETTS ----
    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public String getRole() {
        return Role;
    }

    // --------- SETS ----------
    // Settear estado.
    public void setActive(boolean active) {
        this.isActive = active;
    }

    public void setUserId(String userId) {
        this.userId = Integer.parseInt(userId);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Terminado
}
