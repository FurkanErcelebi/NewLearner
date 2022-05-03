package JSONExample;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.USE_DEFAULTS)
public class StudentOne {

    public int id;
    public String name;

/*     StuentOne(int id,String name){
        this.id = id;
        this.name = name;
    } */

}
