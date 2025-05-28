package cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Service;

import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Repository.UserManagerRepository;
import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Repository.Entity.UserManagerEntity;
import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Service.Domain.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserManagerService {
    @Autowired private UserManagerRepository repository;

    public List<UserManager> getUsers(){
        List<UserManagerEntity> users = repository.getAllUsers();
        List<UserManager> auxed = new ArrayList<>();
        for (UserManagerEntity user : users){
            auxed.add(
                    new UserManager(
                        user.getUserId()
                            ,user.getUserName()
                            ,user.getPassword()
                            ,user.getEmailUser()
                            ,user.getRole()
                            ,user.isActive()));
        }return auxed;
    }

    public UserManager getUserId(int userId){
        List<UserManager> users = getUsers();
        for (UserManager user : users){
            if(user.getUserId() == userId){
                return user;
            }
        }
        return null;
    }

    public boolean save(UserManager user) {
        UserManagerEntity found = repository.getUserByName(user.getUserName());

        if (found != null) {
            return false;
        }

        repository.save(
                new UserManagerEntity(
                        user.getUserId(),
                        user.getUserName(),
                        user.getPassword(),
                        user.getEmailUser(),
                        user.getRole(),
                        user.getIsActive()
                )
        );
        return true; // Indica que el guardado
    }

    public boolean replace(int id, UserManager newUser){
        UserManagerEntity found = null;
        List<UserManagerEntity> users = repository.getAllUsers();
        for (UserManagerEntity user : users){
            if (user.getUserId() == id){
                found = user;
            }
        }
        if(found != null){
            repository.replace(
                found,
                    new UserManagerEntity(
                            newUser.getUserId()
                            ,newUser.getUserName()
                            ,newUser.getPassword()
                            ,newUser.getEmailUser()
                            ,newUser.getRole()
                            ,newUser.getIsActive()));
            return true;
        }
        return false;
    }

    public boolean delete(int id){
        UserManagerEntity found = null;
        List<UserManagerEntity> users = repository.getAllUsers();
        for (UserManagerEntity user: users){
            if(user.getUserId() == id){
                found = user;
            }
        }
        if  (found != null){
            repository.remove(found);
            return true;
        }
        return false;
    }
}
