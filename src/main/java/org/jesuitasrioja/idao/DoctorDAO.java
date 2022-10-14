package org.jesuitasrioja.idao;

import org.jesuitasrioja.models.Doctor;

import java.util.List;

public interface DoctorDAO {

    public Doctor add(Doctor emp);
    public void delete(int id);
    public Doctor getDoctor(int id);
    public List<Doctor> getDoctors();
    public boolean update(Doctor emp);

}
