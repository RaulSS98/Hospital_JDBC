package org.jesuitasrioja;

import org.jesuitasrioja.dao.DoctorDAOImpl;
import org.jesuitasrioja.models.Doctor;
import org.jesuitasrioja.utils.DatabaseConnection;


public class App 
{
    public static void main( String[] args )
    {

        DatabaseConnection.getConnection();

        DoctorDAOImpl ddi = new DoctorDAOImpl();

        System.out.println(ddi.getDoctor(2));

        System.out.println(ddi.getDoctors());

        Doctor d = new Doctor(9,"Rodrigo", "Saenz", "12323236P", 1094, "pediatria");

        ddi.add(d);

    }
}
