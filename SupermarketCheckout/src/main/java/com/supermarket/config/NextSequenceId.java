package com.supermarket.config;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.supermarket.collections.CustomSequences;

/**
 * Provides the @service class to generate a sequence id for items colleciton
 *
 */
@Service
public class NextSequenceId {
	@Autowired private MongoOperations mongo;

    public int getNextSequence(String seqName)
    {
        CustomSequences counter = mongo.findAndModify(
            query(where("_id").is(seqName)),
            new Update().inc("seq",1),
            options().returnNew(true).upsert(true),
            CustomSequences.class);
        return counter.getSeq();
    }
}
