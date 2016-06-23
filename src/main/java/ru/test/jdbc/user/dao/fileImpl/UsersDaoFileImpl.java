package ru.test.jdbc.user.dao.fileImpl;

import ru.test.jdbc.user.dao.UsersDao;
import ru.test.jdbc.user.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SOTI on 25.05.2016.
 */
public class UsersDaoFileImpl implements UsersDao {
    String path;

    public UsersDaoFileImpl(String path){
        this.path = path;
    }
    public  UsersDaoFileImpl (){
        this.path ="C:/Users/SOTI/Mail.Ru/Документы/GitHub/Tokenizer";
    }

    private void save(List<User> users){
        for (User user :
                users) {
            File file = new File(path+"\\"+user.getName()+".user");

                try{
                    file.createNewFile();
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    writer.write(user.getName());
                    writer.newLine();
                    writer.write(user.getInfo());
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
    }

    public List<User> findAll() {

        ArrayList<User> users = new ArrayList<>();
        File tempfile=new File(path);
        tempfile.mkdirs();
        File[] files = tempfile.listFiles();
        for (File file:
             files) {
            if (file.getName().contains("user") && file.isFile()) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    //TODO fix
                    users.add(new User(reader.readLine(),reader.readLine(),reader.readLine(), (long) 0,0,false));
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return users;
    }

    @Override
    public List<User> findByName(String name) {
        return null;
    }

    @Override
    public String findNameById(Long id) {
        return null;
    }

    @Override
    public User findeUserById(Long id) {
        return null;
    }

    @Override
    public void insert(User user) {

    }

    @Override
    public void update(User user, Long id) {

    }


    @Override
    public void delete(User user) {

    }

    @Override
    public void delete(Long id) {

    }

    public void addUser(User user){
        List<User> users  = findAll();
        users.add(user);
        save(users);
    }
}
