package org.juancarlos.micro_contactos_securizado.dao;

import org.juancarlos.micro_contactos_securizado.model.Contacto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaDao extends JpaRepository<Contacto, Integer> {
    @Transactional
    @Modifying
    void deleteByEmail(String email);
    Contacto findByEmail(String email);
}
