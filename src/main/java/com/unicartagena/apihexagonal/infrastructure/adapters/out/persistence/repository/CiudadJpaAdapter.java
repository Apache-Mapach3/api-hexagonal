package com.unicartagena.apihexagonal.infrastructure.adapters.out.persistence.repository;

import com.unicartagena.apihexagonal.domain.model.Ciudad;
import com.unicartagena.apihexagonal.domain.ports.CiudadRepository;
import com.unicartagena.apihexagonal.infrastructure.adapters.out.persistence.entity.CiudadEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

interface CiudadSpringDataRepository extends JpaRepository<CiudadEntity, Long> {
    List<CiudadEntity> findByClima(String clima);
    List<CiudadEntity> findByPaisPertenece(String paisPertenece);
}

@Component
@RequiredArgsConstructor
public class CiudadJpaAdapter implements CiudadRepository {

    private final CiudadSpringDataRepository repository;

    @Override
    public Ciudad save(Ciudad ciudad) {
        CiudadEntity entity = new CiudadEntity(ciudad.getId(), ciudad.getNombre(), ciudad.getPaisPertenece(), ciudad.getAlcalde(), ciudad.getClima());
        CiudadEntity saved = repository.save(entity);
        return new Ciudad(saved.getId(), saved.getNombre(), saved.getPaisPertenece(), saved.getAlcalde(), saved.getClima());
    }

    @Override
    public Optional<Ciudad> findById(Long id) {
        return repository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Ciudad> findAll() {
        return repository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Ciudad> findByClima(String clima) {
        return repository.findByClima(clima).stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Ciudad> findByPaisPertenece(String pais) {
        return repository.findByPaisPertenece(pais).stream().map(this::toDomain).collect(Collectors.toList());
    }

    private Ciudad toDomain(CiudadEntity entity) {
        return new Ciudad(entity.getId(), entity.getNombre(), entity.getPaisPertenece(), entity.getAlcalde(), entity.getClima());
    }
}