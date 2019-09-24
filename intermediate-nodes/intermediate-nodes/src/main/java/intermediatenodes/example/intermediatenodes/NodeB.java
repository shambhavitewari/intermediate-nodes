package intermediatenodes.example.intermediatenodes;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class NodeB {

    final int longi = 80;
    final int lat = 90;

    public int max =10;
    LinkedHashMap<String,List<String>> hash_mapB = new LinkedHashMap<String,List<String>>(max+1,0.75f,true)
    {
        @Override
        public boolean removeEldestEntry(Map.Entry<String,List<String>> eldest) {
            return size()>max;
        }
    };

    public void mapAdd (String tech, List<String> fname)
    {

        hash_mapB.put(tech, fname);
    }

    public List<String> mapGet (String tech){

        return hash_mapB.get(tech);

    }

}
