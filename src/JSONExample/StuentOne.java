package JSONExample;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.USE_DEFAULTS)
public class StuentOne {
    public int id;
    public String name;

    StuentOne(int id,String name){
        this.id = id;
        this.name = name;
    }

}
