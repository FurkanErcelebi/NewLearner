package JSONExample;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestList {
    
    public List<StuentOne>  stuentOnes;

/*     public TestList(){

        this.stuentOnes = new ArrayList<>();

    }

    public void setStudentOnes(List<StuentOne>  list){
        this.stuentOnes = list;
    }
    
    public List<StuentOne> getStuentOnes(){
        return this.stuentOnes;
    } */

}
