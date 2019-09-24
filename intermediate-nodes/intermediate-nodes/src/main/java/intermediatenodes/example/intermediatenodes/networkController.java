package intermediatenodes.example.intermediatenodes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class networkController {

    @Autowired
    private UserRepo repo;

    public NodeA nodeA = new NodeA();
    public NodeB nodeB = new NodeB();
    public NodeC nodeC = new NodeC();


    @GetMapping("/jpa/{tech}/users/{longiU}/{latU}")
    public List<String> retrievefromTech(@PathVariable String tech, @PathVariable int longiU,@PathVariable int latU) {

        double distNodeA = Math.sqrt((longiU-nodeA.longi)*(longiU-nodeA.longi)+(latU-nodeA.lat)*(latU-nodeA.lat));
        double distNodeB = Math.sqrt((longiU-nodeB.longi)*(longiU-nodeB.longi)+(latU-nodeB.lat)*(latU-nodeB.lat));
        double distNodeC = Math.sqrt((longiU-nodeC.longi)*(longiU-nodeC.longi)+(latU-nodeC.lat)*(latU-nodeC.lat));

        if (distNodeA<distNodeB && distNodeA <distNodeC)
        {
            System.out.println("nodeA is used. ");
            if(nodeA.hash_mapA.containsKey(tech))
            {
               // System.out.println("through hashmap");
                System.out.println("no. of elements in the hashmap ="+nodeA.hash_mapA.size());
                return nodeA.mapGet(tech);
            }


            else
            {
                List<User> lsUser = repo.findByTech(tech);
                List<String> lsFname = new ArrayList<String>();
                Iterator iteratorUser = lsUser.iterator();
                //ListIterator iteratorFname;
                while(iteratorUser.hasNext()) {
                    User user = (User) iteratorUser.next();
                    //System.out.println(user.getFname());
                    lsFname.add(user.getFname());
                }
                nodeA.hash_mapA.put(tech, lsFname);
                System.out.println(nodeA.mapGet(tech));
            }

            //cac.hash_map.put(tech,);
           // System.out.println("through repo");
            //System.out.println(cac.mapGet(tech));
            return nodeA.mapGet(tech);
            //return "working";
        }

        else if(distNodeB<distNodeC)
        {
            System.out.println("nodeB is used. ");

            if(nodeB.hash_mapB.containsKey(tech))
            {
                 System.out.println("through hashmap");
                System.out.println("no. of elements in the hashmap ="+nodeB.hash_mapB.size());
                return nodeB.mapGet(tech);
            }


            else
            {
                List<User> lsUser = repo.findByTech(tech);
                List<String> lsFname = new ArrayList<String>();
                Iterator iteratorUser = lsUser.iterator();
                //ListIterator iteratorFname;
                while(iteratorUser.hasNext()) {
                    User user = (User) iteratorUser.next();
                    //System.out.println(user.getFname());
                    lsFname.add(user.getFname());
                }
                nodeB.hash_mapB.put(tech, lsFname);
                System.out.println(nodeB.mapGet(tech));
                System.out.println("through repo");
            }

            //cac.hash_map.put(tech,);
            //System.out.println("through repo");
            //System.out.println(cac.mapGet(tech));
            return nodeB.mapGet(tech);
            //return "working";
        }

        else{

            System.out.println("nodeC is used. ");
            if(nodeC.hash_mapC.containsKey(tech))
            {
                // System.out.println("through hashmap");
                System.out.println("no. of elements in the hashmap ="+nodeC.hash_mapC.size());
                return nodeC.mapGet(tech);
            }


            else
            {
                List<User> lsUser = repo.findByTech(tech);
                List<String> lsFname = new ArrayList<String>();
                Iterator iteratorUser = lsUser.iterator();
                //ListIterator iteratorFname;
                while(iteratorUser.hasNext()) {
                    User user = (User) iteratorUser.next();
                    //System.out.println(user.getFname());
                    lsFname.add(user.getFname());
                }
                nodeC.hash_mapC.put(tech, lsFname);
                System.out.println(nodeC.mapGet(tech));
            }

            //cac.hash_map.put(tech,);
            // System.out.println("through repo");
            //System.out.println(cac.mapGet(tech));
            return nodeC.mapGet(tech);
            //return "working";
        }
        }

    }

