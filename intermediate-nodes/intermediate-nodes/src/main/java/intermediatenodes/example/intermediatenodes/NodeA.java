package intermediatenodes.example.intermediatenodes;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class NodeA {

    final int longi = 50;
    final int lat = 70;

    public int max =10;
    LinkedHashMap<String,List<String>> hash_mapA = new LinkedHashMap<String,List<String>>(max+1,0.75f,true)
    {
        @Override
        public boolean removeEldestEntry(Map.Entry<String,List<String>> eldest) {
            return size()>max;
        }
    };

    public void mapAdd (String tech, List<String> fname)
    {

        hash_mapA.put(tech, fname);
    }

    public List<String> mapGet (String tech){

        return hash_mapA.get(tech);

    }

}
