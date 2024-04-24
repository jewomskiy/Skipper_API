package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.DemandSkill;
import com.backend.tinkoff_backend.repositories.DemandSkillRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandSkillService {

    @Autowired
    DemandSkillRepository demandSkillRepository;

    public void createDemandSkill(DemandSkill demandSkill) {
        demandSkillRepository.save(new DemandSkill(demandSkill.getSkillId(), demandSkill.getDemandId()));
    }

    public DemandSkill getDemandSkillById(long demandSkillId) throws ServiceException {
        Optional<DemandSkill> demandSkillData = demandSkillRepository.findById(demandSkillId);

        if (demandSkillData.isPresent())
            return demandSkillData.get();
        throw new ServiceException("No such demandSkill");
    }

    public List<DemandSkill> getDemandSkillsByDemandId(long demandId) throws ServiceException {
        List<DemandSkill> demandSkills = demandSkillRepository.findAllByDemandId(demandId);

        if (demandSkills.isEmpty())
            throw new ServiceException("Do not need any skills in that demand");
        return demandSkills;
    }

    public List<DemandSkill> getDemandSkillsBySkillId(long skillId) throws ServiceException {
        List<DemandSkill> demandSkills = demandSkillRepository.findAllBySkillId(skillId);

        if (demandSkills.isEmpty())
            throw new ServiceException("This skill not involved in any demand");
        return demandSkills;
    }

    public List<DemandSkill> getAllDemandSKills() throws ServiceException {
        List<DemandSkill> demandSkills = demandSkillRepository.findAll();

        if (demandSkills.isEmpty())
            throw new ServiceException("No demandSkills");
        return demandSkills;
    }

    public DemandSkill updateDemandSkill(long demandSkillId, DemandSkill demandSkill) throws ServiceException {
        Optional<DemandSkill> demandSkillData = demandSkillRepository.findById(demandSkillId);

        if (demandSkillData.isPresent()) {
            DemandSkill _demandSkill = demandSkillData.get();
            _demandSkill.setDemandId(demandSkill.getDemandId());
            _demandSkill.setSkillId(demandSkill.getSkillId());
            return demandSkillRepository.save(_demandSkill);
        }
        throw new ServiceException("No such demandSkill");
    }

    public void deleteDemandSKill(long demandSkillId) throws ServiceException {
        Optional<DemandSkill> demandSkillData = demandSkillRepository.findById(demandSkillId);

        if (demandSkillData.isPresent()) {
            demandSkillRepository.deleteById(demandSkillId);
            return;
        }
        throw new ServiceException("No such demandSkill");
    }

    public void deleteAllDemandSkills() {
        demandSkillRepository.deleteAll();
    }
}