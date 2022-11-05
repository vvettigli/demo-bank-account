package com.example.numeri_fibonacci.numeriDiFibonacci;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class NumeriDiFibonacci {

    public List<Integer> numeriDiFibonacci(int ripetizioni) {
//cambiare facendo fare il for dentro il controller, cambiare facendo invece di un array una lista e poi stamparla
        List<Integer> lista = new ArrayList<Integer>();
        lista.add(0,0);
        lista.add(1,1);
        int x = 0;
        int y = 1;
        int z = 2;
        for (int i = 0; i <= ripetizioni-3; i++) {

            lista.add(z, lista.get(x)+lista.get(y));
            x++;
            y++;
            z++;
        }
        return lista;
    }
    
}
