package intermediatenodes.example.intermediatenodes;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private int userid;
    private String fname;
    private String tech;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }


    public String getSkill() {
        return tech;
    }

    public void setSkill(String l) {
        this.tech = tech;
    }

    @Override
    public String toString() {
        return "user{" +
                "userid=" + userid +
                ", fname='" + fname + '\'' +
                ", skill='" + tech + '\'' +
                '}';
    }

}

