package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * ????????????????????????????????????db_table_name.properties,?????????
 * Created by ZHANGJA4 on 8/5/2015.
 */
public class DBTableNameUtil {
    private static Map<String, String> tableNameMap = new HashMap<String, String>();

    static {
        InputStream inputStream = DBConnectUtil.class.getClassLoader().getResourceAsStream("db_table_name.properties");
        Properties p = new Properties();
        try {
            p.load(inputStream);
            for (Object keyName:p.keySet()){
                tableNameMap.put((String)keyName,(String)p.get(keyName));

            }
            /*tableNameMap.put("UserEntity", p.get("UserEntity").toString());
            tableNameMap.put("FoodEntity", p.get("FoodEntity").toString());
            tableNameMap.put("PackageFoddEntity", p.get("PackageFoddEntity").toString());
            tableNameMap.put("FoodRealatePackageEntity", p.get("FoodRealatePackageEntity").toString());
            tableNameMap.put("StatusEntity", p.get("StatusEntity").toString());
            */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> getTableNameMap() {
        return tableNameMap;
    }

}
