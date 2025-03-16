package marcos.ad.Ejercicios_Spring;

import org.springframework.stereotype.Service;

@Service
public class CocheServide {
    private CocheRepository cocheRepository;

    Coche coche1 = new Coche(1L, "Seat","Ibiza",2002);

    public void saveCoche(Coche coche){
        cocheRepository.save(coche);
    }

}
