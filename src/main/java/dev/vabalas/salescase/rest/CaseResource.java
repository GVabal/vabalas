package dev.vabalas.salescase.rest;

import dev.vabalas.app.rest.RestExceptionResponse;
import dev.vabalas.salescase.CaseStatus;
import dev.vabalas.salescase.rest.response.CaseSummary;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Map;

@Path("/cases")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class CaseResource {

    private static Map<String, CaseSummary> FAKE_DB = Map.of(
            "1000005", new CaseSummary("1000005", CaseStatus.INITIALIZED),
            "1000004", new CaseSummary("1000004", CaseStatus.CREDIT_APPROVED),
            "1000003", new CaseSummary("1000003", CaseStatus.CREDIT_DECISION_IN_PROGRESS),
            "1000002", new CaseSummary("1000002", CaseStatus.CREDIT_REJECTED),
            "1000001", new CaseSummary("1000001", CaseStatus.CANCELLED));

    @GET
    public List<CaseSummary> getAll() {
        return FAKE_DB.values()
                .stream()
                .toList();
    }

    @GET
    @Path("/{caseId}")
    public Object getOne(@PathParam("caseId") String caseId) {
        if (!FAKE_DB.containsKey(caseId)) {
            return new RestExceptionResponse(404, "No case with id " + caseId);
        }
        return FAKE_DB.get(caseId);
    }
}
