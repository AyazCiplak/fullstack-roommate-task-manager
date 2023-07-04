package com.ayaz.roommatesystemapi.services;

import com.ayaz.roommatesystemapi.entity.RoommateEntity;
import com.ayaz.roommatesystemapi.model.Roommate;
import com.ayaz.roommatesystemapi.repository.RoommateRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class RoommateServiceImpl implements RoommateService{

    private RoommateRepository roommateRepository;
    public RoommateServiceImpl(RoommateRepository roommateRepository) {
        this.roommateRepository = roommateRepository;
    }

  @Override
  public Roommate createRoommate(Roommate roommate) {
        RoommateEntity roommateEntity = new RoommateEntity();

        BeanUtils.copyProperties(roommate, roommateEntity);
        roommateRepository.save(roommateEntity);
        return roommate;
    }

}
