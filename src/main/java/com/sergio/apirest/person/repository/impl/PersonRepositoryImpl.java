package com.sergio.apirest.person.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sergio.apirest.person.dto.Person;
import com.sergio.apirest.person.repository.PersonRepository;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
    @Autowired
    private JdbcTemplate template;

    private Connection getConexion() {
        Connection conexion = null;
        try {
            conexion = template.getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexion;
    }

    @Override
    public void createPersona(Person person) {
        Connection conexion = getConexion();
        PreparedStatement sentencia;
        try {
            sentencia = conexion.prepareStatement(
                    "insert into person (cantidad, descripcion, importe, precio_unitario) values (?,?,?,?)");
            sentencia.setInt(1, person.getCantidad());
            sentencia.setString(2, person.getDescripcion());
            sentencia.setDouble(3, person.getImporte());
            sentencia.setDouble(4, person.getPrecioUnitario());
            sentencia.execute();
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public List<Person> getAllPersons() {
        List<Person> lista=new ArrayList<>();
        Connection conexion = getConexion();
        PreparedStatement sentencia;
        try {
            sentencia = conexion.prepareStatement(
                    "select id,cantidad,descripcion,importe,precio_unitario from person");
            ResultSet resultado= sentencia.executeQuery();
            while(resultado.next()){
                Person persona=new Person();
                persona.setId(resultado.getInt("id"));
                persona.setCantidad(resultado.getInt("cantidad"));
                persona.setDescripcion(resultado.getString("descripcion"));
                persona.setImporte(resultado.getDouble("importe"));
                persona.setPrecioUnitario(resultado.getDouble("precio_unitario"));
                lista.add(persona);
            }
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return lista;

    }

    @Override
    public Person getPersonById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPersonById'");
    }

    @Override
    public void updatePerson(Integer id, Person person) {
        Connection conexion = getConexion();
        PreparedStatement sentencia;
        try {
            sentencia = conexion.prepareStatement(
                    "update person set cantidad=?, descripcion=?, importe=?, precio_unitario=? where id=?");
            sentencia.setInt(1, person.getCantidad());
            sentencia.setString(2, person.getDescripcion());
            sentencia.setDouble(3, person.getImporte());
            sentencia.setDouble(4, person.getPrecioUnitario());
            sentencia.setInt(5, id);
            sentencia.execute();
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void deletePerson(Integer id) {
        Connection conexion = getConexion();
        PreparedStatement sentencia;
        try {
            sentencia = conexion.prepareStatement(
                    "delete from person where id=?");
            sentencia.setInt(1, id);
            sentencia.execute();
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
