package cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Repository;

import org.springframework.stereotype.Repository;
import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Repository.Entity.ClientManagerEntity;
import java.util.List;
import java.util.ArrayList;

@Repository
public class ClientManagerRepository {
    List<ClientManagerEntity> clients;

    public List<ClientManagerEntity> getClients() {
        return clients;
    }

    // a diferencia de users, clientes no tiene roles
    public ClientManagerRepository(){
        clients = new ArrayList<>();
        clients.add(new ClientManagerEntity(15, "Cliente Test", "Test 1","test_email@1.1","null",932532183,true));
        // Unico cliente en la lista como ejemplo
    }

    public void clientReplace(ClientManagerEntity foundClient, ClientManagerEntity newClient){
        int i = clients.indexOf(foundClient);
        newClient.setClientId((foundClient.getClientId()));
        clients.set(i,newClient);
    }

    public void removeClient(ClientManagerEntity foundClient){
        clients.remove(foundClient);
    }

    public ClientManagerEntity getUserByOnlyName(String clientName){
        for (ClientManagerEntity client : clients){
            if(client.getClientName().equals(clientName)){
                return client;
            }
        }return null; // solucionar
    }

    public void clientSave(ClientManagerEntity saveClient){
        saveClient.setClientId((clients.size() + 1) * 10 + 5); // para diferenciarlo con USERS.
        clients.add(saveClient);
    }
}
