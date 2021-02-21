package zham.example.database.dao;

import org.springframework.stereotype.Component;
import zham.example.database.models.Person;

import java.security.PrivateKey;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private static final String URL="jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME="postgres";
    private static final String PASSWORD="fuckdas26#l";

    private static Connection connection;
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Person> index() {
        List<Person> people=new ArrayList<>();

        try{
            Statement statement=connection.createStatement();
            String SQL = "SELECT * FROM \"Person_jdbc\"";
            ResultSet resultSet= statement.executeQuery(SQL);

            while(resultSet.next()){
                Person person=new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));

                people.add(person);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return people;
    }

//    public Person show(int id){
//        return people.stream().filter(person-> person.getId()==id).findAny().orElse(null);
//    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);

        try {
            Statement statement=connection.createStatement();
            String SQL = "INSERT INTO \"Person_jdbc\"(\n" +
                    "\tid, name, age, email)\n" +
                    "\tVALUES ("+3+", '"+person.getName()+"', "+person.getAge()+", '"+person.getEmail()+"');";
            statement.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //people.add(person);
    }

//    public void update(int id){
//        Person personToUpdate=show(id);
//        personToUpdate.setName("Mike");
//    }
}
