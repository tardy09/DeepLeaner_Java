package Reflecton.lesson1;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.io.CharStreams;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2016/11/19.
 */
public class ObjectPool {
    private static ObjectPool OBJECTPOOL;
    // 创建一个对象池的实例(保证是多线程安全的)
    private static void initSingletonPool() {
        if (OBJECTPOOL == null) {
            synchronized (ObjectPool.class) {
                if (OBJECTPOOL == null) {
                    OBJECTPOOL = new ObjectPool(new ConcurrentHashMap<String, Object>());
                }
            }
        }
    }
    private Map<String,Object> pool;

    public ObjectPool(Map<String, Object> pool) {
        this.pool = pool;
    }
    private static Object getInstance(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return Class.forName(className).newInstance();
    }
    //根据配置文件来获取相应的JSONArray数组
    private static JSONArray getObjects(String config) throws IOException {
        Reader reader = new InputStreamReader(ClassLoader.getSystemResourceAsStream(config));
        return JSONObject.parseObject(CharStreams.toString(reader)).getJSONArray("objects");
    }
    private static Object getInstance(String className, JSONArray fields)
            throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InstantiationException, InvocationTargetException {

        // 配置的Class
        Class<?> clazz = Class.forName(className);
        // 目标Class的实例对象
        Object targetObject = clazz.newInstance();
        if (fields != null && fields.size() != 0) {
            for (int i = 0; i < fields.size(); ++i) {
                JSONObject field = fields.getJSONObject(i);
                // 需要设置的成员变量名
                String fieldName = field.getString("name");

                // 需要设置的成员变量的值
                Object fieldValue;
                if (field.containsKey("value")) {
                    fieldValue = field.get("value");
                } else if (field.containsKey("ref")) {
                    String refBeanId = field.getString("ref");
                    fieldValue = OBJECTPOOL.getObject(refBeanId);
                } else {
                    throw new RuntimeException("neither value nor ref");
                }

//                String setterName = "set" +
//                        fieldName.substring(0, 1).toUpperCase() +
//                        fieldName.substring(1);
                try {
                    PropertyDescriptor propertyDescriptor=new PropertyDescriptor(fieldName,clazz);
                    //setterMethod.invoke(targetObject, fieldValue);
                    Method  setterMethod=propertyDescriptor.getWriteMethod();
                    setterMethod.invoke(targetObject, fieldValue);
                } catch (IntrospectionException e) {
                    e.printStackTrace();
                }
                // 需要设置的成员变量的setter方法
                //Method setterMethod = clazz.getMethod(setterName, fieldValue.getClass());
                // 调用setter方法将值设置进去

            }
        }

        return targetObject;
    }
    // 根据指定的JSON配置文件来初始化对象池
    public static ObjectPool init(String config) {
        // 初始化pool
        initSingletonPool();
        try {
            JSONArray objects = getObjects(config);
            for (int i = 0; objects != null && i < objects.size(); ++i) {
                JSONObject object = objects.getJSONObject(i);
                if (object == null || object.size() == 0) {
                    continue;
                }
                String id = object.getString("id");
                String className = object.getString("class");

                // 初始化bean并放入池中
                OBJECTPOOL.putObject(id, getInstance(className, object.getJSONArray("fields")));
            }
            return OBJECTPOOL;
        } catch (IOException | ClassNotFoundException |
                InstantiationException | IllegalAccessException |
                NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    public <T> T getObject(String id) {
        return (T)pool.get(id);
    }

    public void putObject(String id, Object object) {
        pool.put(id, object);
    }

    public void clear() {
        pool.clear();
    }
}
