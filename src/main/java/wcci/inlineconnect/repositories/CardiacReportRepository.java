package wcci.inlineconnect.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import wcci.inlineconnect.models.CardiacReport;
@Repository
public interface CardiacReportRepository extends CrudRepository<CardiacReport, Long> {

}
