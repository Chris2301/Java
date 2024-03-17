package nl.kick.javaspringapi.service;

import nl.kick.javaspringapi.model.Office;

public interface OfficeService {


    Office getOfficeById(Long id) throws Exception;
}
