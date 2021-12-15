package com.example.shortening.urls.repository;

import com.example.shortening.urls.entity.ShortUrls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface ShortUrlRepository extends JpaRepository<ShortUrls, Long> {

    Optional<ShortUrls> findByOrgUrl(String orgUrl);

    @Transactional
    @Modifying
    @Query("update ShortUrls set callCount = callCount + 1 where uid = :uid")
    int incrementCallCount(Long uid);
}
