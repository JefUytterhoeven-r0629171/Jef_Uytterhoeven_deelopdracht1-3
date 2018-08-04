package db;


import domain.Uitgaven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UitgavenRepositoryStub {

    private ArrayList<Uitgaven> uitgavenmap = new ArrayList();
    public UitgavenRepositoryStub() {
        Uitgaven uitgaven = new Uitgaven("kris" , "400" , "15/08/1975");
        add(uitgaven);
        uitgaven = new Uitgaven("marie" , "200" , "1/10/2005");
        add(uitgaven);
    }
    public List<Uitgaven> getAll(){
        return uitgavenmap;
    }

    public void add(Uitgaven uitgaven){{
        uitgavenmap.add(uitgaven);
    }}
}
