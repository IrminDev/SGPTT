package sgptt.assessvc.assesmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sgptt.assessvc.assesmentservice.request.AssignProtocolRequest;
import sgptt.assessvc.assesmentservice.request.ProtocolAssessmentRequest;
import sgptt.assessvc.assesmentservice.response.AllEvaluationsResponse;
import sgptt.assessvc.assesmentservice.response.EvaluationResponse;
import sgptt.assessvc.assesmentservice.response.EvaluationsByProfessorResponse;
import sgptt.assessvc.assesmentservice.response.EvaluationsByProtocolResponse;
import sgptt.assessvc.assesmentservice.security.RequiresRole;
import sgptt.assessvc.assesmentservice.service.AssignProtocolService;
import sgptt.assessvc.assesmentservice.service.ProtocolAssessmentService;
import sgptt.assessvc.assesmentservice.service.GetEvaluationsService;

import java.util.List;

@RestController
@RequestMapping("/api/assessment")
public class ProtocolController {

    private final ProtocolAssessmentService protocolAssessmentService;
    private final GetEvaluationsService getEvaluationsService;
    private final AssignProtocolService assignProtocolService;

    @Autowired
    public ProtocolController(ProtocolAssessmentService protocolAssessmentService, AssignProtocolService assignProtocolService, GetEvaluationsService getEvaluationsService) {
        this.protocolAssessmentService = protocolAssessmentService;
        this.assignProtocolService = assignProtocolService;
        this.getEvaluationsService = getEvaluationsService;
    }

    @PutMapping("/evaluate")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequiresRole({"Professor"})
    public void evaluateProtocol(@RequestBody ProtocolAssessmentRequest protocolAssessmentRequest) {
        protocolAssessmentService.evaluate(protocolAssessmentRequest);
    }

    @GetMapping("/evaluations/protocol/{protocolId}")
    @ResponseStatus(HttpStatus.OK)
    @RequiresRole({"Student", "Professor", "Catt"})
    public List<EvaluationsByProtocolResponse> getEvaluationsByProtocol(@PathVariable Long protocolId) {
        return getEvaluationsService.getEvaluationsByProtocol(protocolId);
    }

    @GetMapping("/evaluations/all")
    @ResponseStatus(HttpStatus.OK)
    @RequiresRole({"Catt"})
    public List<AllEvaluationsResponse> getAllEvaluations() {
        return getEvaluationsService.getAllEvaluations();
    }

    @GetMapping("/evaluations/professor/{personId}")
    @ResponseStatus(HttpStatus.OK)
    @RequiresRole({"Professor", "Catt"})
    public List<EvaluationsByProfessorResponse> getEvaluationsByProfessor(@PathVariable Long personId) {
        return getEvaluationsService.getEvaluationsByProfessor(personId);
    }

    @GetMapping("/evaluations/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    @RequiresRole({"Professor", "Catt"})
    public EvaluationResponse getEvaluationById(@PathVariable Long id) {
        return getEvaluationsService.getEvaluationById(id);
    }

    @DeleteMapping("/delete/{protocolId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequiresRole({"Student", "Catt"})
    public void deleteEvaluationsByProtocol(@PathVariable Long protocolId) {
        getEvaluationsService.deleteEvaluationsByProtocol(protocolId);
    }

    @PutMapping("/assign")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequiresRole({"Catt"})
    public void assignProtocol(@RequestBody AssignProtocolRequest assignProtocolRequest) {
        assignProtocolService.assign(assignProtocolRequest);
    }
}
