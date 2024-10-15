package com.example.SqlServer.seriveImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SqlServer.model.FamilyMember;
import com.example.SqlServer.reposotry.FamilyMemberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FamilyMemberService {

    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    public List<FamilyMember> getAllFamilyMembers() {
        return familyMemberRepository.findAll();
    }

    public Optional<FamilyMember> getFamilyMemberById(Long id) {
        return familyMemberRepository.findById(id);
    }

    public List<FamilyMember> createFamilyMember(FamilyMember familyMember) {
    	
        return (List<FamilyMember>) familyMemberRepository.save(familyMember);
    }

    public FamilyMember updateFamilyMember(Long id, FamilyMember updatedMember) {
    	
        return familyMemberRepository.findById(id).map(member -> {
            member.setFirstName(updatedMember.getFirstName());
            member.setLastName(updatedMember.getLastName());
            member.setAge(updatedMember.getAge());
            member.setRelation(updatedMember.getRelation());
            member.setEmail(updatedMember.getEmail());
            
            return familyMemberRepository.save(member);
            
        }).orElseThrow(() -> new RuntimeException("Family member not found with id: " + id));
    }
}

