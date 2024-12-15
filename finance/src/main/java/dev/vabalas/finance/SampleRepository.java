package dev.vabalas.finance;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SampleRepository extends MongoRepository<Sample, ObjectId> {
}
