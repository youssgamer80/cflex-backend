/*package projet.cflex.oda_cflex_smart_city1.Repository;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReplaceOneModel;
import com.mongodb.client.model.WriteModel;
import projet.cflex.oda_cflex_smart_city1.Model.Position;
import org.bson.BsonDocument;
import org.bson.BsonNull;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Accumulators.avg;
import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.in;
import static com.mongodb.client.model.ReturnDocument.AFTER;
import static java.util.Arrays.asList;

@Repository
public class MongoDBPositionRepository implements PositionRepository {

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
                                                                           .readPreference(ReadPreference.primary())
                                                                           .readConcern(ReadConcern.MAJORITY)
                                                                           .writeConcern(WriteConcern.MAJORITY)
                                                                           .build();
    private final MongoClient client;
    private MongoCollection<Position> positionCollection;

    public MongoDBPositionRepository(MongoClient mongoClient) {
        this.client = mongoClient;
    }

    @PostConstruct
    void init() {
        positionCollection = client.getDatabase("bd_smart_city1").getCollection("positions", Position.class);
    }

    @Override
    public Position save(Position position) {
        position.setUserId(new ObjectId());
        positionCollection.insertOne(position);
        return position;
    }


    @Override
    public List<Position> saveAll(List<Position> positions) {
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(() -> {
                positions.forEach(p -> p.setUserId(new ObjectId()));
                positionCollection.insertMany(clientSession, positions);
                return positions;
            }, txnOptions);
        }
    }

    @Override
    public List<Position> findAll() {
        return positionCollection.find().into(new ArrayList<>());
    }

    @Override
    public List<Position> findAll(List<String> ids) {
        return positionCollection.find(in("_id", mapToObjectIds(ids))).into(new ArrayList<>());
    }

    @Override
    public Position findOne(String id) {
        return positionCollection.find(eq("_id", new ObjectId(id))).first();
    }


    @Override
    public Position update(Position position) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().returnDocument(AFTER);
        return positionCollection.findOneAndReplace(eq("_id", position.getUserId()), position, options);
    }


    private List<ObjectId> mapToObjectIds(List<String> ids) {
        return ids.stream().map(ObjectId::new).collect(Collectors.toList());
    }
}
*/