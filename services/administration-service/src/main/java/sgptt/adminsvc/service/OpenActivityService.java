package sgptt.adminsvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sgptt.adminsvc.repository.ActivityRepository;
import sgptt.adminsvc.entity.Activity;
import sgptt.adminsvc.request.ActivityRequest;

@Service
public class OpenActivityService {

    private final ActivityRepository activityRepository;

    @Autowired
    public OpenActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public void openActivity(ActivityRequest activityRequest) {
        Activity activity = new Activity();
        activity.setOpenDate(activityRequest.getStartDate());
        activity.setCloseDate(activityRequest.getEndDate());
        activity.setActivity(activityRequest.getActivity());
        activityRepository.save(activity);
    }
}
