package institucionAcademica.dao;

import institucionAcademica.dto.InstitucionAcademica;

import java.util.List;

public class FacadeInstitucionAcademica {
InstitucionAcademicaDAO institucionAcademicaDAO = new InstitucionAcademicaDAO();


    public List<InstitucionAcademica> obtenerTodasInstituciones() {
        return institucionAcademicaDAO.obtenerTodas();
    }
    public int agregar(InstitucionAcademica institucionAcademica) {
        return institucionAcademicaDAO.agregar(institucionAcademica);
    }
    public int modificar(InstitucionAcademica institucionAcademica) {
        return institucionAcademicaDAO.modificar(institucionAcademica);
    }
    public int eliminar(String idInstitucion) {
        return institucionAcademicaDAO.eliminar(idInstitucion);
    }
}