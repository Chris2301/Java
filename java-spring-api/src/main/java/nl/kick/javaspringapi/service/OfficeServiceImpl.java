package nl.kick.javaspringapi.service;

import nl.kick.javaspringapi.model.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficeServiceImpl implements OfficeService {

    @Autowired
    private OfficeRepository repository;
    @Override
    public Office getOfficeById(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("This office cannot be Found"));
    }
}
