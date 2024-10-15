package com.example.SqlServer.ontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SqlServer.model.FamilyMember;
import com.example.SqlServer.seriveImpl.FamilyMemberService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/family")
public class FamilyMemberController {

    @Autowired
    private FamilyMemberService familyMemberService;

    // GET: Fetch all family members
    @CrossOrigin(origins = "http://localhost:8083") // Adjust as needed
    @GetMapping("/members")
    public List<FamilyMember> getAllFamilyMembers() {
        return familyMemberService.getAllFamilyMembers();
    }

    // GET: Fetch a family member by ID
    @CrossOrigin(origins = "http://localhost:8083") 
    @GetMapping("/member/{id}")
    public Optional<FamilyMember> getFamilyMemberById(@PathVariable Long id) {
        return familyMemberService.getFamilyMemberById(id);
    }

    // POST: Create a new family member
    @CrossOrigin(origins = "http://localhost:8083") 
    @PostMapping("/member")
    public List<FamilyMember>  createFamilyMember(@RequestBody FamilyMember familyMember) {
    	
        return familyMemberService.createFamilyMember(familyMember);
    }

    // PUT: Update an existing family member by ID
    @CrossOrigin(origins = "http://localhost:8083") 
    @PutMapping("/member/update/{id}")
    public ResponseEntity<FamilyMember> updateFamilyMember(@PathVariable Long id, @RequestBody FamilyMember updatedMember) {
        
        FamilyMember savedMember = familyMemberService.updateFamilyMember(id, updatedMember);
        return ResponseEntity.ok(savedMember);
    }
}

