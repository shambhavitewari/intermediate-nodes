package intermediatenodes.example.intermediatenodes;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class NodeC {

    final int longi = 100;
    final int lat = 60;

    public int max =10;
    LinkedHashMap<String,List<String>> hash_mapC = new LinkedHashMap<String,List<String>>(max+1,0.75f,true)
    {
        @Override
        public boolean removeEldestEntry(Map.Entry<String,List<String>> eldest) {
            return size()>max;
        }
    };

    public void mapAdd (String tech, List<String> fname)
    {

        hash_mapC.put(tech, fname);
    }

    public List<String> mapGet (String tech){

        return hash_mapC.get(tech);

    }

}
