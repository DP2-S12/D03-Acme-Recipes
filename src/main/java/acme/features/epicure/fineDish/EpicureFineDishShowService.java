package acme.features.epicure.fineDish;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.fineDish.FineDish;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Epicure;


@Service
public class EpicureFineDishShowService implements AbstractShowService<Epicure, FineDish> {

	
	

	@Autowired
	protected EpicureFineDishRepository repository;


	
	
	@Override
	public boolean authorise(final Request<FineDish> request) {
		assert request != null;

		int id = request.getPrincipal().getActiveRoleId();
		Collection<FineDish> finedishs = this.repository.findAllFineDishByEpicureId(id);
		int finedish_id = request.getModel().getInteger("id");
		FineDish finedish = this.repository.findFineDishById(finedish_id);
		return finedishs.contains(finedish);
	}

	@Override
	public FineDish findOne(final Request<FineDish> request) {
		assert request != null;

		FineDish result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findFineDishById(id);


		return result;
	} 

	@Override
	public void unbind(final Request<FineDish> request, final FineDish entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		
		request.unbind(entity, model, "status", "code", "request", "budget",  "startsAt", "finishesAt",  "link", "chef.organisation","chef.assertion","chef.link");
		
	}

}
