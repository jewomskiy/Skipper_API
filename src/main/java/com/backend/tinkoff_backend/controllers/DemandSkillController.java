package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.DemandSkill;
import com.backend.tinkoff_backend.services.DemandSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemandSkillController {

    @Autowired
    DemandSkillService demandSkillService;

    @PostMapping("/demandSkills")
    public ResponseEntity<DemandSkill> createDemandSkill(@RequestBody DemandSkill demandSkill) {
        demandSkillService.createDemandSkill(demandSkill);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/demandSkills/{id}")
    public ResponseEntity<DemandSkill> getDemandSkillById(@PathVariable("id") long demandSkillId) {
        try {
            return new ResponseEntity<>(demandSkillService.getDemandSkillById(demandSkillId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/demandSkills/{demandId}")
    public ResponseEntity<List<DemandSkill>> getDemandSkillsByDemandId(@PathVariable("demandId") long demandId) {
        try {
            return new ResponseEntity<>(demandSkillService.getDemandSkillsByDemandId(demandId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/demandSkills/{skillId}")
    public ResponseEntity<List<DemandSkill>> getDemandSkillsBySkillId(@PathVariable("skillId") long skillId) {
        try {
            return new ResponseEntity<>(demandSkillService.getDemandSkillsBySkillId(skillId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/demandSkills")
    public ResponseEntity<List<DemandSkill>> getAllDemandSkills() {
        try {
            return new ResponseEntity<>(demandSkillService.getAllDemandSKills(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/demandSkills/{id}")
    public ResponseEntity<DemandSkill> updateDemandSkill(@PathVariable("id") long demandSkillId, @RequestBody DemandSkill demandSkill) {
        try {
            return new ResponseEntity<>(demandSkillService.updateDemandSkill(demandSkillId, demandSkill), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/demandSkills/{id}")
    public ResponseEntity<DemandSkill> deleteDemandSKill(@PathVariable("id") long demandSkillId) {
        try {
            demandSkillService.deleteDemandSKill(demandSkillId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/demandSkills")
    public ResponseEntity<DemandSkill> deleteAllDemandSkills() {
        demandSkillService.deleteAllDemandSkills();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}