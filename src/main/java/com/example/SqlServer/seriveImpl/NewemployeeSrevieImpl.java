package com.example.SqlServer.seriveImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SqlServer.model.NewEmployee;
import com.example.SqlServer.reposotry.Newemployeereposotory;
import com.example.SqlServer.servie.NewemployeeServie;


@Service
public class NewemployeeSrevieImpl implements NewemployeeServie{
	
	private Newemployeereposotory newemployeereposotory;

	@Override
	public NewEmployee saveemployee(NewEmployee newemployee) {
		
		return newemployeereposotory.save(newemployee);
	}
	
	public NewemployeeSrevieImpl(Newemployeereposotory newemployeereposotory) {
		super();
		this.newemployeereposotory = newemployeereposotory;
	}

	
	

}
