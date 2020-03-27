package eps.dao;

import conexionBD.ConexionRoot;
import eps.dto.DtoEps;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoEps {

    private DtoEps dtoeps;
    private List<DtoEps> dtoepss;

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rset;

    public List<DtoEps> cargarTipoEps() throws RuntimeException {

        try {
            conn = ConexionRoot.getConexion();
            String sql = "select * from eps";
            stmt = conn.prepareStatement(sql);//preparar consulta
            rset = stmt.executeQuery();//ejecutar la consulta y guardarla en la variabble rset

            dtoepss = new ArrayList<>();

            while (rset.next()) {
                dtoeps = new DtoEps();
                dtoeps.setIdEps(rset.getInt("idEps"));
                dtoeps.setNombreEps(rset.getString("nombreEps"));
                dtoeps.setdireccionEps(rset.getString("direccionEps"));
                dtoeps.settelEps(rset.getInt("telEps"));
                dtoepss.add(dtoeps);

            }


        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - obtenerTodos()!");
        }
        return dtoepss;
    }

    public void agregarEps(DtoEps dtoEps) throws RuntimeException {
        try {
            conn = ConexionRoot.getConexion();
            String sql = "insert into eps(idEps, nombreEps, direccionEps, telEps) values (?, ?, ?, ?)";

            stmt = conn.prepareStatement(sql);//compilo y paso parametros
            stmt.setInt(1, dtoEps.getIdEps());
            stmt.setString(2, dtoEps.getNombreEps());
            stmt.setString(3, dtoEps.getdireccionEps());
            stmt.setInt(4, dtoEps.gettelEps());

            int rta = stmt.executeUpdate();
            if (rta != 1) {
                throw new RuntimeException("Error al agregar!");
            }
        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException("Error SQL - Agregar()!");
        }
    }

    public DtoEps buscarPorId(int idEps) {
        try {
            conn = ConexionRoot.getConexion();
            String sql = "select * from eps where idEps = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idEps);
            rset = stmt.executeQuery();

            if (rset.next()) {

                dtoeps.settelEps(rset.getInt("idEps"));
                dtoeps.setNombreEps(rset.getString("nombreEps"));
                dtoeps.setdireccionEps(rset.getString("direccionEps"));
                dtoeps.settelEps(rset.getInt("telEps"));

            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException("Error SQL - obtenerPorId()!");
        }
        return dtoeps;
    }
}