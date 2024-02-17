package dev.vabalas.salescase.rest.response;

import dev.vabalas.salescase.CaseStatus;

public record CaseSummary(String caseId, CaseStatus caseStatus) {
}
