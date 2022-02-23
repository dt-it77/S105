package nivell1_ex5;

import java.io.Serializable;

public class ObjectClass implements Serializable {
    
    public Integer id;
    public String value;


    public ObjectClass(Integer id, String val) {
        this.id = id;
        this.value = val;
    }
}