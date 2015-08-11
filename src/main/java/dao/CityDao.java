package dao;

import entity.CityEntity;

import java.util.List;

/**
 * Created by WhiteSaber on 15/8/11.
 */
public interface CityDao {
    public List<CityEntity> selectCity(String city);
}
