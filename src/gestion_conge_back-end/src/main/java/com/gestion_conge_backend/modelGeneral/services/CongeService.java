package com.gestion_conge_backend.modelGeneral.services;

import com.gestion_conge_backend.data.entities.CongeEntity;
import com.gestion_conge_backend.data.entities.ServicesEntity;
import com.gestion_conge_backend.data.repository.CongeRepository;
import com.gestion_conge_backend.data.repository.ServiceRepository;
import com.gestion_conge_backend.modelGeneral.dtos.Congedto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CongeService {
    private final CongeRepository congeRepository;
    public CongeService(CongeRepository congeRepository) {
        this.congeRepository = congeRepository;
    }

    public CongeEntity creer(CongeEntity congeEntity) {
        return congeRepository.save(congeEntity);
    }


    public List<Congedto> lire() {
        return congeRepository.findAll()  .stream()
                .map(m -> m.toConge(m))
                .collect(Collectors.toList());
    }


    public CongeEntity modifier(int id, CongeEntity conge) {
        return congeRepository.findById(id)
                .map(
                        e->{
                            e.setDateDebut(conge.getDateDebut());
                            e.setDateFin(conge.getDateFin());
                            e.setEmploiyee(conge.getEmploiyee());
                            e.setTypeConge(conge.getTypeConge());
                            return congeRepository.save(e);
                        }
                ).orElseThrow(()-> new RuntimeException("Conge non trouve"));
    }


    public String supprimer(int id) {
        congeRepository.deleteById(id);
        return "Service est supprimer avec succes";
    }
}
