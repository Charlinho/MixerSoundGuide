package br.com.mixersoundguide.listas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> contaBaixoAcustico = new ArrayList<String>();
        contaBaixoAcustico.add("Frequ�ncia: 32 Hz");
        contaBaixoAcustico.add("Frequ�ncia: 40 Hz");
        contaBaixoAcustico.add("Frequ�ncia: 50 Hz");
        contaBaixoAcustico.add("Frequ�ncia: 60 Hz");

        List<String> piano = new ArrayList<String>();
        piano.add("Frequ�ncia: 32 Hz");
        piano.add("Frequ�ncia: 40 Hz");
        piano.add("Frequ�ncia: 50 Hz");
        piano.add("Frequ�ncia: 60 Hz");
        
        expandableListDetail.put("CONTRA BAIXO AC�STICO", contaBaixoAcustico);
        expandableListDetail.put("PIANO", piano);
        return expandableListDetail;
    }
}
