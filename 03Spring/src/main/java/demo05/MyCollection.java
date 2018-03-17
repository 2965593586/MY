package demo05;


import java.util.*;

/**
 * Created by mycom on 2018/3/5.
 */
public class MyCollection {
    private String[] array;
    private List<String> list;
    private Set<String> set;
    private Map<String,String> map;
    private Properties properties;

    public MyCollection() {
        System.out.println("创建对象===========");
    }

    public MyCollection(String[] array, List<String> list, Set<String> set, Map<String, String> map, Properties properties) {
        this.array = array;
        this.list = list;
        this.set = set;
        this.map = map;
        this.properties = properties;
    }

  /*  @Override
    public String toString() {
        return "MyCollection{" +
                "array=" + Arrays.toString(array) +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }*/

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
