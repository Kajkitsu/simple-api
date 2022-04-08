package pl.edu.wat.repo.api.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wat.repo.api.entities.Announcement;

import javax.validation.constraints.Null;
import java.util.Set;
import java.util.stream.Stream;

@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AnnouncementSpecialRepository {
//    private final EntityManager em;

    public Stream<Announcement> findByNullableArgs(Double minLong,
                                                   Double maxLong,
                                                   Double minLati,
                                                   Double maxLati,
                                                   Boolean isTakenType,
                                                   @Null Double maxPrice,
                                                   @Null Set<String> categoryIds,
                                                   @Null Set<String> speciesIds,
                                                   @Null Boolean isOrganization) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<AnnouncementEntity> cq = cb.createQuery(AnnouncementEntity.class);
//
//        Root<AnnouncementEntity> annoucement = cq.from(AnnouncementEntity.class);
//
//        if (minLong != null && maxLong != null && minLati != null && maxLati != null) {
//            cq.where(cb.and(
//                    cb.between(annoucement.get("place").get("latitude"), minLati, maxLati),
//                    cb.between(annoucement.get("place").get("longitude"), minLong, maxLong)));
//        }
//        if (isTakenType != null) {
//            cq.where(cb.equal(annoucement.get("isTakeType"), isTakenType));
//        }
//        if (maxPrice != null) {
//            cq.where(cb.le(annoucement.get("price"), maxPrice));
//        }
//        if (isOrganization != null) {
//            cq.where(cb.equal(annoucement.get("owner").get("isOrganization"), isOrganization));
//        }
//        if (categoryIds != null) {
//            cq.where(categoryIds.stream()
//                    .map(id -> cb.equal(annoucement.get("category").get("id"),id))
//                    .reduce(cb::or)
//                    .orElse(null));
//        }
//        if (speciesIds != null) {
//            cq.where(speciesIds.stream()
//                    .map(id -> cb.equal(annoucement.get("species").get("id"),id))
//                    .reduce(cb::or)
//                    .orElse(null));
//        }
//        TypedQuery<AnnouncementEntity> query = em.createQuery(cq);
//        return query.getResultStream();
        return null;
    }

}
