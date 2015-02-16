package br.com.mixersoundguide.listas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> contaBaixoAcustico = new ArrayList<String>();
        contaBaixoAcustico.add("Frequência: 32 Hz");
        contaBaixoAcustico.add("Frequência: 40 Hz");
        contaBaixoAcustico.add("Frequência: 50 Hz");
        contaBaixoAcustico.add("Frequência: 60 Hz");

        List<String> piano = new ArrayList<String>();
        piano.add("Frequência: 32 Hz");
        piano.add("Frequência: 40 Hz");
        piano.add("Frequência: 50 Hz");
        piano.add("Frequência: 60 Hz");
        
        expandableListDetail.put("CONTRA BAIXO ACÚSTICO", contaBaixoAcustico);
        expandableListDetail.put("PIANO", piano);
        return expandableListDetail;
    }
}
