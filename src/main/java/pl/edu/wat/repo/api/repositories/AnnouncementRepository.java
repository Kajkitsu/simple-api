package pl.edu.wat.repo.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wat.repo.api.entities.Announcement;

@Repository
public interface AnnouncementRepository extends MongoRepository<Announcement, String> {
//    Iterable<AnnouncementEntity> findAllByLongitudeBetweenAndLatitudeBetweenAndIsTakeType(Double minLong, Double maxLong, Double minLati, Double maxLati, Boolean isTakenType);
//
//    Iterable<AnnouncementEntity> findAllByLongitudeBetweenAndLatitudeBetween(Double minLong, Double maxLong, Double minLati, Double maxLati);
//
//    Iterable<AnnouncementEntity> findAllByIsTakeType(Boolean isTakenType);
//
//
//    Iterable<AnnouncementEntity> findSpecial(){
//        this.
//    }
//
//    //TODO ADD params//TODO ADD params//TODO ADD params//TODO ADD params//TODO ADD params
//
//    default Iterable<AnnouncementEntity> findAllWithParams(Double minLong, Double maxLong, Double minLati, Double maxLati, Boolean isTakenType, @Null Double maxPrice, @Null Set<String> categoryId, @Null Set<String> speciesId) { //TODO ADD params
//        if(maxPrice!=null){
//            if(categoryId!=null){
//                if(speciesId!=null){
//
//                }
//                else {
//
//                }
//            }
//            else {
//                if(speciesId!=null){
//
//                }
//                else {
//
//                }
//
//            }
//        }
//        else {
//            if(categoryId!=null){
//                if(speciesId!=null){
//
//                }
//                else {
//
//                }
//            }
//            else {
//                if(speciesId!=null){
//
//                }
//                else {
//                    findAllWithParams(minLong,maxLong,minLati,maxLati,isTakenType);
//                }
//            }
//        }
//    }
//
//    default Iterable<AnnouncementEntity> findAllWithParams(Double minLong, Double maxLong, Double minLati, Double maxLati, Boolean isTakenType) { //TODO ADD params
//        if (minLong != null && maxLong != null && minLati != null && maxLati != null) {
//            if (isTakenType != null) {
//                return findAllByLongitudeBetweenAndLatitudeBetweenAndIsTakeType(minLong, maxLong, minLati, maxLati, isTakenType);
//            } else {
//                return findAllByLongitudeBetweenAndLatitudeBetween(minLong, maxLong, minLati, maxLati);
//            }
//        }
//        else {
//            if (isTakenType != null) {
//                return findAllByIsTakeType(isTakenType);
//            } else {
//                return findAll();
//            }
//        }
//    }

}
