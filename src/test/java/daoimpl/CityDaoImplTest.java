package daoimpl;

import dao.CityDao;
import entity.CityEntity;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * Created by WhiteSaber on 15/8/11.
 */
public class CityDaoImplTest {
    @Test
    public void test(){
        CityDao cityDao = new CityDaoImpl();
        List<CityEntity> cityEntityList = cityDao.selectCity("海");
        TestCase.assertNotNull(cityEntityList);
        return;

    }
}
