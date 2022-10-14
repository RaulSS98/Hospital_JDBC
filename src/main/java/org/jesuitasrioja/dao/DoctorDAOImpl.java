package org.jesuitasrioja.dao;


import org.jesuitasrioja.idao.DoctorDAO;
import org.jesuitasrioja.models.Doctor;
import org.jesuitasrioja.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DoctorDAOImpl implements DoctorDAO {


    @Override
    public Doctor add(Doctor emp) {

        String query = "insert into Doctor (name, lastname, dni, salary, speciality) values (?, ?, ?, ?, ?);";
        Integer resultado = null;


        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            {
                ps.setString(1, emp.getName());
                ps.setString(2, emp.getLastname());
                ps.setString(3, emp.getDni());
                ps.setDouble(4, emp.getSalary());
                ps.setString(5, emp.getSpeciality());

                resultado = ps.executeUpdate();


            }

        } catch (SQLException sqlE) {

            sqlE.printStackTrace();
        }

        if (resultado > 0) {
            return emp;
        } else {
            return null;
        }

    }


    @Override
    public void delete(int id) {



    }

    @Override
    public Doctor getDoctor(int id) {

        String query = "select * from Doctor where id= ?";
        PreparedStatement ps = null;
        boolean check = false;
        Doctor doctor = new Doctor();
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                check = true;
                doctor.setId(rs.getInt("id"));
                doctor.setDni(rs.getString("dni"));
                doctor.setLastname(rs.getString("lastname"));
                doctor.setName(rs.getString("name"));
                doctor.setSalary(rs.getDouble("salary"));
                doctor.setSpeciality(rs.getString("speciality"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (check == true) {
            return doctor;
        } else
            return null;
    }

    @Override
    public List<Doctor> getDoctors() {
        String query = "select * from Doctor";
        PreparedStatement ps = null;
        boolean check = false;
        List<Doctor> salida = new ArrayList<>();
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {//para cada fila
                Doctor doctor = new Doctor();
                check = true;
                doctor.setId(rs.getInt("id"));
                doctor.setDni(rs.getString("dni"));
                doctor.setLastname(rs.getString("lastname"));
                doctor.setName(rs.getString("name"));
                doctor.setSalary(rs.getDouble("salary"));
                doctor.setSpeciality(rs.getString("speciality"));

                salida.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (check == true) {
            return salida;
        } else
            return null;

    }

    @Override
    public boolean update(Doctor emp) {
        return true;
/*
        Connection con = null;

        if (ifExitsDoctor(emp.getId())) {
            String query = "UPDATE `doctors` SET`name`=?,`lastname`=?,`dni`=?,`salary`=?,`speciality`=?WHERE id =?";
            PreparedStatement ps = null;
            int rs = 0;
            try {
                ps = con.prepareStatement(query);
                ps.setString(1, emp.getName());
                ps.setString(2, emp.getLastname());
                ps.setString(3, emp.getDni());
                ps.setDouble(4, emp.getSalary());
                ps.setString(5, emp.getSpeciality());
                ps.setInt(6, emp.getId());

                rs = ps.executeUpdate();


            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (rs > 0) {
                return true;
            }
        }
        return false;
        */

    }
}

