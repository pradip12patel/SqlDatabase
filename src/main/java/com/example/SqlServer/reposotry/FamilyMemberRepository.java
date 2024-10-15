package com.example.SqlServer.reposotry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SqlServer.model.FamilyMember;

public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Long> {
	
}

