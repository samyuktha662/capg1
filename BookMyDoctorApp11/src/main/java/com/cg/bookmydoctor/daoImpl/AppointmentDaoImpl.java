package com.cg.bookmydoctor.daoImpl;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.cg.bookmydoctor.dao.IAppointmentDao;
import com.cg.bookmydoctor.dto.Appointment;
import com.cg.bookmydoctor.dto.AvailabilityDates;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.repository.AppointmentRepository;
public abstract class AppointmentDaoImpl implements IAppointmentDao{
	private static final Logger logger = LoggerFactory.getLogger(AppointmentDaoImpl.class);
	@Autowired
	private AppointmentRepository apprep;
	public AppointmentDaoImpl() {  	 }
	public List<Appointment> getAllAppointments(){
		try {
			List<Appointment> list = new ArrayList<>();
			List<Appointment> result = apprep.findAll();
			for (Appointment ap : result) {
				list.add(ap);
			}
			return list;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	public Appointment getAppointment(int appointmentId) {

		try {
			return apprep.getAp(appointmentId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	public boolean deleteAppointment(int appointmentId) {
		try {
			apprep.deleteById(appointmentId);
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return false;
	}
	
		
	public boolean updateAppointment(Appointment bean) {
		try {
			apprep.save(bean);
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return false;
	}
	public List <Appointment> getAppointments(Doctor doc) {
		try {
			List<Appointment> list = new ArrayList<>();
			List<Appointment> result = apprep.findAll();
			for(Appointment ap : result) {
				list.add(ap);
				
		} 
			return list;
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	}
