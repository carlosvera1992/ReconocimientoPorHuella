package institucionAcademica.dao;

import institucionAcademica.dto.InstitucionAcademica;

import java.util.List;

public class FacadeInstitucionAcademica {
InstitucionAcademicaDAO institucionAcademicaDAO = new InstitucionAcademicaDAO();


    public List<InstitucionAcademica> obtenerTodasInstituciones() {
        return institucionAcademicaDAO.obtenerTodas();
    }
}
