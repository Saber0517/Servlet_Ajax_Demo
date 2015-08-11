package daoimpl;

import dao.CityDao;
import entity.CityEntity;
import util.DBConnectUtil;
import util.DBTableNameUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by WhiteSaber on 15/8/11.
 */
public class CityDaoImpl implements CityDao {
    private final static String tableName = (DBTableNameUtil.getTableNameMap()).get("CITIES");
    private Connection con = null;
    private PreparedStatement pst = null;

    public List<CityEntity> selectCity(String city) {
        List<CityEntity> CityEntityList = new LinkedList<CityEntity>();
        String sql = "select * from " + tableName+" WHERE CITY LIKE"+"'%"+city+"%'";

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBConnectUtil.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                CityEntity cityEntity = new CityEntity();
                cityEntity.setId(rs.getString("ID"));
                cityEntity.setCity(rs.getString("CITY"));
                cityEntity.setCityId(rs.getString("CITYID"));
                cityEntity.setProvinceId(rs.getString("PROVINCEID"));
                CityEntityList.add(cityEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectUtil.free(con, pst, rs);
        }

        return CityEntityList;
    }
}
