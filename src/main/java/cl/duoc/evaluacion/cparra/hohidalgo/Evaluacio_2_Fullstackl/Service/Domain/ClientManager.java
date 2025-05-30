package cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Service.Domain;

public class ClientManager{
    private int clientId;
    private String clientName;
    private String clientLastName;
    private String clientEmail;
    private String password;
    private int phoneNumber;
    private boolean clientActive;

    public ClientManager(int clientId, String clientName,
                         String clientLastName, String clientEmail,
                         String password, int phoneNumber, boolean clientActive) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientLastName = clientLastName;
        this.clientEmail = clientEmail;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.clientActive = clientActive;
    }

    //  GETS
    public int getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public String getPassword() {
        return password;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public boolean getClientActive() {
        return clientActive;
    }

    // SETTERS CLIENT
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setClientActive(boolean clientActive) {
        this.clientActive = clientActive;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }
}
