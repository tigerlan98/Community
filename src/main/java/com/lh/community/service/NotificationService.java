package com.lh.community.service;

import com.lh.community.dto.NotificationDTO;
import com.lh.community.dto.PaginationDTO;
import com.lh.community.model.User;

/**
 * @author lanhu
 * @create 2020-01-26 2:27
 */
public interface NotificationService {
    PaginationDTO list(Long id, Integer page, Integer size);

    Long unreadCount(Long id);

    NotificationDTO read(Long id, User user);
}
