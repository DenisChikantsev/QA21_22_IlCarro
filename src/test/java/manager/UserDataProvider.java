package manager;

import models.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserDataProvider {

    public Iterator<Object[]> userValidLogin(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                new User().setEmail("marga@gmail.com").setPassword("Mmar123456$")
        });
        return list.iterator();
    }

    public Iterator<Object[]> userWrongEmail(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                new User().setPassword("Mmar123456$").setEmail("margagmail.com")
        });

        return list.iterator();
    }

    public Iterator<Object[]> userWrongPassword(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                new User().setPassword("MMar123").setEmail("marga@gmail.com")
        });

        return list.iterator();
    }

    public Iterator<Object[]> userUnregistered(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                new User().setPassword("MMM$1234567").setEmail("mmm@gmail.com")
        });
        list.add(new Object[]{
                new User().setPassword("Bla$1234567").setEmail("blablabla@gmail.com")
        });

        return list.iterator();
    }
}
