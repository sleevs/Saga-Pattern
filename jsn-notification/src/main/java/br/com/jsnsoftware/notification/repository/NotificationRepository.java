package br.com.jsnsoftware.notification.repository;

import br.com.jsnsoftware.notification.model.NotificationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationModel, Long> {
}
