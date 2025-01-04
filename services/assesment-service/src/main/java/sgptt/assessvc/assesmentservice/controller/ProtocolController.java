package sgptt.assessvc.assesmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sgptt.assessvc.assesmentservice.request.AssignProtocolRequest;
import sgptt.assessvc.assesmentservice.request.ProtocolAssessmentRequest;
import sgptt.assessvc.assesmentservice.security.RequiresRole;
import sgptt.assessvc.assesmentservice.service.AssignProtocolService;
import sgptt.assessvc.assesmentservice.service.ProtocolAssessmentService;

@RestController
@RequestMapping("/api/assessment")
public class ProtocolController {

    private final ProtocolAssessmentService protocolAssessmentService;
    private final AssignProtocolService assignProtocolService;

    @Autowired
    public ProtocolController(ProtocolAssessmentService protocolAssessmentService, AssignProtocolService assignProtocolService) {
        this.protocolAssessmentService = protocolAssessmentService;
        this.assignProtocolService = assignProtocolService;
    }

    @PutMapping("/evaluate")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequiresRole({"Professor"})
    public void evaluateProtocol(@RequestBody ProtocolAssessmentRequest protocolAssessmentRequest) {
        protocolAssessmentService.evaluate(protocolAssessmentRequest);
    }

    @PutMapping("/assign")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequiresRole({"Catt"})
    public void assignProtocol(@RequestBody AssignProtocolRequest assignProtocolRequest) {
        assignProtocolService.assign(assignProtocolRequest);
    }
}
