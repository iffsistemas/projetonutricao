package service;


import javax.ejb.Stateless;

import modelo.Schedule;

@Stateless
public class ScheduleService extends GenericService<Schedule>{
	
	
	public ScheduleService(){
		super(Schedule.class);
	}






}
