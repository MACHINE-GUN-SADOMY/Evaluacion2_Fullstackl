package cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Service;

import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Service.Domain.ClientManager;
import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Repository.ClientManagerRepository;
import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Repository.Entity.ClientManagerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class ClientManagerService {
    @Autowired private ClientManagerRepository repository;

    public List<ClientManager> getClients() {
        List<ClientManagerEntity> clients = repository.getClients();
        List<ClientManager> clientAux = new ArrayList<>();
        for (ClientManagerEntity client : clients) {
            clientAux.add(new ClientManager(
                    client.getClientId()
                    ,client.getClientName()
                    ,client.getClientLastName()
                    ,client.getClientEmail()
                    ,client.getPassword()
                    ,client.getPhoneNumber()
                    ,client.isClientActive()));
        }return clientAux;
    }

    public boolean saveClient(ClientManager client) {
        ClientManagerEntity foundClient = repository.getUserByOnlyName(client.getClientName());
        if (foundClient != null) {
            return false;
        }

        repository.clientSave(
                new ClientManagerEntity(
                        client.getClientId()
                        ,client.getClientName()
                        ,client.getClientLastName()
                        , client.getClientEmail()
                        ,client.getPassword()
                        ,client.getPhoneNumber()
                        ,client.getClientActive())
        );
        return true;
    }

    public ClientManager getClientId(int clientId) {
        List<ClientManager> clients = getClients();
        for (ClientManager client : clients) {
            if (client.getClientId() == clientId) {
                return client;
            }
        }return null;
    }

    public boolean deleteClient(int clientId) {
        ClientManagerEntity foundClient = null;
        List<ClientManagerEntity> clients = repository.getClients();
        for (ClientManagerEntity client : clients) {
            if (client.getClientId() == clientId) {
                foundClient = client;
            }
        }if (foundClient != null) {
            repository.removeClient(foundClient);
            return true;
        }
        return false; // continuar
    }

    public boolean replaceClient(int clientId, ClientManager newClient) {
        ClientManagerEntity foundClient = null;
        List<ClientManagerEntity> clients = repository.getClients();
        for (ClientManagerEntity client : clients) {
            if (client.getClientId() == clientId) {
                foundClient = client;
            }
        }if (foundClient != null) {
            repository.clientReplace(
                    foundClient, new ClientManagerEntity(
                        newClient.getClientId()
                        ,newClient.getClientName()
                        ,newClient.getClientEmail()
                        ,newClient.getPassword()
                        ,newClient.getClientEmail()
                        ,newClient.getPhoneNumber()
                        ,newClient.getClientActive()));
            return true;
        }
        return false; // continuar
    }
}